package com.paulpayelcompose.lastestmovieapp
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.paulpayelcompose.lastestmovieapp.screen.HomeScreen
import com.paulpayelcompose.lastestmovieapp.ui.theme.LastestMovieAppTheme
import com.paulpayelcompose.lastestmovieapp.utils.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LastestMovieAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color.Black) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Home.rout
                    ) {
                        composable(Screen.Home.rout) {
                            HomeScreen(navController)
                        }

                        composable(
                            Screen.Details.rout + "/{movieId}",
                            arguments = listOf(
                                navArgument("movieId") { type = NavType.IntType }
                            )
                        ) { backStackEntry ->
//                            DetailsScreen(backStackEntry)
                        }
                    }
                }
            }
        }


    }


}

/*@Composable
fun DisplayTvShows(selectedItem: (TvShow) -> Unit,tvShow: TvShow) {

    //val tvShows = remember { TvShow }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp,vertical = 8.dp)
    ) {
        items(
            //7980511342@icici
            //joydipbose999@okicic

            //9804329968

            items = tvShow,
            itemContent = {
                ShowCardTvShow(tvShow = it, selectedItem)
            }
        )
    }

}*/

/*@Composable
fun MovieList(movieList: List<TvShow>,selectedItem: (TvShow) -> Unit) {
    LazyColumn {
        itemsIndexed(items = movieList) { index, item ->
            ShowCardTvShow( tvShow= item, selectedItem)
        }
    }

}*/


/*@Composable
fun MovieList(movieList: List<TvShow>,selectedItem: (TvShow) -> Unit) {
    var selectedIndex by remember { mutableStateOf(-1) }
    LazyColumn {

        itemsIndexed(items = movieList) { index, item ->
            ShowCardTvShow(tvShow = item, selectedItem)
        }
    }

}*/

@Composable
fun LazyColumnDemo() {
    LazyColumn {
        items(100) {
            Text(
                "User Name $it",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(10.dp)
            )
            Divider(color = Color.Black, thickness = 5.dp)
        }
    }
}




