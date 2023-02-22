package com.smartvirtus.viot.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.smartvirtus.viot.R
import com.smartvirtus.viot.domain.models.Room
import com.smartvirtus.viot.framework.InMemoryLocationPersistenceSource
import com.smartvirtus.viot.ui.activities.DetailRoomActivity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.Serializable


class RoomsAdapter (private val rooms: InMemoryLocationPersistenceSource,
                    private val context: Context)
    : RecyclerView.Adapter<RoomsAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val mRooms: List<Room> = rooms.getPersistedRooms()
        val nameTextView = itemView.findViewById<TextView>(R.id.room_name)
        val deleteButton = itemView.findViewById<TextView>(R.id.delete_button)
        val detailButton = itemView.findViewById<LinearLayout>(R.id.detail_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomsAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.item_room, parent, false)

        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(viewHolder: RoomsAdapter.ViewHolder, position: Int) {

        val room: Room = viewHolder.mRooms[position]

        val nameTextView = viewHolder.nameTextView
        nameTextView.text = room.name

        val deleteButton = viewHolder.deleteButton
        deleteButton.setOnClickListener {
            deleteItem(position)
        }

        val detailButton = viewHolder.detailButton
        detailButton.setOnClickListener {
            val intent = Intent(context, DetailRoomActivity::class.java)

            val room = rooms.getRoom(position)
            intent.putExtra("room", Json.encodeToString(room))
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return rooms.getPersistedRooms().size
    }

    private fun deleteItem(position: Int) {
        rooms.removeRoom(position)
        notifyItemRemoved(position)
        notifyDataSetChanged()
    }

}
