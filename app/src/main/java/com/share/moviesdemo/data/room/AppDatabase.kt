package com.share.moviesdemo.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.share.moviesdemo.data.models.Movie

@Database(entities=[Movie::class], version = 7)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun MovieDao(): MovieDao
}