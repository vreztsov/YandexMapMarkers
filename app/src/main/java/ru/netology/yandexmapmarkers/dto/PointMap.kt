package ru.netology.yandexmapmarkers.dto

data class PointMap(
    val id: Int,
    val latitude: Double,
    val longitude: Double,
    val title: String,
    val description: String,
)