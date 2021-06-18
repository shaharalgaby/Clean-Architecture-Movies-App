package com.share.moviesdemo.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.share.moviesdemo.data.Movie

@Database(entities=[Movie::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun MovieDao(): MovieDao
}