package com.example.wordlauncher.data.dataachievements

class DataAchiv {
    var imageAchivements: Int = 0
    lateinit var nameAchievements: String
    lateinit var descriptionAchievements: String
    lateinit var AchievementsCount: String

    constructor(
        imageAchivements: Int,
        nameAchievements: String,
        descriptionAchievements: String,
        AchievementsCount: String
    ) {
        this.imageAchivements = imageAchivements
        this.nameAchievements = nameAchievements
        this.descriptionAchievements = descriptionAchievements
        this.AchievementsCount = AchievementsCount
    }
}