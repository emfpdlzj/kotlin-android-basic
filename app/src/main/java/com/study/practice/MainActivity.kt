package com.study.practice

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.Timer
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main) //xml파일 연결

        var timerTask: Timer? = null

        var isRunning = false
        var sec: Int = 0
        val tv: TextView = findViewById(R.id.tv_hello)
        val btn: Button = findViewById(R.id.btn_kor)

        btn.setOnClickListener {
            isRunning = !isRunning
            if (isRunning == true) {
                timerTask = timer(period = 1000) {
                    sec++;
                    // UI조작을 위한 메서드
                    runOnUiThread {
                        tv.text = sec.toString()
                    }
                }
            } else {
                timerTask?.cancel()
            }
        }
    }
}



