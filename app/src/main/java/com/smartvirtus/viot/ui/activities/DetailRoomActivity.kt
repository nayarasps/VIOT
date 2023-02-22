package com.smartvirtus.viot.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.smartvirtus.viot.R
import com.smartvirtus.viot.domain.models.Room
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString

class DetailRoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_room)

        val room: Room = Json.decodeFromString<Room>(intent.extras?.getString("room") as String)

        val roomName = findViewById<TextView>(R.id.room_name_detail)
        roomName.text = room.name

        val personsNumber = findViewById<TextView>(R.id.persons_number)
        personsNumber.text = room.personsNumber.toString()
            .plus(if (room.personsNumber > 1) " pessoas" else " pessoa")

        val roomSize = findViewById<TextView>(R.id.room_size)
        roomSize.text = (room.roomSize.toString()).plus(" m²")

        val airConNumber = findViewById<TextView>(R.id.airCon_number)
        airConNumber.text = room.airConNumber.toString()
            .plus(if (room.airConNumber > 1) " ar-condicionados" else " ar-condicionado")
    }
}