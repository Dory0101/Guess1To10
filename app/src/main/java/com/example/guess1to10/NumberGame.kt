package com.example.guess1to10

class NumberGame {
    enum class State {
        INIT, BIGGER, SMALLER, BINGO, END
    }

    var secret = (1..10).random()
    var counter = 0
    var end = false
    fun reset() {
        secret  = (1..10).random()
        counter = 0
        end = false
    }
    fun guess (num : Int) : String {
        counter++
        val message = if (num < secret) State.BIGGER
        else if (num > secret) State.SMALLER
        else {
            end = true
            State.BINGO
        }
    return  message
    }
}