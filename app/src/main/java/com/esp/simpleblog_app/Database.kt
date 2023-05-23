package com.esp.simpleblog_app

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Database(context: Context) : SQLiteOpenHelper(context,"test.db",null,1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE articles (id INTEGER PRIMARY KEY AUTOINCREMENT, titre TEXT, auteur TEXT," +
                    " contenu TEXT, datePublication Date DEFAULT CURRENT_DATE)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
    fun ajouterArticle(article: Article){
        val values= ContentValues()
        values.put("titre",article.titre)
        values.put("auteur",article.auteur)
        values.put("contenu",article.contenu)

        writableDatabase.insert("articles",null,values)
    }
    @SuppressLint("Range")
    fun getAllArticles(): List<Article>{
        val articles= ArrayList<Article>()
        readableDatabase.rawQuery("SELECT * FROM articles",null).use {
                cursor ->  while (cursor.moveToNext()){
                    val article=Article(cursor.getString(cursor.getColumnIndex("titre")),
                        cursor.getString(cursor.getColumnIndex("auteur")),
                        cursor.getString(cursor.getColumnIndex("contenu")),
                                cursor.getString(cursor.getColumnIndex("datePublication"))
                    )
                articles.add(article)
            }
            }
        return articles
    }

    fun getArticlesCount() : Int = DatabaseUtils.queryNumEntries(readableDatabase, "articles", null).toInt()
}
