package com.example.faircorp.model
import com.example.faircorp.Status;

data class WindowDto(val id: Long, val name: String, val room: RoomDto, val status: Status)
