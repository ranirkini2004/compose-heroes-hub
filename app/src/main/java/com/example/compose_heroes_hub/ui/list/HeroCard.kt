package com.example.compose_heroes_hub.ui.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.compose_heroes_hub.data.model.Superhero

@Composable
fun HeroCard(
    hero: Superhero,
    onClick: () -> Unit,
    onFavouriteClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {

        Row(modifier = Modifier.padding(16.dp)) {

            AsyncImage(
                model = hero.imageUrl,
                contentDescription = "${hero.name} photo",
                modifier = Modifier.size(80.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {

                Text(
                    text = hero.name,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.semantics { heading() }
                )

                hero.alias?.let {
                    Text(text = it)
                }

                Text(text = hero.powerSummary)
            }

            IconButton(
                onClick = onFavouriteClick,
                modifier = Modifier.sizeIn(minWidth = 48.dp, minHeight = 48.dp)
            ) {
                Icon(
                    imageVector =
                    if (hero.isFavourite)
                        Icons.Filled.Favorite
                    else
                        Icons.Outlined.FavoriteBorder,
                    contentDescription = "Favourite"
                )
            }
        }
    }
}