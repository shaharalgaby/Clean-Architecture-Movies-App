package com.share.moviesdemo.binding

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.share.moviesdemo.data.models.Movie
import com.share.moviesdemo.ui.movie_list.MovieListAdapter
import com.squareup.picasso.Picasso
import java.lang.Exception
import java.text.NumberFormat
import java.util.*

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

@BindingAdapter("setupTextInYearView")
fun setupTextInYearView(tv: TextView, txt: String?) {
    try {
        tv.text = txt?.substring(0,4) ?: ""
    } catch (e: Exception) { }
}

@BindingAdapter("setupTextInDurationView")
fun setupTextInDurationView(tv: TextView, txt: String?) {
    try {
        val num = txt?.toInt() ?: return
        tv.text = "${num/60}h ${num%60}m"
    } catch (e: Exception) {
    }
}

@BindingAdapter("setupTextInVoteCountView")
fun setupTextInVoteCountView(tv: TextView, _txt: Int?) {
    try {
        val txt = _txt ?: 0
        tv.text = NumberFormat.getNumberInstance(Locale.getDefault()).format(txt)
    } catch (e: Exception) {
    }
}

@BindingAdapter("setupTextInGenresView")
fun setupTextInGenresView(tv: TextView, movie: Movie?) {
    tv.text = movie?.genres?.map { it?.name }?.toList()?.joinToString() ?: ""
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