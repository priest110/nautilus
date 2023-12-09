package com.example.nautilus.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nautilus.R
import com.example.nautilus.ui.theme.NautilusTheme

/**
 * Composable that allows the user to select the "Sabe Mais" and triggers the navigation to
 * next screen
 */
@Composable
fun HomeScreen(
    onNextButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Reusable strings and images
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
            Button(onClick = onNextButtonClicked){
                Text(
                    text = "SABE MAIS ",
                    fontSize = 30.sp
                )
                Icon(
                    Icons.Rounded.Info,
                    contentDescription = null
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 1280, heightDp = 900)
@Composable
fun HomePreview(){
    NautilusTheme {
        HomeScreen(
            onNextButtonClicked = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}