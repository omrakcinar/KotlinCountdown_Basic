package com.omerakcinar.kotlincountdown_basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import com.omerakcinar.kotlincountdown_basic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var countdownTimer : CountDownTimer
    private var remainedSeconds : Long = 0
    private var isStopped = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun startCountdown(view: View){
        if (!binding.enterSecondText.text.isEmpty()){

            if (!isStopped){
                val secondAsLong = binding.enterSecondText.text.toString().toInt() * 1000
                var countdownTimeSecs = secondAsLong.toLong()

                countdownTimer = object : CountDownTimer(countdownTimeSecs,1000){
                    override fun onTick(p0: Long) {
                        var second = p0 + 1000
                        binding.counterText.text = "${second/1000}"
                    }

                    override fun onFinish() {
                        binding.counterText.text = "0"
                    }

                }.start()
            } else {

                countdownTimer = object : CountDownTimer(remainedSeconds,1000){
                    override fun onTick(p0: Long) {
                        var second = p0 + 1000
                        binding.counterText.text = "${second/1000}"
                    }

                    override fun onFinish() {
                        binding.counterText.text = "0"
                    }

                }.start()
            }


        }
    }

    fun stopCountdown(view: View){
        countdownTimer.cancel()
        remainedSeconds = binding.counterText.text.toString().toInt().toLong() * 1000
        isStopped = true
    }

}