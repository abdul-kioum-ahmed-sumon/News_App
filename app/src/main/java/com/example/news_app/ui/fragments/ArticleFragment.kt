//package com.example.news_app.ui.fragments
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.webkit.WebViewClient
//import androidx.navigation.fragment.navArgs
//import com.example.news_app.R
//import com.example.news_app.databinding.ActivityNewsBinding
//import com.example.news_app.databinding.FragmentArticleBinding
//import com.example.news_app.ui.NewsActivity
//import com.example.news_app.ui.NewsViewModel
//import com.google.android.material.snackbar.Snackbar
//
//
//class ArticleFragment : Fragment(R.layout.fragment_article) {
//
//
//    lateinit var  newsViewModel: NewsViewModel
//    val args: ArticleFragmentArgs by navArgs()
//    lateinit var  binding: FragmentArticleBinding
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding = FragmentArticleBinding.bind(view)
//
//        newsViewModel  = (activity as NewsActivity).newsViewModel
//        val article  = args.articale
//
//        binding.webView.apply {
//            webViewClient = WebViewClient()
//            article.url?.let {
//                loadUrl(it)
//            }
//        }
//        binding.fab.setOnClickListener{
//            newsViewModel.addToFavourites(article)
//            Snackbar.make(view,"Added to Bookmark", Snackbar.LENGTH_SHORT).show()
//        }
//    }
//
//
//}

package com.example.news_app.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.news_app.R
import com.example.news_app.databinding.FragmentArticleBinding
import com.example.news_app.ui.NewsActivity
import com.example.news_app.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar

class ArticleFragment : Fragment(R.layout.fragment_article) {

 lateinit var newsViewModel: NewsViewModel
   val args: ArticleFragmentArgs by navArgs() // Fixed Safe Args reference
    lateinit var binding: FragmentArticleBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticleBinding.bind(view)

        newsViewModel = (activity as NewsActivity).newsViewModel
        val article = args.article // Corrected args reference

        binding.webView.apply {
            webViewClient = WebViewClient()
            article.url?.let { loadUrl(it) }
        }

        binding.fab.setOnClickListener {
            newsViewModel.addToFavourites(article)
            Snackbar.make(view, "Added to Bookmark", Snackbar.LENGTH_SHORT).show()
        }
    }
}
