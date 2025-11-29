package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.quizapp.data.DatabaseProvider
import com.example.quizapp.data.Quiz
import com.example.quizapp.data.QuizApi
import com.example.quizapp.data.QuizResult
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var tvQuestion: TextView
    private lateinit var rgOptions: RadioGroup
    private lateinit var btnSubmit: MaterialButton

    private var quizzes: List<Quiz> = emptyList()
    private var currentIndex = 0
    private var score = 0

    private lateinit var username: String
    private lateinit var category: String
    private lateinit var difficulty: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvQuestion = findViewById(R.id.tvQuestion)
        rgOptions = findViewById(R.id.rgOptions)
        btnSubmit = findViewById(R.id.btnSubmit)

        username = intent.getStringExtra("username") ?: "Joueur"
        category = intent.getStringExtra("category") ?: ""
        difficulty = intent.getStringExtra("difficulty") ?: ""

        // Lancer le chargement des questions
        loadAndDisplayQuestions()

        btnSubmit.setOnClickListener {
            handleAnswerSubmission()
        }
    }

    private fun loadAndDisplayQuestions() {
        lifecycleScope.launch { // Pas besoin de Dispatchers.IO ici si Retrofit est bien configuré
            try {
                // Utilisation de withContext pour le travail en arrière-plan
                val response = withContext(Dispatchers.IO) {
                    QuizApi.service.getQuizzes(limit = 5, category = category, difficulty = difficulty)
                }
                quizzes = response.quizzes

                // Afficher la première question sur le thread principal
                if (quizzes.isNotEmpty()) {
                    showQuestion()
                } else {
                    Toast.makeText(this@MainActivity, "Aucun quiz trouvé pour ces critères.", Toast.LENGTH_LONG).show()
                    finish() // Terminer l'activité si aucun quiz n'est chargé
                }

            } catch (e: Exception) {
                // L'exception sera déjà sur le thread principal si withContext échoue
                Toast.makeText(this@MainActivity, "Erreur API : ${e.message}", Toast.LENGTH_LONG).show()
                e.printStackTrace() // Utile pour le débogage
            }
        }
    }

    private fun showQuestion() {
        // S'assurer que l'index est valide pour éviter un crash
        if (currentIndex >= quizzes.size) return

        val quiz = quizzes[currentIndex]
        tvQuestion.text = quiz.question

        rgOptions.clearCheck() // Désélectionner les boutons
        rgOptions.removeAllViews() // Nettoyer les anciennes options

        // CORRECTION : Créer une liste d'options valide
        val options = quiz.badAnswers.toMutableList() // Crée une liste modifiable des mauvaises réponses
        options.add(quiz.answer) // Ajoute la bonne réponse à la liste
        options.shuffle() // Mélange la liste complète

        options.forEach { optionText ->
            val rb = RadioButton(this).apply {
                text = optionText
                // Amélioration : ajouter un peu de style
                textSize = 18f
                setPadding(20, 20, 20, 20)
            }
            rgOptions.addView(rb)
        }
    }

    @SuppressLint("StringFormatInvalid")
    private fun handleAnswerSubmission() {
        val selectedId = rgOptions.checkedRadioButtonId
        if (selectedId == -1) {
            Toast.makeText(this, getString(R.string.choose_answer), Toast.LENGTH_SHORT).show()
            return
        }

        val selectedRadioButton = findViewById<RadioButton>(selectedId)
        val selectedAnswer = selectedRadioButton.text.toString()
        val correctAnswer = quizzes[currentIndex].answer

        if (selectedAnswer == correctAnswer) {
            score++
            Toast.makeText(this, getString(R.string.correct_answer), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, getString(R.string.wrong_answer, correctAnswer), Toast.LENGTH_SHORT).show()
        }

        currentIndex++
        if (currentIndex < quizzes.size) {
            showQuestion()
        } else {
            saveResultAndGoToResult()
        }
    }

    private fun saveResultAndGoToResult() {
        lifecycleScope.launch(Dispatchers.IO) {
            val dao = DatabaseProvider.getDatabase(this@MainActivity).quizResultDao()
            val result = QuizResult(
                username = username,
                score = score,
                totalQuestions = quizzes.size,
                category = category,
                difficulty = difficulty,
                date = System.currentTimeMillis()
            )
            dao.insertResult(result)

            // CORRECTION : Utilisation du contexte approprié pour l'Intent
            withContext(Dispatchers.Main) {
                val intent = Intent(this@MainActivity, ResultActivity::class.java).apply {
                    putExtra("score", score)
                    putExtra("totalQuestions", quizzes.size)
                }
                startActivity(intent)
                finish()
            }
        }
    }
}
