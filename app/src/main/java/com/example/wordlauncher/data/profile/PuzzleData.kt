package com.example.wordlauncher.data.profile

import android.graphics.drawable.Drawable
import com.example.wordlauncher.R
import com.example.wordlauncher.data.datastep.WordForStep
import com.example.wordlauncher.handlers.step.StepWord

class PuzzleData {
    companion object {
        fun puzzleImgList(position: Int): ArrayList<Int> {
            return when (position) {
                0 -> arrayListOf(
                    R.drawable.puzzle_ru5,
                    R.drawable.puzzle_ru6,
                    R.drawable.puzzle_ru1,
                    R.drawable.puzzle_ru2,
                    R.drawable.puzzle_ru3,
                    R.drawable.puzzle_ru4
                )
                1 -> arrayListOf(
                    R.drawable.puzzle_bush1,
                    R.drawable.puzzle_bush2,
                    R.drawable.puzzle_bush3,
                    R.drawable.puzzle_bush4,
                    R.drawable.puzzle_bush5,
                    R.drawable.puzzle_bush6,
                    R.drawable.puzzle_bush7,
                    R.drawable.puzzle_bush8,
                    R.drawable.puzzle_bush9
                )
                2 -> arrayListOf(
                    R.drawable.puzzle_hydro8,
                    R.drawable.puzzle_hydro9,
                    R.drawable.puzzle_hydro1,
                    R.drawable.puzzle_hydro2,
                    R.drawable.puzzle_hydro3,
                    R.drawable.puzzle_hydro4,
                    R.drawable.puzzle_hydro5,
                    R.drawable.puzzle_hydro6,
                    R.drawable.puzzle_hydro7
                )
                else -> {
                    arrayListOf(
                        R.drawable.puzzle_hydro8,
                        R.drawable.puzzle_hydro9,
                        R.drawable.puzzle_hydro1,
                        R.drawable.puzzle_hydro2,
                        R.drawable.puzzle_hydro3,
                        R.drawable.puzzle_hydro4,
                        R.drawable.puzzle_hydro5,
                        R.drawable.puzzle_hydro6,
                        R.drawable.puzzle_hydro7
                    )
                }
            }

        }
    }
}