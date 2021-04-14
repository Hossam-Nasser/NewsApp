package com.androiddevs.mvvmallnewsapp.respository

import com.androiddevs.mvvmallnewsapp.api.RetrofitInstance
import com.androiddevs.mvvmallnewsapp.db.ArticleDatabase
import com.androiddevs.mvvmallnewsapp.models.Article


class NewsRepository(
    val db:ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)
    
    suspend fun searchNews(searchQuery:String , pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun upsert(article:Article) =db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)

}