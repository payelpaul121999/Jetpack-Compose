package com.paulpayelcompose.lastestmovieapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.paulpayelcompose.lastestmovieapp.model.TvShow
import com.paulpayelcompose.lastestmovieapp.ui.theme.LastestMovieAppTheme

class InfoActivity : ComponentActivity() {
    companion object {
        private const val TvShowId = "tvshowid"
        fun intent(context: Context, tvShow: TvShow) =
            Intent(context, InfoActivity::class.java).apply {
                putExtra(TvShowId, tvShow)
            }
    }
    private val tvShow : TvShow by lazy {
        intent?.getSerializableExtra(TvShowId) as TvShow
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LastestMovieAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ViewMoreInfo(tvShow)
                    Log.e("japan",tvShow.posterPath.toString())
                }
            }
        }
    }
}

@Composable
fun ViewMoreInfo(tvShow: TvShow) {
    val scrollState = rememberScrollState()
    Card(
        modifier = Modifier.padding(10.dp),
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
                .padding(10.dp)
        ) {
            Image(
                painter =
                rememberAsyncImagePainter("https://image.tmdb.org/t/p/w500"+ tvShow.posterPath),
                /*painterResource(id = "https://image.tmdb.org/t/p/w500"+tvShow.posterPath),*/
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(340.dp)
                    .clip(shape = RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = tvShow.name.toString(),
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = tvShow.overview.toString(),
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Original release : ${tvShow.firstAirDate}",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "IMDB : 4.5",
                style = MaterialTheme.typography.headlineSmall
            )

        }
    }
}