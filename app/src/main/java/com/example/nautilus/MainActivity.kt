package com.example.nautilus

import android.media.tv.TvContract.Channels.Logo
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nautilus.data.DataSource
import com.example.nautilus.model.AwarenessImage
import com.example.nautilus.model.Shower
import com.example.nautilus.ui.theme.NautilusTheme

// Tag for logging
private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate Called")
        setContent {
            NautilusTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    NautilusApp(showers = DataSource.showersList, awarenessImages = DataSource.awarenessImagesList)
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy Called")
    }
}

@Composable
fun NautilusApp(showers: List<Shower>, awarenessImages: List<AwarenessImage>, modifier: Modifier = Modifier) {
    var totalLiters by rememberSaveable { mutableStateOf(0) }
    var litersByShower by rememberSaveable { mutableStateOf(0) }

    var currentAwarenessImageIndex by rememberSaveable { mutableStateOf(0) }

    var currentAwarenessImageLiters by rememberSaveable {
        mutableStateOf(awarenessImages[currentAwarenessImageIndex].liters)
    }
    var currentAwarenessImageId by rememberSaveable {
        mutableStateOf(awarenessImages[currentAwarenessImageIndex].imageId)
    }

    val background = painterResource(id = R.drawable.background)
    Box {
        // Background
        Image(
            painter = background,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize()
        )
        // Create a column so that texts don't overlap
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val image = painterResource(id = R.drawable.nautilus)
            Image(
                painter = image,
                contentDescription = "Logo Nautilus",
                modifier = Modifier
                    .padding(8.dp)
            )
            Button(onClick = { println("Click") }){
                Text(
                    text = "SABE MAIS ",
                    fontSize = 30.sp
                )
                Icon(
                    Icons.Rounded.Add,
                    contentDescription = null
                )
            }
        }
    }
}



@Preview(showBackground = true, widthDp = 1280, heightDp = 900)
@Composable
fun NautilusAppPreview() {
    NautilusTheme {
        NautilusApp(showers = DataSource.showersList, awarenessImages = DataSource.awarenessImagesList)
    }
}