package com.example.quizapp.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object QuizApi {
    private const val BASE_URL = "https://quizzapi.jomoreschi.fr/"

    // Service Retrofit pour l'API Quiz
    val service: QuizApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuizApiService::class.java)
    }
}