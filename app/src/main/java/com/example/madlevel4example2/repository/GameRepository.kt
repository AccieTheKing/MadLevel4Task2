package com.example.madlevel4example2.repository

import android.content.Context
import com.example.madlevel4example2.dao.GameDao
import com.example.madlevel4example2.database.GameListRoomDatabase
import com.example.madlevel4example2.model.Game

class GameRepository(context: Context) {
    private val gameDao: GameDao

    init {
        val database = GameListRoomDatabase.getDatabase(context)
        gameDao = database!!.gameDao()
    }

    suspend fun getAllProduct(): List<Game> {
        return gameDao.getAllGames()
    }

    suspend fun insertProduct(product: Game) {
        gameDao.insertGame(product)
    }

    suspend fun deleteProduct(product: Game) {
        gameDao.deleteGame(product)
    }

    suspend fun deleteAllProducts() {
        gameDao.deleteAllGames()
    }

    suspend fun getAllWins(): Int{
        return gameDao.getAllWins()
    }
}