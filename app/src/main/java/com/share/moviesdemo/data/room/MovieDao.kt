package com.share.moviesdemo.data.room

import androidx.room.*
import com.share.moviesdemo.data.models.Movie

@Dao
interface MovieDao {

    @Query("SELECT * FROM Movie")
    suspend fun getTopRated(): List<Movie>

    @Query("SELECT * FROM Movie WHERE id = :id")
    suspend fun getMovie(id: Long): Movie

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(movies: List<Movie>)

    @Update
    suspend fun updateMovie(movie: Movie)
}