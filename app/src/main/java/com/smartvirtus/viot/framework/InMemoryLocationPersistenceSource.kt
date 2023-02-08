package com.smartvirtus.viot.framework

import com.smartvirtus.viot.data.local.LocationPersistenceSource
import com.smartvirtus.viot.domain.models.Room

class InMemoryLocationPersistenceSource : LocationPersistenceSource {

    private var rooms: List<Room> = emptyList();

    override fun getPersistedRooms(): List<Room> = rooms;

    override fun saveNewRoom(room: Room) {
        rooms += room;
    }
}