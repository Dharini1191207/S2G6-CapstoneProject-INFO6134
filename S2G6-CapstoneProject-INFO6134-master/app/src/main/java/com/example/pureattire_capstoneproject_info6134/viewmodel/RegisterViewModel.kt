package com.example.pureattire_capstoneproject_info6134.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pureattire_capstoneproject_info6134.data.User
import com.example.pureattire_capstoneproject_info6134.util.RegisterFieldsState
import com.example.pureattire_capstoneproject_info6134.util.RegisterValidation
import com.example.pureattire_capstoneproject_info6134.util.Resource
import com.example.pureattire_capstoneproject_info6134.util.validateEmail
import com.example.pureattire_capstoneproject_info6134.util.validatePassword
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : ViewModel() {

    private val _register = MutableStateFlow<Resource<User>>(Resource.Unspecified())

    val register: Flow<Resource<User>> = _register
    private val _validation = Channel<RegisterFieldsState>()
    val validation = _validation.receiveAsFlow()

    fun createAccountWithEmailAndPassword(user: User, password: String) {

        if(checkValidation(user,password)){
            runBlocking {
                _register.emit(Resource.Loading())
            }
            _register.value = Resource.Success(User())
        }else{
            val registerFieldsState = RegisterFieldsState(
                validateEmail(user.email), validatePassword(password)
            )
            runBlocking {
                _validation.send(registerFieldsState)
            }
        }
//        firebaseAuth.createUserWithEmailAndPassword(user.email, password)
//            .addOnSuccessListener {
//                it.user?.let {
//                    _register.value = Resource.Success(User())
//                }
//            }.addOnFailureListener {
//                _register.value = Resource.Error(it.message.toString())
//            }

    }
    private fun checkValidation(user: User, password: String): Boolean {
        val emailValidation = validateEmail(user.email)
        val passwordValidation = validatePassword(password)
        val shouldRegister = emailValidation is RegisterValidation.Success &&
                passwordValidation is RegisterValidation.Success

        return shouldRegister
    }

}