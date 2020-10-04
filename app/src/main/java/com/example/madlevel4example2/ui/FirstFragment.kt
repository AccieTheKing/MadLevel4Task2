package com.example.madlevel4example2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.madlevel4example2.R
import com.example.madlevel4example2.enums.GameState
import com.example.madlevel4example2.enums.Moves
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
//        view.findViewById<Button>(R.id.button_first).setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
    }

    /**
     * This method will set the listeners
     */
    private fun initView() {
        imv_rock.setOnClickListener { playGame(Moves.ROCK) }
        imv_paper.setOnClickListener { playGame(Moves.PAPER) }
        imv_scissors.setOnClickListener { playGame(Moves.SCISSORS) }
    }

    /**
     * This method will launch the game
     */
    private fun playGame(userMove: Moves) {
        when (userMove) {
            Moves.ROCK -> imv_move_player.setImageResource(R.drawable.rock)
            Moves.PAPER -> imv_move_player.setImageResource(R.drawable.paper)
            Moves.SCISSORS -> imv_move_player.setImageResource(R.drawable.scissors)
        }

        val movesByComputer = randomMoveComputer()

        when (checkForWin(movesByComputer, userMove)) {
            GameState.WIN -> {
                txt_game_result.text = getString(R.string.title_win)
            }
            GameState.DRAW -> {
                txt_game_result.text = getString(R.string.title_draw)
            }
            GameState.LOSE -> {
                txt_game_result.text = getString(R.string.title_lose)
            }
        }
    }

    /**
     * This method will do a random move for the computer and returns the move of the computer
     */
    private fun randomMoveComputer(): Moves {
        val randomNumber = (0 until 3).random()

        when (numberToMove(randomNumber)) {
            Moves.ROCK -> imv_move_computer.setImageResource(R.drawable.rock)
            Moves.PAPER -> imv_move_computer.setImageResource(R.drawable.paper)
            Moves.SCISSORS -> imv_move_computer.setImageResource(R.drawable.scissors)
        }

        return numberToMove(randomNumber)
    }

    /**
     * This method will transform a number into a Move
     */
    private fun numberToMove(number: Int): Moves {
        if (number == 0) {
            return Moves.ROCK
        } else if (number == 1) {
            return Moves.PAPER
        }

        return Moves.SCISSORS
    }

    /**
     * This method will check who has won the round
     */
    private fun checkForWin(computerMove: Moves, userMove: Moves): GameState {
        if (computerMove == userMove) {
            return GameState.DRAW
        } else if (computerMove == Moves.ROCK && userMove == Moves.PAPER ||
            computerMove == Moves.PAPER && userMove == Moves.SCISSORS ||
            computerMove == Moves.SCISSORS && userMove == Moves.ROCK
        ) {
            return GameState.WIN
        } else if (userMove == Moves.ROCK && computerMove == Moves.PAPER ||
            userMove == Moves.PAPER && computerMove == Moves.SCISSORS ||
            userMove == Moves.SCISSORS && computerMove == Moves.ROCK
        ) {
            return GameState.LOSE
        }

        return GameState.LOSE;
    }
}