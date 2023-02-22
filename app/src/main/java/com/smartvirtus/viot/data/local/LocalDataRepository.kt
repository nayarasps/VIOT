package com.smartvirtus.viot.data.local

import com.smartvirtus.viot.domain.models.Room

interface LocationPersistenceSource {

    fun getPersistedRooms(): List<Room>
    fun getRoom(position: Int): Room
    fun saveNewRoom(room: Room)
    fun removeRoom(position: Int)
}
