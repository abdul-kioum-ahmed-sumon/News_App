package com.example.news_app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.news_app.R
import com.example.news_app.databinding.ActivityNewsBinding
import com.example.news_app.db.ArticleDatabase
import com.example.news_app.repository.NewsRepository

class NewsActivity : AppCompatActivity() {


    lateinit var  newsViewModel: NewsViewModel
    lateinit var binding: ActivityNewsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application, newsRepository)
        newsViewModel = ViewModelProvider(this,viewModelProviderFactory).get(NewsViewModel::class.java)

        val navHostFragment  = supportFragmentManager.findFragmentById(R.id.newsNavHostFragment)as NavHostFragment

        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)

    }
}