package com.esp.simpleblog_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

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
                "J'ai choisi l'itineraire le plus succeptible de me perdre","1975-04-12"))
            database.ajouterArticle(Article("La délivrance de l'erreur","Imam Ghazali",
                "J'ai retrouvé l'âme de la religion dans le soufisme","1075-04-12"))
        }
        val articles=database.getAllArticles();
        for (a in articles){
            Log.i("MainActivity","database article: "+ a)
        }
    }
}