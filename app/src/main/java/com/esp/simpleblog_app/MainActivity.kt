package com.esp.simpleblog_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Database(this)

        if (database.getArticlesCount()==0){
            database.ajouterArticle(
                Article("Une Si Longue lettre","Mariama Ba",
                "La confidence noie la douleur","1975-04-12")
            )
            database.ajouterArticle(Article("L'aventure ambigüe","Cheikh Hamidou Kane",
                "J'ai choisi l'itineraire  le plus succeptible de me perdre","1975-04-12"))
            database.ajouterArticle(Article("La délivrance de l'erreur","Imam Ghazali",
                "J'ai retrouvé l'âme de la religion dans le soufisme","1075-04-12"))
        }
        val articles=database.getAllArticles();
        for (a in articles){
            Log.i("MainActivity","database article: "+ a)
        }
        ArticleAdapter(this,articles)
        val button:FloatingActionButton =findViewById(R.id.floatingActionButton)
        button.setOnClickListener {
            setContentView(R.layout.new_article)
            val titreEditText:EditText = findViewById(R.id.article_titre)
            val auteurEditText:EditText = findViewById(R.id.auteur)
            val contenuEditText:EditText= findViewById(R.id.contenu)
            val ajouterButton: Button =findViewById(R.id.button)
            ajouterButton.setOnClickListener {
                val title=titreEditText.text.toString()
                val auteur=auteurEditText.text.toString()
                val contenu=contenuEditText.text.toString()
                database.ajouterArticle(Article(title,auteur,contenu,"20/02/2022"))
            }

        }

    }
}