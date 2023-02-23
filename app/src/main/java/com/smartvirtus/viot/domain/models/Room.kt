package com.smartvirtus.viot.domain.models

import kotlinx.serialization.*

@Serializable
data class Room (

    val name: String,

    val personsNumber: String,

    val roomSize: String,

    val airConNumber: String,
)

