package com.example.compose_heroes_hub.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.compose_heroes_hub.data.model.Superhero
import com.example.compose_heroes_hub.data.repository.SuperheroRepository

class HeroViewModel : ViewModel() {

    private val _heroes = mutableStateListOf<Superhero>()
    val heroes: List<Superhero> = _heroes

    var searchQuery by mutableStateOf("")
        private set

    var filterFavourite by mutableStateOf(false)
        private set

    init {
        _heroes.addAll(SuperheroRepository.getHeroes())
    }

    fun updateSearch(query: String) {
        searchQuery = query
    }

    fun toggleFavourite(id: Int) {
        val index = _heroes.indexOfFirst { it.id == id }
        if (index != -1) {
            _heroes[index] =
                _heroes[index].copy(isFavourite = !_heroes[index].isFavourite)
        }
    }

    fun toggleFilterFavourite() {
        filterFavourite = !filterFavourite
    }

    val filteredHeroes: List<Superhero>
        get() = _heroes
            .filter {
                it.name.contains(searchQuery, ignoreCase = true)
            }
            .filter {
                if (filterFavourite) it.isFavourite else true
            }
}