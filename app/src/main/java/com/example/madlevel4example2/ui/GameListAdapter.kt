package com.example.madlevel4example2.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel4example2.R
import com.example.madlevel4example2.converters.DateConverter
import com.example.madlevel4example2.converters.GameStateConverter
import com.example.madlevel4example2.model.Game
import kotlinx.android.synthetic.main.item_game.view.*

class GameListAdapter(private val games: List<Game>) :
    RecyclerView.Adapter<GameListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun dataBind(game: Game) {
            itemView.txt_game_status.text =
                GameStateConverter().stringToGameState(game.state).toString()
            itemView.txt_date.text = DateConverter().fromTimestamp(game.date).toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dataBind(games[position])
    }

    override fun getItemCount(): Int {
        return games.size
    }
}