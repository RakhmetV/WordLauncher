package com.example.wordlauncher.handlers.header

class HeaderForSpinner {
    var imageHeader: Int = 0
    lateinit var nameHeader: String
    lateinit var descriptionHeader: String
    var countStep: String

    constructor(image: Int, name: String, description: String, count: String) {
        this.imageHeader = image
        this.nameHeader = name
        this.descriptionHeader = description
        this.countStep = count
    }


}