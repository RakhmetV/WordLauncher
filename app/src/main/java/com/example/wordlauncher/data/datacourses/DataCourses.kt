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
                "Ask not what your country can do for you, ask what you can do for your country",
            "Number of steps: 6"),
            HeaderForSpinner(R.drawable.rb_icon,
                "Bashkortostan",
                "East or West, Home is Best",
            "Number of steps: 9"),
            HeaderForSpinner(
                R.drawable.hydrocarbon_module,
                "Introduction to Petroleum Industry",
                "My Formula for Success? Rise Early, Work Late, Strike Oil",
                "Number of steps: 7"
            )
        )
        fun stepDataList(position: Int): ArrayList<StepItem>{
            return when(position){
                /*Данные на тему Российской Федерации*/
                0->arrayListOf<StepItem>(
                    StepItem("Highway М5 “Ural”",
                        "Российская Федерация",
                        R.drawable.rf_1),
                    StepItem( "Highway М7 “Volga”",
                        "башкортостан",
                        R.drawable.rf_2),
                    StepItem(
                        "Highway М29 “Kavkaz",
                        "Введение в нефтяную промышленность",
                        R.drawable.rf_3
                    ),
                    StepItem(
                        "Highway М6 “Kaspij”",
                        "Введение в нефтяную промышленность",
                        R.drawable.rf_4
                    ),
                    StepItem(
                        "Highway М4 “Don”",
                        "Введение в нефтяную промышленность",
                        R.drawable.rf_5
                    ),
                    StepItem(
                        "Highway М8 “Kholmogory”",
                        "Введение в нефтяную промышленность",
                        R.drawable.rf_6
                    )
                )

                /*Данные на тему Башкортостан*/
                1->arrayListOf<StepItem>(
                    StepItem("Explore national park “Bashkortostan”",
                        "Российская Федерация",
                        R.drawable.rb_1),
                    StepItem( "Visit Shulgan-Tash",
                        "башкортостан",
                        R.drawable.rb_2),
                    StepItem(
                        "Climb Iremel",
                        "Введение в нефтяную промышленность",
                        R.drawable.rb_3
                    ),
                    StepItem(
                        "Enjoy a sunrise in Aigir",
                        "Введение в нефтяную промышленность",
                        R.drawable.rb_4
                    ),
                    StepItem(
                        "Taste kumis",
                        "Введение в нефтяную промышленность",
                        R.drawable.rb_5
                    ),
                    StepItem(
                        "Take a glance at Yamantau",
                        "Введение в нефтяную промышленность",
                        R.drawable.rb_6
                    ),
                    StepItem(
                        "Experience wild-water rafting",
                        "Введение в нефтяную промышленность",
                        R.drawable.rb_7
                    ),
                    StepItem(
                        "Go horse riding",
                        "Введение в нефтяную промышленность",
                        R.drawable.rb_8
                    ),
                    StepItem(
                        "Go skiing in Abzakovo",
                        "Введение в нефтяную промышленность",
                        R.drawable.rb_9
                    )
                )

                /*Данные на тему Введение в нефтяную промышленность*/
                2->arrayListOf<StepItem>(
                    StepItem("Petroleum is older than dinosaurs",
                        "Российская Федерация",
                        R.drawable.hy_7),
                    StepItem( "Bubblegum is made from oil",
                        "башкортостан",
                        R.drawable.hy_1),
                    StepItem(
                        "345 A.D. – The first oil well drilled in China",
                        "Введение в нефтяную промышленность",
                        R.drawable.hy_2
                    ),
                    StepItem( "15 km – The world’s deepest oil well drilled in Russia",
                        "башкортостан",
                        R.drawable.hy_3),
                    StepItem(
                        "The first oil pipeline was made of bamboo",
                        "Введение в нефтяную промышленность",
                        R.drawable.hy_4
                    ),
                    StepItem( "Petroleum means mountain oil",
                        "башкортостан",
                        R.drawable.hy_5),
                    StepItem(
                        "8900 km – the world’s longest pipeline “Druzhba”",
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