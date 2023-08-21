package com.bignerdranch.android.criminalintent

import java.util.Date
import java.util.UUID

/**
 * Represents a single office crime.
 */
data class Crime(
    val id: UUID,
    val title: String,
    val date: Date,
    val isSolved: Boolean
)
