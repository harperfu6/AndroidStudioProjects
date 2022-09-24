package com.example.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private var wordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String

    private var _score = 0
    private var _currentWordCount = 0
    private lateinit var _currentScrambledWord: String
    val score: Int get() = _score
    val currentScrambledWord: String get() = _currentScrambledWord // public immutable field
    val currentWordCount: Int get() = _currentWordCount

    init {
        getNextWord()
    }

    private fun getNextWord() {
        currentWord = allWordsList.random()
//        Log.d("correct", "$currentWord")
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()

        // 正解と同じにならないようにシャッフル
        while (String(tempWord).equals(currentWord, false)) {
            tempWord.shuffle()
        }
        if (wordsList.contains(currentWord)) {
            getNextWord()
        } else {
            _currentScrambledWord = String(tempWord)
            ++_currentWordCount
            wordsList.add(currentWord)

        }
    }

    fun nextWord(): Boolean {
        return if (_currentWordCount < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }

    private fun increaseScore() {
        _score += SCORE_INCREASE
    }

    fun isUserWordCorrect(playerWord: String): Boolean {
        return if (playerWord.equals(currentWord, true)) {
            increaseScore()
            true
        } else false
    }

    fun reinitializeData() {
        _score = 0
        _currentWordCount = 0
        wordsList.clear()
        getNextWord()
    }

}