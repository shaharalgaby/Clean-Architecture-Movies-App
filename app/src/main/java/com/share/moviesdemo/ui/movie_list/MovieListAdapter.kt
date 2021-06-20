package com.share.moviesdemo.ui.movie_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.share.moviesdemo.data.models.Movie
import com.share.moviesdemo.databinding.FragmentMovieListItemBinding

class MovieListAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private val mData = mutableListOf<Movie>()

    fun setData(data: List<Movie>?) {
        if(data == null) return

        mData.clear()
        mData.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            FragmentMovieListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    override fun getItemCount(): Int {
        return mData.size
    }
}