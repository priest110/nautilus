package com.example.nautilus.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.nautilus.data.FirebaseConfig
import com.example.nautilus.data.seedData
import com.example.nautilus.model.Showers
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


private const val TAG = "ShowersViewModel" // Logging tag

/**
 * [ShowersViewModel] holds information about the water consumption by the showers
 */
class ShowersViewModel : ViewModel() {

    /**
     * Showers state
     */
    private val _uiState = MutableStateFlow(Showers())
    val uiState: StateFlow<Showers> = _uiState.asStateFlow()

    init {
        // Load database and run seed data
        val database = FirebaseConfig.database
        val sensorsRefs = database.reference
        seedData(sensorsRefs) { dataSnapshot ->
            // This method is called once with the initial value and again
            // whenever data at this location is updated.
            if (_uiState.value.showersIds.isEmpty())
                setShowers(dataSnapshot, sensorsRefs)
            setTotal(dataSnapshot)
        }
    }

    /**
     * Set the list of ids [dataSnapshot] that compose the shower room
     */
    fun setShowers(dataSnapshot: DataSnapshot, sensorsRefs: DatabaseReference){
        // Update the showers ids
        _uiState.update { currentState ->
            currentState.copy(
                showersIds = dataSnapshot.children.map { it.key }
            )
        }

        // Reset the liters
        val updatedLitersMap = mutableMapOf<String, Any>()
        dataSnapshot.children.forEach { showerSnapshot ->
            val showerId = showerSnapshot.key
            // Reset "Liters5Min" to 0
            updatedLitersMap["$showerId/Liters5min"] = 0
        }
        sensorsRefs.updateChildren(updatedLitersMap)

        val x = dataSnapshot.children.map { it.key }
        Log.w(TAG,  "Sensors: $x")
    }

    /**
     * Set the total of liters [dataSnapshot] consumed by the showers
     */
    fun setTotal(dataSnapshot: DataSnapshot){
        _uiState.update { currentState ->
            currentState.copy(
                totalLiters = dataSnapshot.children.map { it.child("Liters5min").value.toString().toInt() }.sumOf { it }
            )
        }

        val x = dataSnapshot.children.map { it.child("Liters5min").value.toString().toInt() }.sumOf { it }
        Log.w(TAG,  "Total: $x")
    }

    /**
     * Reset showers
     */
    fun resetShowers() {
        _uiState.value = Showers()
    }
}