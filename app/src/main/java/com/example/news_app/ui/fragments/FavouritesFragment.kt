package com.example.news_app.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.news_app.R
import com.example.news_app.adapters.NewsAdapter
import com.example.news_app.databinding.FragmentFavouritesBinding
import com.example.news_app.databinding.FragmentHeadlineBinding
import com.example.news_app.ui.NewsActivity
import com.example.news_app.ui.NewsViewModel
import com.example.news_app.ui.fragments.HeadlineFragment
import com.google.android.material.snackbar.Snackbar


class FavouritesFragment : Fragment(R.layout.fragment_favourites) {


lateinit var  newsViewModel: NewsViewModel
lateinit var newsAdapter: NewsAdapter
lateinit var  binding: FragmentFavouritesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavouritesBinding.bind(view)

        newsViewModel = (activity as NewsActivity).newsViewModel
        setupFavouritesRecycler()

        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article", it)

            }
            findNavController().navigate(R.id.action_favouritesFragment_to_articleFragment, bundle)
        }
        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN ,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
        {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
           return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position  = viewHolder.adapterPosition
                val article = newsAdapter.differ.currentList[position]
                newsViewModel.deleteArticle(article)
                Snackbar.make(view,"Remove from Bookmarks", Snackbar.LENGTH_LONG).apply {
                    setAction("Undo"){
                        newsViewModel.addToFavourites(article)
                    }
                    show()
                }
            }
        }

        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(binding.recyclerFavourites)
        }
        newsViewModel.getFavouriteNews().observe(viewLifecycleOwner, Observer { articles ->

            newsAdapter.differ.submitList(articles)
        })

    }
    private  fun setupFavouritesRecycler(){
        newsAdapter = NewsAdapter()
        binding.recyclerFavourites.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)

        }
    }


}