package com.smartvirtus.viot.domain.models

import kotlinx.serialization.*

@Serializable
data class Room (
    val id: Int,

    val name: String,

    val personsNumber: Int,

    val roomSize: Int,

    val airConNumber: Int,
)

