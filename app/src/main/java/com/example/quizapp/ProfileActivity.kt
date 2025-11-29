package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.quizapp.data.QuizApi
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var spCategory: Spinner
    private lateinit var spDifficulty: Spinner
    private lateinit var btnStartQuiz: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        etUsername = findViewById(R.id.etUsername)
        spCategory = findViewById(R.id.spCategory)
        spDifficulty = findViewById(R.id.spDifficulty)
        btnStartQuiz = findViewById(R.id.btnStartQuiz)

        // Charger les catégories depuis l’API
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val categories = QuizApi.service.getCategories()
                withContext(Dispatchers.Main) {
                    val adapter = ArrayAdapter(
                        this@ProfileActivity,
                        android.R.layout.simple_spinner_item,
                        categories.map { it.name } // affichage dans le Spinner
                    )
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spCategory.adapter = adapter

                    // Sauvegarde des slugs pour l’appel API
                    spCategory.tag = categories.map { it.slug }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@ProfileActivity, "Erreur chargement catégories", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Difficultés prédéfinies
        val difficulties = listOf("facile", "normal", "difficile")
        val diffAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            difficulties
        )
        diffAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spDifficulty.adapter = diffAdapter

        // Bouton démarrer quiz
        btnStartQuiz.setOnClickListener {
            val username = etUsername.text.toString().ifEmpty { "Joueur" }
            val category = spCategory.selectedItem?.toString() ?: ""
            val difficulty = spDifficulty.selectedItem?.toString() ?: ""

            if (category.isEmpty() || difficulty.isEmpty()) {
                Toast.makeText(this, "Veuillez choisir une catégorie et une difficulté", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("username", username)
                putExtra("category", category)
                putExtra("difficulty", difficulty)
            }
            startActivity(intent)
        }
    }
}