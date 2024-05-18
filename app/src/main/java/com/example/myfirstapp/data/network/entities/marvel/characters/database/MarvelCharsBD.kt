package com.example.myfirstapp.data.network.entities.marvel.characters.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class MarvelCharsBD(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val comic: String,
    val image: String
) : Parcelable