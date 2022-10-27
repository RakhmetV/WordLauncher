package com.example.wordlauncher.data.datacourses

import com.example.wordlauncher.R
import com.example.wordlauncher.handlers.header.HeaderForSpinner
import com.example.wordlauncher.handlers.step.StepItem

class DataCourses {
    companion object{
        val headerClassList = arrayListOf<HeaderForSpinner>(
            HeaderForSpinner(
                R.drawable.kremle,
                "Russian Federation",
                "Российская Федерация",
            "Number of steps: 6"),
            HeaderForSpinner(R.drawable.rb_icon,
                "Bashkortostan",
                "башкортостан",
            "Number of steps: 9"),
            HeaderForSpinner(
                R.drawable.hydrocarbon_module,
                "Hydrocarbons",
                "Введение в нефтяную промышленность",
                "Number of steps: 7"
            )
        )
        fun stepDataList(position: Int): ArrayList<StepItem>{
            return when(position){
                /*Данные на тему Российской Федерации*/
                0->arrayListOf<StepItem>(
                    StepItem("Russian Step 1",
                        "Российская Федерация",
                        R.drawable.rf_1),
                    StepItem( "Russian Step 2",
                        "башкортостан",
                        R.drawable.rf_2),
                    StepItem(
                        "Russian Step 3",
                        "Введение в нефтяную промышленность",
                        R.drawable.rf_3
                    ),
                    StepItem(
                        "Russian Step 4",
                        "Введение в нефтяную промышленность",
                        R.drawable.rf_4
                    ),
                    StepItem(
                        "Russian Step 5",
                        "Введение в нефтяную промышленность",
                        R.drawable.rf_5
                    ),
                    StepItem(
                        "Russian Step 6",
                        "Введение в нефтяную промышленность",
                        R.drawable.rf_6
                    )
                )

                /*Данные на тему Башкортостан*/
                1->arrayListOf<StepItem>(
                    StepItem("Bashkortostan Step 1",
                        "Российская Федерация",
                        R.drawable.rb_1),
                    StepItem( "Bashkortostan Step 2",
                        "башкортостан",
                        R.drawable.rb_2),
                    StepItem(
                        "Bashkortostan Step 3",
                        "Введение в нефтяную промышленность",
                        R.drawable.rb_3
                    ),
                    StepItem(
                        "Bashkortostan Step 4",
                        "Введение в нефтяную промышленность",
                        R.drawable.rb_4
                    ),
                    StepItem(
                        "Bashkortostan Step 5",
                        "Введение в нефтяную промышленность",
                        R.drawable.rb_5
                    ),
                    StepItem(
                        "Bashkortostan Step 6",
                        "Введение в нефтяную промышленность",
                        R.drawable.rb_6
                    ),
                    StepItem(
                        "Bashkortostan Step 7",
                        "Введение в нефтяную промышленность",
                        R.drawable.rb_7
                    ),
                    StepItem(
                        "Bashkortostan Step 8",
                        "Введение в нефтяную промышленность",
                        R.drawable.rb_8
                    ),
                    StepItem(
                        "Bashkortostan Step 9",
                        "Введение в нефтяную промышленность",
                        R.drawable.rb_9
                    )
                )

                /*Данные на тему Введение в нефтяную промышленность*/
                2->arrayListOf<StepItem>(
                    StepItem("ITPT Step 1",
                        "Российская Федерация",
                        R.drawable.hy_7),
                    StepItem( "ITPT Step 2",
                        "башкортостан",
                        R.drawable.hy_1),
                    StepItem(
                        "ITPT Step 3",
                        "Введение в нефтяную промышленность",
                        R.drawable.hy_2
                    ),
                    StepItem( "ITPT Step 4",
                        "башкортостан",
                        R.drawable.hy_3),
                    StepItem(
                        "ITPT Step 5",
                        "Введение в нефтяную промышленность",
                        R.drawable.hy_4
                    ),
                    StepItem( "ITPT Step 6",
                        "башкортостан",
                        R.drawable.hy_5),
                    StepItem(
                        "ITPT Step 7",
                        "Введение в нефтяную промышленность",
                        R.drawable.hy_6
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