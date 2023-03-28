package com.smartvirtus.viot

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smartvirtus.viot.adapter.RoomsAdapter
import com.smartvirtus.viot.framework.InMemoryLocationPersistenceSource
import com.smartvirtus.viot.ui.activities.RegisterRoomActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.display_rooms)

        val rvRooms = findViewById<View>(R.id.rvRooms) as RecyclerView

        val roomPersistence = InMemoryLocationPersistenceSource

        val adapter = RoomsAdapter(roomPersistence, this)

        rvRooms.adapter = adapter

        rvRooms.layoutManager = LinearLayoutManager(this)

        val registerButtonClick = findViewById<Button>(R.id.cadastro_sala_button)
        registerButtonClick.setOnClickListener {
            val intent = Intent (this, RegisterRoomActivity::class.java)
            startActivity(intent)
        }
    }

    val confirmDeleteRoom =  {
        val builder = AlertDialog.Builder(this, R.style.MyDialogTheme)
        builder.setTitle("Deletar Sala?")
        builder.setCancelable(false)

    }
}