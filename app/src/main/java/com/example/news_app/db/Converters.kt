package com.example.news_app.db
import  androidx.room.TypeConverters
import com.example.news_app.models.Source

class Converters {
    @TypeConverters
    fun fromSource(source: Source): String{
        return source.name
    }

    @TypeConverters
    fun toSource(name: String): Source{
        return Source(name ,name)
    }
}