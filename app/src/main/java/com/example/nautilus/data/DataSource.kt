package com.example.nautilus.data

import com.example.nautilus.model.AwarenessImage
import com.example.nautilus.model.Shower


/**
 * [Datasource] generates a list of [Shower] and [AwarenessImage]
 */
object DataSource {
    val showersList = listOf(
        Shower(0, 5),
        Shower(1, 10),
        Shower(2, 15),
        Shower(3, 30),
        Shower(4, 50),
        Shower(5, 100)
    )
    val awarenessImagesList = listOf(
        AwarenessImage(0, 5),
        AwarenessImage(1, 10),
        AwarenessImage(2, 15),
        AwarenessImage(3, 30),
        AwarenessImage(4, 50),
        AwarenessImage(5, 100)
    )
}