package com.example.unsplashclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.unsplashclient.ui.theme.UnsplashClientTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnsplashClientTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                }
            }
        }
    }
}

@Composable
fun saarchPhoto() {
    var photo: String = "photo"
    var himatsubushi : String = "himatsubushispot"
    val oomiya: Boolean = false
    if (oomiya) {
        photo = "photoStore"
    } else {
        himatsubushi = "oomiyaikoukana"
    }
}


@Composable
private  fun cold(bodyTemperatur:Int) {
    var place :String = ""
    if (bodyTemperatur >= 38) {
        place = "hospital"
    } else {
        place = "oomiya"
    }
}




