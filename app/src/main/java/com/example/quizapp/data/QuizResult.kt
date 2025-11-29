package com.example.quizapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// Entité Room pour stocker les résultats du quiz
@Entity(tableName = "quiz_results")
data class QuizResult(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val username: String,
    val score: Int,
    val totalQuestions: Int,
    val category: String,
    val difficulty: String,
    val date: Long // timestamp pour l’historique
)