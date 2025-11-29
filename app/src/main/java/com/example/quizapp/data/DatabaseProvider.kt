package com.example.quizapp.data

import android.content.Context
import androidx.room.Room

// Fournisseur de base de données (singleton)
object DatabaseProvider {
    @Volatile
    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "quiz_database"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}