package com.smartvirtus.viot.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.smartvirtus.viot.R
import com.smartvirtus.viot.domain.models.Room
import com.smartvirtus.viot.framework.InMemoryLocationPersistenceSource


class DisplayRoomsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.display_rooms)

        val roomsManager = InMemoryLocationPersistenceSource();
        val room = Room(1, "Sala 1", 10, 30, 1);
        roomsManager.saveNewRoom(room);
    }
}