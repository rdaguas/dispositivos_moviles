package com.example.myfirstapp.data.conection

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myfirstapp.data.dao.marvel.MarvelCharsDAO
import com.example.myfirstapp.data.network.entities.marvel.characters.database.MarvelCharsBD

@Database(
    entities = [MarvelCharsBD::class],
    version = 1
)
abstract class MarvelConnectionDB : RoomDatabase() {

    abstract fun marvelDao(): MarvelCharsDAO

}