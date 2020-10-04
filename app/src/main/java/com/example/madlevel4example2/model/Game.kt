package com.example.madlevel4example2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.example.madlevel4example2.enums.GameState

@Entity(tableName = "gameTable")
data class Game(
    @ColumnInfo(name = "state")
    var state: String,
    @ColumnInfo(name = "date")
    var date: Long,
    @ColumnInfo(name = "computerMove")
    var computerMove: String,
    @ColumnInfo(name = "playerMove")
    var playerMove: String
)


