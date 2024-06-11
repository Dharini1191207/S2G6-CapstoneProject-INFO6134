package com.example.pureattire_capstoneproject_info6134.di

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth() = FirebaseAuth.getInstance()

//    @Provides
//    @Singleton
//    fun provideFirebaseFirestoreDatabase() = FirebaseAuthebase.firestore

//    @Provides
//    fun provideIntroductionSP(
//        application: Application
//    ) = application.getSharedPreferences(INTRODUCTION_SP, MODE_PRIVATE)
//
//    @Provides
//    @Singleton
//    fun provideFirebaseCommon(
//        firebaseAuth: FirebaseAuth,
//        firestore: FirebaseFirestore
//    ) = FirebaseCommon(firestore,firebaseAuth)
//
//    @Provides
//    @Singleton
//    fun provideStorage() = FirebaseStorage.FirebaseStoragegetInstance().reference
}
