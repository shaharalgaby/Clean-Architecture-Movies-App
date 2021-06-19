package com.share.moviesdemo.binding

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
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

@BindingAdapter("onNavigationBackClicked")
fun bindNavigationBackClicked(view: View, i: Int) {
    view.setOnClickListener { v ->
        v.findNavController().popBackStack()
    }
}

@BindingAdapter("gone")
fun bindGone(view: View, shouldBeGone: Boolean?) {
    if (shouldBeGone == true) {
        view.visibility = View.GONE
    } else {
        view.visibility = View.VISIBLE
    }
}

@BindingAdapter("showToast")
fun showToast(view: View, msg: String?) {
    if(msg.isNullOrEmpty()) return
    Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show()
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