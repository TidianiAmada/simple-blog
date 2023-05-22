package com.esp.simpleblog_app

import android.app.Dialog
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ArticleDetails(private val adapter: ArticleAdapter,
                     private val currentArticle: Article
) : Dialog(adapter.context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.article_details)
        setupComponents()
        setupReturnButton()
    }
    private fun setupReturnButton() {

        val icRetour = findViewById<ImageView>(R.id.ic_retour)
        icRetour.setOnClickListener{
            dismiss()
        }
    }
    private fun setupComponents() {
        //Actualiser l'article
        val titleArticle = findViewById<TextView>(R.id.titre_a)
        titleArticle.text = currentArticle.titre

        val auteur = findViewById<TextView>(R.id.auteur_a)
        auteur.text = currentArticle.auteur

        val datePub = findViewById<TextView>(R.id.datePublication_a)
        datePub.text = currentArticle.datePublication

        val desc = findViewById<TextView>(R.id.contenu_a)
        desc.text = currentArticle.contenu
    }
}