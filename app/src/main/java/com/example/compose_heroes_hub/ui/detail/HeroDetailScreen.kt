package com.example.compose_heroes_hub.ui.detail


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.compose_heroes_hub.viewmodel.HeroViewModel

@Composable
fun HeroDetailScreen(
    heroId: Int,
    viewModel: HeroViewModel,
    navController: NavController
) {

    val hero = viewModel.heroes.find { it.id == heroId }

    hero?.let {

        Column(modifier = Modifier.padding(16.dp)) {

            Button(
                onClick = { navController.popBackStack() }
            ) {
                Text("Back to list")
            }

            Spacer(modifier = Modifier.height(16.dp))

            AsyncImage(
                model = hero.imageUrl,
                contentDescription = "${hero.name} photo",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = hero.name,
                style = MaterialTheme.typography.headlineMedium
            )

            hero.alias?.let {
                Text(text = it)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = hero.powerSummary)
        }
    }
}