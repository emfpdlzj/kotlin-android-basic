package com.study.practice

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.concurrent.timer
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main) //xml파일 연결

        var timerTask: Timer? = null

        var isRunning = false
        var sec: Int = 0
        val tv: TextView = findViewById(R.id.tv_random)
        val tv_t: TextView = findViewById(R.id.tv_timer)
        val tv_p: TextView = findViewById(R.id.tv_point)
        val btn: Button = findViewById(R.id.btn_main)

            val random_box = Random()
            val num = random_box.nextInt(1001)
            tv.text=(num.toFloat()/100).toString()

        btn.setOnClickListener {
            isRunning = !isRunning
            if (isRunning == true) {
                timerTask = timer(period = 10) { // 0.01초마다 sec 증가
                    sec++;
                    // UI조작을 위한 메서드
                    runOnUiThread {
                        tv_t.text = (sec.toFloat()/100).toString()
                    }
                }
            } else {
                timerTask?.cancel()
                val point = abs(sec-num).toFloat()/100
                tv_p.text=point.toString()
            }
        }
    }
}



