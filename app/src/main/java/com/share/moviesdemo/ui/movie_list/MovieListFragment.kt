package com.share.moviesdemo.ui.movie_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.share.moviesdemo.R
import com.share.moviesdemo.databinding.FragmentMovieListBinding
import com.share.moviesdemo.ui.BaseFragment
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MovieListFragment : BaseFragment<FragmentMovieListBinding>(R.layout.fragment_movie_list) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return doBinding {
            lifecycleOwner = viewLifecycleOwner
            vm = getViewModel()
            adapter = MovieListAdapter()
        }
    }
}