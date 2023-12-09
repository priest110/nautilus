package com.example.nautilus.data

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

private const val TAG = "FirebaseConfig"

object FirebaseConfig {
    val database by lazy {
        FirebaseDatabase.getInstance()
    }
}

fun seedData(sensorsRefs: DatabaseReference, onDataChangeCallback: (DataSnapshot) -> Unit) {
    sensorsRefs.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            onDataChangeCallback(dataSnapshot)
        }

        override fun onCancelled(error: DatabaseError) {
            // Failed to read value
            Log.w(TAG, "Failed to read value.", error.toException())
        }
    })
}
