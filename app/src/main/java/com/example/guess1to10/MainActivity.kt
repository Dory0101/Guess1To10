package com.example.guess1to10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.guess1to10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
    private lateinit var binding: ActivityMainBinding
    val game = NumberGame()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    val message = when (state) {
        NumberGame.State.BIGGER = "bigger"

    }

    fun guess(view: View) {
        Log.d(TAG, "testing: ${game.counter}")
        var num = binding.edNum.text.toString().toInt()
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.dialog_title))
            .setMessage(game.guess(num))
            .setPositiveButton(getString(R.string.ok)){ dialog, which->
                if (game.end) {
                    game.reset()
                    binding.tvCounter.text = game.counter.toString()
                }
            }
            .show()
        binding.tvCounter.text = game.counter.toString()
        Toast.makeText(this, "$num/${game.secret}", Toast.LENGTH_LONG).show()
    }
}