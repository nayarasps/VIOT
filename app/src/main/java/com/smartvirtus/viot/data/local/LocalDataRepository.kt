package com.smartvirtus.viot.data.local

import com.smartvirtus.viot.domain.models.Room

class LocalDataRepository() {

}

interface LocationPersistenceSource {

    fun getPersistedRooms(): List<Room>
    fun saveNewRoom(room: Room)

}
