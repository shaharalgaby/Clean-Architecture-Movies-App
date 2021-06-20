package com.share.moviesdemo.ui.movie_list

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.share.moviesdemo.R
import com.share.moviesdemo.data.models.Movie
import com.share.moviesdemo.databinding.FragmentMovieListItemBinding

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
        binding.root.findNavController().navigate(
            R.id.action_movieListFragment_to_movieDetailsFragment,
            Bundle().also { it.putLong("movie_id", binding.movie?.id?.toLong() ?: 0) }
        )
    }
}