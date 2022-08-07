package com.example.wordlauncher.data.datacourses

import com.example.wordlauncher.R
import com.example.wordlauncher.handlers.header.HeaderForSpinner

class DataCourses {
    companion object{
        val headerClassList = arrayListOf<HeaderForSpinner>(
            HeaderForSpinner(R.drawable.russia, "Russian Federation", "Российская Федерация"),
            HeaderForSpinner(R.drawable.bashkortostan, "Bashkortostan", "башкортостан"),
            HeaderForSpinner(
                R.drawable.russia,
                "Introduction to Petroleum Industry",
                "Введение в нефтяную промышленность"
            )
        )

    }
}