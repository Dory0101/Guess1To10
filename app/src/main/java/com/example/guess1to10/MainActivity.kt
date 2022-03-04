package com.example.guess1to10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.guess1to10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    var num = 0
    var secret = 0
    fun guess(view: View) {
        secret = (1..10).random()
        num = binding.edNum.text.toString().toInt()
        if (num != secret) {
            binding.tvResult.setText(String.format("Not this number.The number is $secret."))
            println("$num/$secret")
        } else {
            binding.tvResult.setText(String.format("Bingo! The number is $secret."))
        }
    }
}