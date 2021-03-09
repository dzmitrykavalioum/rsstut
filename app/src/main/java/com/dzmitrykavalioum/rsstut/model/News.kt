package com.dzmitrykavalioum.rsstut.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_table")
data class News (
    @PrimaryKey
    @ColumnInfo(name = "title")
    val title: String)
