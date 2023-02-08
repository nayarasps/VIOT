package com.smartvirtus.viot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.smartvirtus.viot.ui.activities.RegisterRoomActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        val buttonClick = findViewById<Button>(R.id.cadastro_sala_button)
        buttonClick.setOnClickListener {
            val intent = Intent(this, RegisterRoomActivity::class.java);
            startActivity(intent)
        }
    }
}