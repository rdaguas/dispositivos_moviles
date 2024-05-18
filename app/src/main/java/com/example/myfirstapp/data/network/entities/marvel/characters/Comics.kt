package com.example.myfirstapp.data.network.entities.marvel.characters

data class Comics(
    val available: String,
    val collectionURI: String,
    val items: List<Item>,
    val returned: String
)