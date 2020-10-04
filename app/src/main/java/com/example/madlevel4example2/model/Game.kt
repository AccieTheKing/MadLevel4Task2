package com.example.madlevel4example2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.example.madlevel4example2.enums.GameState
import com.example.madlevel4example2.enums.Moves

@Entity(tableName = "gameTable")
data class Game(
    @ColumnInfo(name = "state")
    var state: GameState,
    @ColumnInfo(name = "date")
    var date: null,
    @ColumnInfo(name = "computerMove")
    var computerMove: Moves,
    @ColumnInfo(name = "playerMove")
    var playerMove: Moves
)


