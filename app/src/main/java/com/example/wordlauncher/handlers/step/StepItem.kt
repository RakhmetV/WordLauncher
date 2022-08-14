package com.example.wordlauncher.handlers.step

class StepItem {
    var imageStep: Int = 0
    lateinit var nameStep: String
    lateinit var descriptionStep: String

    constructor(name: String, description: String, image: Int) {
        this.imageStep = image
        this.nameStep = name
        this.descriptionStep = description
    }
}