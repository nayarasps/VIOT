package com.smartvirtus.viot.ui.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smartvirtus.viot.R
import com.smartvirtus.viot.adapter.RoomsAdapter
import com.smartvirtus.viot.domain.models.Room
import com.smartvirtus.viot.framework.InMemoryLocationPersistenceSource


class DisplayRoomsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.display_rooms)

        val rvRooms = findViewById<View>(R.id.rvRooms) as RecyclerView

        // Remover depois, quartos inseridos apenas para testes
        val rooms = InMemoryLocationPersistenceSource()
        val room = Room(1, "Sala de descompressão", 10, 30, 5)
        val room2 = Room(2, "Sala 1", 15, 40, 1)
        rooms.saveNewRoom(room)
        rooms.saveNewRoom(room2)

        val adapter = RoomsAdapter(rooms, this)

        rvRooms.adapter = adapter

        rvRooms.layoutManager = LinearLayoutManager(this)
    }
}