package com.example.simplestopwatch

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
//import java.lang.String
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val TimeDisplayView: TextView = findViewById(R.id.TimeDisplay_textView)
        val CountdownTimerDisplayView: TextView = findViewById(R.id.CountdownTimerDisplay)

        runTimer()

        object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val timeRemaining = "seconds remaining: " + (millisUntilFinished / 1000).toString()
                CountdownTimerDisplayView.text = timeRemaining
            }

            override fun onFinish() {
                CountdownTimerDisplayView.text = getString(R.string.doneMessage)
            }
        }.start()
    }

    private var running = false
    private var seconds = 0

    //private var TimeDisplayView: TextView = findViewById(R.id.TimeDisplay_textView)

    fun onClickStart(view: View) {
        running = true
    }
    fun onClickStop(view: View) {
        running = false
    }

    fun onClickReset(view: View) {
        running = false
        seconds = 0
    }

    private fun runTimer() {

        // Get the text view.
        val timeView: TextView = findViewById(R.id.TimeDisplay_textView)

        // Creates a new Handler
        val handler = Handler()

        // Call the post() method,
        // passing in a new Runnable.
        // The post() method processes
        // code without a delay,
        // so the code in the Runnable
        // will run almost immediately.
        handler.post(object : Runnable {
            override fun run() {
                val hours = seconds / 3600
                val minutes = seconds % 3600 / 60
                val secs = seconds % 60

                // Format the seconds into hours, minutes,
                // and seconds.
                val time = String
                        .format(Locale.getDefault(),
                                "%d:%02d:%02d", hours,
                                minutes, secs)

                // Set the text view text.
                timeView.text = time

                // If running is true, increment the
                // seconds variable.
                if (running) {
                    seconds++
                }

                // Post the code again
                // with a delay of 1 second.
                handler.postDelayed(this, 1000)
            }
        })
    }
}

//        private fun timeString(millisUntilFinished: Long): Any {
//            var millisUntilFinished:Long = millisUntilFinished
//            val days = TimeUnit.MILLISECONDS.toDays(millisUntilFinished)
//            millisUntilFinished -= TimeUnit.DAYS.toMillis(days)
//
//            val hours = TimeUnit.MILLISECONDS.toHours(millisUntilFinished)
//            millisUntilFinished -= TimeUnit.HOURS.toMillis(hours)
//
//            val minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
//            millisUntilFinished -= TimeUnit.MINUTES.toMillis(minutes)
//
//            val seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)
//
//            // Format the string
//            return String.format(
//                    Locale.getDefault(),
//                    "%02d day: %02d hour: %02d min: %02d sec",
//                    days, hours, minutes, seconds
//            )
//        }
//
