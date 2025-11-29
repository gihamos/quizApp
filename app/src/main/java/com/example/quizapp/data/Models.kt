package com.example.quizapp.data

// Réponse complète de l'API
data class QuizResponse(
    val count: Int,
    val quizzes: List<Quiz>
)


// Objet Quiz
data class Quiz(
    val id: String,
    val question: String,
    val answer: String,
    val category: String,
    val difficulty: String,
    val badAnswers: List<String>
)