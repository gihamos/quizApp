package com.example.quizapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.quizapp.data.DatabaseProvider
import com.example.quizapp.data.QuizResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HistoryActivity : AppCompatActivity() {

    private lateinit var lvHistory: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        lvHistory = findViewById(R.id.lvHistory)

        // Charger les résultats depuis la base Room
        lifecycleScope.launch(Dispatchers.IO) {
            val dao = DatabaseProvider.getDatabase(this@HistoryActivity).quizResultDao()
            val results = dao.getAllResults()

            withContext(Dispatchers.Main) {
                showResults(results)
            }
        }
    }

    private fun showResults(results: List<QuizResult>) {
        val items = results.map { result ->
            val dateStr = android.text.format.DateFormat.format("dd/MM/yyyy HH:mm", result.date)
            "${result.username} - Score: ${result.score}/${result.totalQuestions} - Catégorie: ${result.category} - Difficulté: ${result.difficulty} - Date: $dateStr"
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        lvHistory.adapter = adapter
    }
}