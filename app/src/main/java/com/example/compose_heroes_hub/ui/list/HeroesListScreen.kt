package com.example.compose_heroes_hub.ui.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.compose_heroes_hub.viewmodel.HeroViewModel

@Composable
fun HeroesListScreen(
    navController: NavController,
    viewModel: HeroViewModel
) {

    Column(modifier = Modifier.padding(16.dp)) {

        OutlinedTextField(
            value = viewModel.searchQuery,
            onValueChange = { viewModel.updateSearch(it) },
            label = { Text("Search superheroes") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Checkbox(
                checked = viewModel.filterFavourite,
                onCheckedChange = { viewModel.toggleFilterFavourite() }
            )
            Text("Show Favourites Only")
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(viewModel.filteredHeroes) { hero ->
                HeroCard(
                    hero = hero,
                    onClick = {
                        navController.navigate("detail/${hero.id}")
                    },
                    onFavouriteClick = {
                        viewModel.toggleFavourite(hero.id)
                    }
                )
            }
        }
    }
}