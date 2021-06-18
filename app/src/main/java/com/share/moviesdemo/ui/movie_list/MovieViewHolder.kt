package com.share.moviesdemo.ui.movie_list

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.share.moviesdemo.data.Movie
import com.share.moviesdemo.databinding.FragmentMovieListItemBinding
import kotlin.coroutines.coroutineContext

class MovieViewHolder(
    private val binding: FragmentMovieListItemBinding
) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

    init {
        binding.root.setOnClickListener(this)
    }

    fun bind(movie: Movie) {
        binding.movie = movie
        binding.executePendingBindings()
    }

    override fun onClick(v: View?) {
    }
}