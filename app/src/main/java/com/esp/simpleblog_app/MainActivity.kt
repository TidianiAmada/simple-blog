package com.esp.simpleblog_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Database(this)
        val recyclerview= findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager=LinearLayoutManager(this)


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
        val adapter=ArticleAdapter(this,articles)
        recyclerview.adapter=adapter
        val addButton:FloatingActionButton =findViewById(R.id.ic_add)


        addButton.setOnClickListener {
            setContentView(R.layout.new_article)
            val titreEditText:EditText = findViewById(R.id.titre)
            val auteurEditText:EditText = findViewById(R.id.auteur)
            val contenuEditText:EditText= findViewById(R.id.contenu)
            val ajouterButton: Button =findViewById(R.id.button)
            ajouterButton.setOnClickListener {
                val title=titreEditText.text.toString()
                val auteur=auteurEditText.text.toString()
                val contenu=contenuEditText.text.toString()
                database.ajouterArticle(Article(title,auteur,contenu,"20/02/2022"))
                onCreate(savedInstanceState)
            }
            val closeButton:FloatingActionButton =findViewById(R.id.ic_close)
            closeButton.setOnClickListener {
                onCreate(savedInstanceState)
            }
        }


    }
}