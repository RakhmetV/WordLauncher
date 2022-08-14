package com.example.wordlauncher.data.datacourses

import com.example.wordlauncher.R
import com.example.wordlauncher.handlers.header.HeaderForSpinner
import com.example.wordlauncher.handlers.step.StepItem

class DataCourses {
    companion object{
        val headerClassList = arrayListOf<HeaderForSpinner>(
            HeaderForSpinner(R.drawable.russia,
                "Russian Federation",
                "Российская Федерация"),
            HeaderForSpinner(R.drawable.bashkortostan,
                "Bashkortostan",
                "башкортостан"),
            HeaderForSpinner(
                R.drawable.russia,
                "Introduction to Petroleum Industry",
                "Введение в нефтяную промышленность"
            )
        )
        fun stepDataList(position: Int): ArrayList<StepItem>{
            return when(position){
                /*Данные на тему Российской Федерации*/
                0->arrayListOf<StepItem>(
                    StepItem("Russian Step 1",
                        "Российская Федерация",
                        R.drawable.russia),
                    StepItem( "Russian Step 2",
                        "башкортостан",
                        R.drawable.bashkortostan),
                    StepItem(
                        "Russian Step 3",
                        "Введение в нефтяную промышленность",
                        R.drawable.russia
                    )
                )

                /*Данные на тему Башкортостан*/
                1->arrayListOf<StepItem>(
                    StepItem("Bashkortostan Step 1",
                        "Российская Федерация",
                        R.drawable.russia),
                    StepItem( "Bashkortostan Step 2",
                        "башкортостан",
                        R.drawable.bashkortostan),
                    StepItem(
                        "Bashkortostan Step 3",
                        "Введение в нефтяную промышленность",
                        R.drawable.russia
                    )
                )

                /*Данные на тему Введение в нефтяную промышленность*/
                2->arrayListOf<StepItem>(
                    StepItem("ITPT Step 1",
                        "Российская Федерация",
                        R.drawable.russia),
                    StepItem( "ITPT Step 2",
                        "башкортостан",
                        R.drawable.bashkortostan),
                    StepItem(
                        "ITPT Step 3",
                        "Введение в нефтяную промышленность",
                        R.drawable.russia
                    )
                )
                else -> {arrayListOf<StepItem>(
                    StepItem("Russian Federation",
                        "Российская Федерация",
                        R.drawable.russia),
                    StepItem( "Bashkortostan",
                        "башкортостан",
                        R.drawable.bashkortostan),
                    StepItem(
                        "Introduction to Petroleum Industry",
                        "Введение в нефтяную промышленность",
                        R.drawable.russia
                    )
                )}
            }
        }






    }
}