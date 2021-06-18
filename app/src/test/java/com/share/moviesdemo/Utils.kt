package com.share.moviesdemo

import com.share.moviesdemo.data.Movie

object Utils {
    fun mockMovie(id: Int) = Movie(
        id = id,
        title = "Fight Club",
        releaseDate = "2019",
        overview = "Under the direction of a ruthless instructor, a talented young drummer begins to pursue perfection at any cost, even his humanity.",
        backdrop = "/6bbZ6XyvgfjhQwbplnUh1LSj1ky.jpg",
        poster = "/lIv1QinFqz4dlp5U4lQ6HaiskOZ.jpg",
        popularity = 10.3,
        voteCount = 3332,
        voteAverage = 8.32,
        tag = "How much can you know about yourself if you've never been in a fight?"
    )

    fun mockMovieList() = listOf(mockMovie(1), mockMovie(2), mockMovie(3))
}