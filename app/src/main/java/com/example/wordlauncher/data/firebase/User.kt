package com.example.wordlauncher.data.firebase

class User {
    lateinit var progress: ArrayList<ArrayList<ArrayList<Int>>>
    lateinit var achievements: ArrayList<Int>
    lateinit var username: String

    constructor() {
        this.progress = arrayListOf(
            arrayListOf(
                arrayListOf(0, -1, -1, -1, -1, -1),
                arrayListOf(-1, -1, -1, -1, -1, -1),
                arrayListOf(-1, -1, -1, -1, -1, -1),
                arrayListOf(-1, -1, -1, -1, -1, -1),
                arrayListOf(-1, -1, -1, -1, -1, -1),
                arrayListOf(-1, -1, -1, -1, -1, -1)
            ),
            arrayListOf(
                arrayListOf(0, -1, -1, -1, -1, -1),
                arrayListOf(-1, -1, -1, -1, -1, -1),
                arrayListOf(-1, -1, -1, -1, -1, -1),
                arrayListOf(-1, -1, -1, -1, -1, -1),
                arrayListOf(-1, -1, -1, -1, -1, -1),
                arrayListOf(-1, -1, -1, -1, -1, -1),
                arrayListOf(-1, -1, -1, -1, -1, -1),
                arrayListOf(-1, -1, -1, -1, -1, -1),
                arrayListOf(-1, -1, -1, -1, -1, -1)
            ),
            arrayListOf(
                arrayListOf(0, -1, -1, -1, -1, -1),
                arrayListOf(-1, -1, -1, -1, -1, -1),
                arrayListOf(-1, -1, -1, -1, -1, -1),
                arrayListOf(-1, -1, -1, -1, -1, -1),
                arrayListOf(-1, -1, -1, -1, -1, -1),
                arrayListOf(-1, -1, -1, -1, -1, -1),
                arrayListOf(-1, -1, -1, -1, -1, -1)
            )
        )
        this.achievements = arrayListOf(-1,-1,-1,-1,-1,-1,-1,-1,-1,-1)
        this.username = ""

    }
}