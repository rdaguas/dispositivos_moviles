package com.example.myfirstapp.data.network.entities.marvel.characters

data class MarvelApiChars(
    val attributionHTML: String,
    val attributionText: String,
    val code: String,
    val copyright: String,
    val `data`: Data,
    val etag: String,
    val status: String
)