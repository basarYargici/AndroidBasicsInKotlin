package com.example.unit1pathway4

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}