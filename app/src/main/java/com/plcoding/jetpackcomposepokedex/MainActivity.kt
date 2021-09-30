package com.plcoding.jetpackcomposepokedex


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.plcoding.jetpackcomposepokedex.ui.theme.JetpackComposePokedexTheme
import com.ramcosta.composedestinations.Destinations
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
fun PokemonListScreen(navigator: DestinationsNavigator) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Spacer(Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_international_pok_mon_logo),
                contentDescription = "Pokemon Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(CenterHorizontally)
            )
            Spacer(Modifier.height(20.dp))
            SearchBar(modifier = Modifier.fillMaxWidth().padding(16.dp), hint = "Search") {

            }
        }
    }
}


@Destination("pokemon_detail_screen")
@Composable
fun PokemonDetailScreen(
    navigator: DestinationsNavigator,
    name: String,
    dominantColor: Int
) {

}


@Composable
fun SearchBar(
    modifier: Modifier,
    hint: String,
    onSearch: (String) -> Unit
) {
    var text by remember { mutableStateOf("") }
    var isHintVisible by remember { mutableStateOf(hint != "") }

    Box(
        modifier = modifier
    ) {
        BasicTextField(
            value = if (isHintVisible) hint else text,
            onValueChange = {
                text = it
                onSearch(it)
            },
            singleLine = true,
            textStyle = TextStyle(
                color = if (isHintVisible) Color.LightGray else Color.Black,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 5.dp, shape = CircleShape
                )
                .background(
                    color = Color.White, shape = CircleShape
                )
                .padding(horizontal = 20.dp, vertical = 10.dp)
                .onFocusChanged {
                    isHintVisible = !it.isFocused
                }
        )
    }
}

@Preview
@Composable
fun previewSearch() {
    SearchBar(modifier = Modifier, "Hello", {})
}


