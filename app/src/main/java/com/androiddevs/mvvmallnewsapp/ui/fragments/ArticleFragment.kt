package com.androiddevs.mvvmallnewsapp.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.androiddevs.mvvmallnewsapp.R
import com.androiddevs.mvvmallnewsapp.ui.NewsActivity
import com.androiddevs.mvvmallnewsapp.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment :Fragment(R.layout.fragment_article) {

    lateinit var viewModel:NewsViewModel
    val args:ArticleFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        val article = args.article
        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }

        fab.setOnClickListener {
            val c: ArticleFragment = this@ArticleFragment
            viewModel.saveArticle(article)
            Snackbar.make(view, c.getString(R.string.save),Snackbar.LENGTH_SHORT).show()
        }
    }
}