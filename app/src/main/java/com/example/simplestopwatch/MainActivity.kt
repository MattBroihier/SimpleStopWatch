package com.example.simplestopwatch

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val TimeDisplayView: TextView = findViewById(R.id.TimeDisplay_textView)

        object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val timeRemaining = "seconds remaining: " + (millisUntilFinished / 1000).toString()
                TimeDisplayView.setText(timeRemaining)
            }

            override fun onFinish() {
                TimeDisplayView.setText("done!")
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
}

// Method to configure and return an instance of CountDownTimer object
//private fun Displaytimer(millisInFuture: Long, countDownInterval: Long): CountDownTimer {
//    return object: CountDownTimer(millisInFuture, countDownInterval){
//        override fun onTick(millisUntilFinished: Long){
//            val timeRemaining = timeString(millisUntilFinished)
//            //if (!running){
//            //    text_view.text = "${text_view.text}\nStopped.(Cancelled)"
//            //    cancel()
//            //}else{
//            val TimeDisplayView = findViewById(R.id.TimeDisplay_textView)
//            TimeDisplayView.text = timeRemaining
//            //}
//        }
//
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
//        override fun onFinish() {
//        //    text_view.text = "Done"
////          DO SOMETHING later with this
////            button_start.isEnabled = true
////            button_stop.isEnabled = false
//        }
//    }
//}