package com.plcoding.jetpackcomposepokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.plcoding.jetpackcomposepokedex.ui.theme.JetpackComposePokedexTheme
import com.ramcosta.composedestinations.Destinations
import com.ramcosta.composedestinations.SecondScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePokedexTheme {
                val navController = rememberNavController()
                Destinations.NavHost(
                    navController = navController
                )
            }
        }
    }
}

@Destination("pokemon_list_screen", start = true)
@Composable
fun PokemonListScreen(navController: NavController) {

}


@Destination("pokemon_detail_screen")
@Composable
fun PokemonDetailScreen(
    navigator: DestinationsNavigator,
    name: String,
    dominantColor: Int
) {

}


