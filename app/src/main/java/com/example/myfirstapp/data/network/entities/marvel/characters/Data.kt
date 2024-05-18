package com.example.myfirstapp.data.network.entities.marvel.characters

data class Data(
    val count: String,
    val limit: String,
    val offset: String,
    val results: List<Result>,
    val total: String
)