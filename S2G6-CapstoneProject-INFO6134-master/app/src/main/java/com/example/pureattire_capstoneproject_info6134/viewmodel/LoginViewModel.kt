package com.example.pureattire_capstoneproject_info6134.viewmodel
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pureattire_capstoneproject_info6134.data.User
import com.example.pureattire_capstoneproject_info6134.util.RegisterFieldsState
import com.example.pureattire_capstoneproject_info6134.util.RegisterValidation
import com.example.pureattire_capstoneproject_info6134.util.Resource
import com.example.pureattire_capstoneproject_info6134.util.validateEmail
import com.example.pureattire_capstoneproject_info6134.util.validatePassword
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : ViewModel(){
    private val _login = MutableSharedFlow<Resource<FirebaseUser>>()
    val login = _login.asSharedFlow()

    private val _resetPassword = MutableSharedFlow<Resource<String>>()
    val resetPassword = _resetPassword.asSharedFlow()
    private val _validation = Channel<RegisterFieldsState>()
    val validation = _validation.receiveAsFlow()

    fun login(email: String, password: String) {
        if(checkValidation(email,password)){
            viewModelScope.launch { _login.emit(Resource.Loading()) }
            firebaseAuth.signInWithEmailAndPassword(
                email, password
            ).addOnSuccessListener {
                viewModelScope.launch {
                    it.user?.let {
                        _login.emit(Resource.Success(it))
                    }
                }
            }.addOnFailureListener {
                viewModelScope.launch {
                    //Log.e("testinggg",it.message.toString())
                    _login.emit(Resource.Error("Invalid Credential"))
                }
            }
        }else{
            val registerFieldsState = RegisterFieldsState(
                validateEmail(email), validatePassword(password)
            )
            runBlocking {
                _validation.send(registerFieldsState)
            }
        }

    }
    private fun checkValidation(email: String, password: String): Boolean {
        val emailValidation = validateEmail(email)
        val passwordValidation = validatePassword(password)
        val shouldRegister = emailValidation is RegisterValidation.Success &&
                passwordValidation is RegisterValidation.Success

        return shouldRegister
    }
    fun resetPassword(email: String) {
        viewModelScope.launch {
            _resetPassword.emit(Resource.Loading())
        }

        firebaseAuth
            .sendPasswordResetEmail(email)
            .addOnSuccessListener {
                viewModelScope.launch {
                    _resetPassword.emit(Resource.Success(email))
                }
            }
            .addOnFailureListener {
                viewModelScope.launch {
                    _resetPassword.emit(Resource.Error(it.message.toString()))
                }
            }
    }

}