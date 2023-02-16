package com.smartvirtus.viot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.smartvirtus.viot.ui.activities.DisplayRoomsActivity
import com.smartvirtus.viot.ui.activities.RegisterRoomActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        val buttonRegisterClick = findViewById<Button>(R.id.cadastro_sala_button)
        buttonRegisterClick.setOnClickListener {
            val intent = Intent(this, RegisterRoomActivity::class.java)
            startActivity(intent)
        }

        val buttonShowClick = findViewById<Button>(R.id.visualizacao_sala_button)
        buttonShowClick.setOnClickListener {
            val intent = Intent(this, DisplayRoomsActivity::class.java)
            startActivity(intent)
        }
    }
}