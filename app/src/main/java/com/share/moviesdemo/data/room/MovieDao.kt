package com.share.moviesdemo.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.share.moviesdemo.data.Movie

@Dao
interface MovieDao {

    @Query("SELECT * FROM Movie")
    suspend fun getTopRated(): List<Movie>

    @Query("SELECT * FROM Movie WHERE id = :id")
    suspend fun getMovie(id: Long): Movie

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: List<Movie>)
}