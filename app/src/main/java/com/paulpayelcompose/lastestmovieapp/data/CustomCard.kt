package com.paulpayelcompose.lastestmovieapp.data

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.paulpayelcompose.lastestmovieapp.R
import com.paulpayelcompose.lastestmovieapp.model.TvShow

@Composable
fun ShowCardTvShow(tvShow: TvShow, selectedItem:(TvShow)->Unit){
    Card(
        modifier = Modifier.padding(10.dp)

                           .clickable { selectedItem(tvShow)

                                      },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )) {
        Column {
            Card(
                shape = RoundedCornerShape(10.dp, 10.dp,0.dp,0.dp),

                ) {
                Image(
                    painter =
                    rememberAsyncImagePainter("https://image.tmdb.org/t/p/w500"+tvShow.posterPath),
                   /* painterResource(id = R.drawable.ic_launcher_background),*/
                    contentDescription = "simple image",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(280.dp)
                        .fillMaxWidth()

                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = tvShow.name.toString(),
                Modifier
                    .padding(5.dp),
                style = MaterialTheme.typography.headlineLarge,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(modifier = Modifier.fillMaxWidth()
                ,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(text = tvShow.firstAirDate.toString(),
                    Modifier
                        .padding(5.dp),
                    style = MaterialTheme.typography.headlineSmall,fontSize = 14.sp,)
                Text(text = "4.0",
                    modifier = Modifier
                        .padding(5.dp),
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.DarkGray,
                    fontSize = 14.sp,)
            }
            //Spacer(modifier = Modifier.height(5.dp))
            Text(text = tvShow.overview.toString(),
                Modifier
                    .padding(5.dp),
                style = MaterialTheme.typography.bodyLarge,fontSize = 14.sp,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(15.dp))

        }
    }

}