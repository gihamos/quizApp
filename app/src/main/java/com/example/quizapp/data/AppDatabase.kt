package com.example.quizapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

// Base de données Room regroupant les entités et DAO
@Database(entities = [QuizResult::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun quizResultDao(): QuizResultDao
}