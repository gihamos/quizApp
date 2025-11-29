package com.example.quizapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuizResultDao {

    // Insérer un nouveau résultat
    @Insert
    suspend fun insertResult(result: QuizResult)

    // Récupérer tous les résultats (du plus récent au plus ancien)
    @Query("SELECT * FROM quiz_results ORDER BY date DESC")
    suspend fun getAllResults(): List<QuizResult>
}