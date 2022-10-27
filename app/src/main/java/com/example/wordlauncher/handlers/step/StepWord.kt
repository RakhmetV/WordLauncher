package com.example.wordlauncher.handlers.step

class StepWord {
    lateinit var word_en: String
    lateinit var word_transcription: String
    lateinit var word_ru: String
    var sound: Int = 0

    constructor(en: String, transcription: String, ru: String, sound: Int) {
        this.word_en = en
        this.word_transcription = transcription
        this.word_ru = ru
        this.sound = sound
    }
}