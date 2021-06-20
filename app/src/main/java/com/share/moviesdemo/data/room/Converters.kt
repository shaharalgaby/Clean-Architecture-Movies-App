package com.share.moviesdemo.data.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.share.moviesdemo.data.models.Genre

class Converters {

    @TypeConverter
    fun fromGenresToString(genres: ArrayList<Genre?>?) = Gson().toJson(genres)

    @TypeConverter
    fun fromStringToGenres(genre: String): ArrayList<Genre?>? {
        val listType = object : TypeToken<ArrayList<Genre>>() {}.type
        return Gson().fromJson(genre, listType)
    }

}