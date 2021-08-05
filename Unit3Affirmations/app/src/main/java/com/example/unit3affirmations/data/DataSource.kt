package com.example.unit3affirmations.data

import com.example.unit3affirmations.R
import com.example.unit3affirmations.model.Affirmation

open class DataSource {

    fun loadAffirmations(): MutableList<Affirmation> {
        return mutableListOf(
            Affirmation(R.string.affirmation1),
            Affirmation(R.string.affirmation2),
            Affirmation(R.string.affirmation3),
            Affirmation(R.string.affirmation4),
            Affirmation(R.string.affirmation5),
            Affirmation(R.string.affirmation6),
            Affirmation(R.string.affirmation7),
            Affirmation(R.string.affirmation8),
            Affirmation(R.string.affirmation9),
            Affirmation(R.string.affirmation10)
        )
    }
}