package com.example.wordlauncher.data.firebase

class User() {
    lateinit var id: String
    lateinit var name: String
    lateinit var age: String
    lateinit var sex: String
    lateinit var imageURI: String
    lateinit var email: String
    lateinit var progress: ArrayList<ArrayList<ArrayList<Int>>>
    lateinit var vocabulary: ArrayList<ArrayList<String>>

    constructor(
        id: String,
        name: String,
        age: String,
        sex: String,
        imageURI: String,
        email: String,
        progress: ArrayList<ArrayList<ArrayList<Int>>>
    ) : this() {
        this.id = id
        this.name = name
        this.age = age
        this.sex = sex
        this.imageURI = imageURI
        this.email = email
        this.progress = progress
        this.vocabulary = arrayListOf(arrayListOf(""), arrayListOf(""), arrayListOf(""))
    }
}