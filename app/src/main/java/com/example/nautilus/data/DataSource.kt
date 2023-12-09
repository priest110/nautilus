package com.example.nautilus.data

import com.example.nautilus.R


/**
 * [DataSource] generates a list of awareness images
 */
object DataSource {
    val awarenessMessages = listOf(
        Pair(R.string.beers, 74),    // 74 litre for a glass of 250 ml (beer)
        Pair(R.string.coffees, 132), // 132 litre per cup of 125 ml (coffee)
        Pair(R.string.breads, 1608), // 1608 litre/kg pão de trigo
        Pair(R.string.beefs, 15415)   // 15415 litre/kg bife de bovino
    )
}