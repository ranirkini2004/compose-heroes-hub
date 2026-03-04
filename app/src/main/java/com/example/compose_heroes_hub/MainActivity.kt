package com.example.compose_heroes_hub
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.compose_heroes_hub.navigation.HeroesNavGraph
import com.example.compose_heroes_hub.ui.theme.Compose_heroes_hubTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Compose_heroes_hubTheme {
                HeroesNavGraph()
            }
        }
    }
}