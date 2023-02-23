package com.smartvirtus.viot.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.smartvirtus.viot.MainActivity
import com.smartvirtus.viot.R
import com.smartvirtus.viot.domain.models.Room
import com.smartvirtus.viot.framework.InMemoryLocationPersistenceSource

class RegisterRoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_room)

        var roomNameBox = findViewById<EditText>(R.id.name_box)

        var numberPeopleBox = findViewById<EditText>(R.id.n_people_box)

        var numberArBox = findViewById<EditText>(R.id.n_ar_box)

        var roomSizeBox = findViewById<EditText>(R.id.room_size_box)

        var registerButton = findViewById<Button>(R.id.cadastro_de_sala_button)
        registerButton.setOnClickListener {

            val roomPersistence = InMemoryLocationPersistenceSource
            val room = Room(roomNameBox.text.toString(),
                numberPeopleBox.text.toString(),
                roomSizeBox.text.toString(),
                numberArBox.text.toString())

            roomPersistence.saveNewRoom(room)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


        }
    }
}