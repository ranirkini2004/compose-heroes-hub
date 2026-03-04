package com.example.compose_heroes_hub.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.example.compose_heroes_hub.ui.detail.HeroDetailScreen
import com.example.compose_heroes_hub.ui.list.HeroesListScreen
import com.example.compose_heroes_hub.viewmodel.HeroViewModel

@Composable
fun HeroesNavGraph() {

    val navController = rememberNavController()
    val viewModel: HeroViewModel = viewModel()

    NavHost(navController = navController, startDestination = "list") {

        composable("list") {
            HeroesListScreen(navController, viewModel)
        }

        composable("detail/{heroId}") { backStackEntry ->
            val heroId =
                backStackEntry.arguments?.getString("heroId")?.toIntOrNull()

            HeroDetailScreen(
                heroId = heroId ?: 0,
                viewModel = viewModel,
                navController = navController
            )
        }
    }
}