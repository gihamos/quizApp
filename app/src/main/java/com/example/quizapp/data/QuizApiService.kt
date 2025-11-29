package com.example.quizapp.data

import retrofit2.http.GET

// Modèle pour une catégorie
data class Category(
    val id: String,
    val name: String,
    val slug: String
)

interface QuizApiService {

    @GET("api/v2/quiz")
    suspend fun getQuizzes(
        @retrofit2.http.Query("limit") limit: Int,
        @retrofit2.http.Query("category") category: String?,
        @retrofit2.http.Query("difficulty") difficulty: String?
    ): QuizResponse

    // Endpoint pour les catégories
    @GET("api/v2/quiz/categories")
    suspend fun getCategories(): List<Category>
}