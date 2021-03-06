package com.share.moviesdemo.ui.movie_details

import com.share.moviesdemo.data.repositories.DetailsRepository

class GetMovieDetailsByIdUseCase(private val detailsRepository: DetailsRepository) {
    operator fun invoke(id: Long) = detailsRepository.getMovieById(id)
}