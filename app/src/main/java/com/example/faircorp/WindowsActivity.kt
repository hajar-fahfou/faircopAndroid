package com.example.faircorp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.faircorp.model.RoomDto
import com.example.faircorp.model.WindowDto

class WindowsActivity : BasicActivity() {

    val windowService = WindowService() // (1)

    class WindowService {
        companion object {
        // Fake rooms
        val ROOMS: List<RoomDto> = listOf(
                RoomDto(1, "Room EF 6.10", 18.2, 20.0),
                RoomDto(2, "Hall", 18.2, 18.0),
                RoomDto(3, "Room EF 7.10", 21.2, 20.0)
        )

        // Fake lights
        val WINDOWS: List<WindowDto> = listOf(
                WindowDto(1, "Entry Window", ROOMS[0], Status.CLOSED),
                WindowDto(2, "Back Window", ROOMS[0], Status.CLOSED),
                WindowDto(3, "Sliding door", ROOMS[1], Status.OPEN),
                WindowDto(4, "Window 1", ROOMS[2], Status.CLOSED),
                WindowDto(5, "Window 2", ROOMS[2], Status.CLOSED),
                )
    }

    fun findById(id: Long) = WINDOWS.firstOrNull { it.id == id}

    fun findAll() = WINDOWS.sortedBy { it.name }
}



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_windows)

        val recyclerView = findViewById<RecyclerView>(R.id.list_windows) // (2)
        val adapter = WindowAdapter() // (3)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        adapter.update(windowService.findAll()) // (4)
    }
}