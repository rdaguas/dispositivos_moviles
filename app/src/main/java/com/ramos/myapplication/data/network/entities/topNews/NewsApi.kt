package com.ramos.myapplication.data.network.entities.topNews

import com.ramos.myapplication.data.network.entities.topNews.Data
import com.ramos.myapplication.data.network.entities.topNews.Meta

data class NewsApi(
    val `data`: List<Data>,
    val meta: Meta
)