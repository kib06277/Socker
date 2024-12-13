package com.funshow.socketdemo

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var testing: Testing

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testing = Testing()
        testing.socket.connect()
        findViewById<Button>(R.id.sendButton).setOnClickListener {
            testing.login()
        }
    }
}
