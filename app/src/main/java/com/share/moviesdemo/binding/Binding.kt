package com.share.moviesdemo.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.share.moviesdemo.data.Movie
import com.share.moviesdemo.ui.movie_list.MovieListAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("adapterMovieList")
fun bindAdapterMoviesList(view: RecyclerView, movies: List<Movie>?) {
    if(view.adapter !is MovieListAdapter) return
    movies?.also { data ->
        (view.adapter as MovieListAdapter).setData(data)
    }
}

const val IMAGE_URL_POSTFIX = "https://image.tmdb.org/t/p/w500"
@BindingAdapter("loadImage")
fun bindImage(view: ImageView, imageUrl: String?) {
    if (imageUrl.isNullOrEmpty()) {
        view.setImageBitmap(null)
    } else {
        Picasso.get()
            .load(IMAGE_URL_POSTFIX + imageUrl)
            .fit()
            .centerCrop()
            .into(view)
    }
}