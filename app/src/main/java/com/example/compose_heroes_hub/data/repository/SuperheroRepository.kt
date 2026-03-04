package com.example.compose_heroes_hub.data.repository

import com.example.compose_heroes_hub.data.model.Superhero

object SuperheroRepository {

    fun getHeroes(): List<Superhero> {
        return listOf(
            Superhero(
                1,
                "Superman",
                "Clark Kent",
                "Super strength, flight, heat vision",
                "https://picsum.photos/200?1"
            ),
            Superhero(
                2,
                "Batman",
                "Bruce Wayne",
                "Master detective, gadgets expert",
                "https://picsum.photos/200?2"
            ),
            Superhero(
                3,
                "Wonder Woman",
                "Diana Prince",
                "Warrior princess with lasso of truth",
                "https://picsum.photos/200?3"
            ),
            Superhero(
                4,
                "Flash",
                "Barry Allen",
                "Fastest man alive",
                "https://picsum.photos/200?4"
            ),
            Superhero(
                5,
                "Iron Man",
                "Tony Stark",
                "Genius inventor with powered armor suit",
                "https://picsum.photos/200?5"
            )
        )
    }
}