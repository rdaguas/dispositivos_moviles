package com.aguas.myapplication.data.network.entities

data class DataPremiosNobel(
    val links: Links,
    val meta: Meta,
    val nobelPrizes: List<NobelPrize>
)