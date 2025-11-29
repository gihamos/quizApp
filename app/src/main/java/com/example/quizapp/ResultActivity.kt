package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class ResultActivity : AppCompatActivity() {

    private lateinit var tvFinalScore: TextView
    private lateinit var btnHistory: MaterialButton
    private lateinit var btnRestart: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        tvFinalScore = findViewById(R.id.tvFinalScore)
        btnHistory = findViewById(R.id.btnHistory)
        btnRestart = findViewById(R.id.btnRestart)

        // Récupérer score et nombre de questions
        val score = intent.getIntExtra("score", 0)
        val totalQuestions = intent.getIntExtra("totalQuestions", 0)

        // Afficher le score
        tvFinalScore.text = getString(R.string.final_score, score, totalQuestions)

        // Bouton voir l’historique
        btnHistory.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }

        // Bouton recommencer
        btnRestart.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}