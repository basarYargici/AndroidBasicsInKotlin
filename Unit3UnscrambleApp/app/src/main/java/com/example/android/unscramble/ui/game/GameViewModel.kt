package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    private var _score = 0
    private var currentWordCount = 0
    private var _currentScrambledWord = "test"
    private var wordsList: MutableList<String> = mutableListOf()

    private lateinit var currentWord: String

    val score: Int
        get() = _score
    val currentScrambledWord: String
        get() = _currentScrambledWord

    init {
        Log.d("GameFragment", "GameViewModel created!")
        getNextWord()
        Log.d("GameFragment", currentScrambledWord)

    }

    private fun getNextWord() {
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()

        // if shuffled word is same with currentWord, shuffle again
        while (tempWord.toString().equals(currentWord, false)) {
            tempWord.shuffle()
        }
        Log.d("GameViewModel", currentWord)
        if (wordsList.contains(currentWord)) getNextWord()
        else {
            _currentScrambledWord = String(tempWord)
            ++currentWordCount
            wordsList.add(currentWord)
        }
    }

    fun nextWord(): Boolean {
        return if (currentWordCount < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }

    private fun increaseScore() {
        _score += SCORE_INCREASE
    }

    fun isUserWordCorrect(playerWord: String): Boolean {
        if (playerWord.equals(currentWord, true)) {
            increaseScore()
            return true
        }
        return false
    }

    fun reinitializeData() {
        _score = 0
        currentWordCount = 0
        wordsList.clear()
        getNextWord()
    }
}