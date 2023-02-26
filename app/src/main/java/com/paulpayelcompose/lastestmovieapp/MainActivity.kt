package com.paulpayelcompose.lastestmovieapp
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.paulpayelcompose.lastestmovieapp.data.ShowCardTvShow
import com.paulpayelcompose.lastestmovieapp.model.TvShow
import com.paulpayelcompose.lastestmovieapp.ui.theme.LastestMovieAppTheme
import com.paulpayelcompose.lastestmovieapp.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {

    val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            LastestMovieAppTheme {
                // A surface container using the 'background' color from the theme
                  //LazyColumnDemo()
               // ShowCardTvShow()



                MovieList(movieList = mainViewModel.movieListResponse,selectedItem={
                    startActivity(InfoActivity.intent(this,it))
                })
                mainViewModel.getMovieList()





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


@Composable
fun MovieList(movieList: List<TvShow>,selectedItem: (TvShow) -> Unit) {
    var selectedIndex by remember { mutableStateOf(-1) }
    LazyColumn {

        itemsIndexed(items = movieList) { index, item ->
            ShowCardTvShow(tvShow = item, selectedItem)
        }
    }

}

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




