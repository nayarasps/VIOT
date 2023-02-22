package com.smartvirtus.viot.framework

import com.smartvirtus.viot.data.local.LocationPersistenceSource
import com.smartvirtus.viot.domain.models.Room

class InMemoryLocationPersistenceSource : LocationPersistenceSource {

    private var rooms: MutableList<Room> = mutableListOf();

    override fun getPersistedRooms(): List<Room> = rooms;

    override fun saveNewRoom(room: Room) {
        rooms += room;
    }

    override fun removeRoom(index: Int) {
        rooms.removeAt(index)
    }

    override fun getRoom(position: Int): Room {
        return rooms[position]
    }
}