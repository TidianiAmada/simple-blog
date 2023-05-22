package com.esp.simpleblog_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ArticleAdapter(val context: MainActivity,val articles: List<Article>): RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val articleTitre = view.findViewById<TextView>(R.id.article_titre)
        val articleContenu = view.findViewById<TextView>(R.id.article_contenu)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.article_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articles.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Recuperer les informations de l'article
        val currentArticle = articles[position]

        //Mettre a jour le nom de la plante
        holder.articleTitre.text = currentArticle.titre

        //mettre a jour le nom de l'auteur
        holder.articleContenu.text = currentArticle.contenu

        //Interaction lors du clic sur un article
        holder.itemView.setOnClickListener{
            //afficher l'article
            ArticleDetails(this, currentArticle).show()
        }
    }
}