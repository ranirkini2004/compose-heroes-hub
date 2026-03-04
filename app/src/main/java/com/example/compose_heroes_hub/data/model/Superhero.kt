package com.example.compose_heroes_hub.data.model

data class Superhero(
    val id: Int,
    val name: String,
    val alias: String?,
    val powerSummary: String,
    val imageUrl: String,
    val isFavourite: Boolean = false
)