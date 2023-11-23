package com.example.unsplashclient.presentation.search_photos.components

import android.content.res.Resources.Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.unsplashclient.domain.model.Photo
import com.example.unsplashclient.domain.repository.PhotoRepository
import com.example.unsplashclient.presentation.ui.theme.UnsplashClientTheme

@Composable
fun PhotoThumbnail(
    photo: Photo,
    onClick: (Photo) -> Unit,
) {
    Box(
        modifier = Modifier
            .background(Color.Black)
            .heightIn(min = 200.dp)
            .clickable { onClick(photo) },
        contentAlignment = Alignment.BottomCenter
    ) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        AsyncImage(
            model = photo.imageUrl,
            contentDescription = photo.description,
            modifier = Modifier.fillMaxWidth()
            )
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black.copy(alpha = 0.5f))
            .padding(10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text(
                    text = photo.description ?: "No description",
                    color = Color.White,
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = photo.photographer ?: "Unknown photographer",
                    color = Color.White,
                    style = MaterialTheme.typography.body2
                    )
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription ="likes",
                tint = Color.Magenta
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = photo.likes.toString(),
                color = Color.White,
                style = MaterialTheme.typography.body1
            )

        }
    }
}

@Preview
@Composable
private fun PhotoThumbnailPreview(){
    val photo = Photo(
        photoId = "",
        description = "image description",
        likes = 100,
        imageUrl = "https://plus.unsplash.com/premium_photo-1700056212664-a2998bf82d32?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw3fHx8ZW58MHx8fHx8",
        photographer = "satoken"

    )
    UnsplashClientTheme {
        PhotoThumbnail(photo = photo, onClick = {})
    }

}