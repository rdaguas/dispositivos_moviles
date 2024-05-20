package com.ramos.myapplication.data.network.entities.allnews

data class Data(
    val categories: List<String>,
    val description: String,
    val imageUrl: String,
    val keywords: String,
    val language: String,
    val publishedAt: String,
    val relevanceScore: Any,
    val snippet: String,
    val source: String,
    val title: String,
    val url: String,
    val uuid: String
)