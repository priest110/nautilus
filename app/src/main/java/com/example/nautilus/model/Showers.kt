package com.example.nautilus.model

/**
 * [Showers] is the data class to represent the list of Showers
 */
data class Showers(
    /** List of the showers ids that are consuming water */
    val showersIds: List<String?> = listOf(),
    /** Total of liters consumed today */
    val totalLiters: Int = 0
)