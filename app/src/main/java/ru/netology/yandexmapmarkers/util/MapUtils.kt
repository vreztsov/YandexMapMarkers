package ru.netology.yandexmapmarkers.util

import android.os.Bundle

class MapUtils {
    companion object {
        var Bundle.latitude: Double
            set(value) = putDouble("PointLatitude", value)
            get() = getDouble("PointLatitude")
        var Bundle.longitude: Double
            set(value) = putDouble("PointLongitude", value)
            get() = getDouble("PointLongitude")
        var Bundle.idPoint: Int
            set(value) = putInt("PointId", value)
            get() = getInt("PointId")
        var Bundle.zoom: Float
            set(value) = putFloat("PointZoom", value)
            get() = getFloat("PointZoom")
    }
}
