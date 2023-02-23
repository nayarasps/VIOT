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

        val roomPersistence = InMemoryLocationPersistenceSource

        val adapter = RoomsAdapter(roomPersistence, this)

        rvRooms.adapter = adapter

        rvRooms.layoutManager = LinearLayoutManager(this)
    }
}