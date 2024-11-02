package ru.netology.yandexmapmarkers.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.mapview.MapView
import dagger.hilt.android.AndroidEntryPoint
import ru.netology.yandexmapmarkers.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val mapView by lazy { findViewById<MapView>(R.id.mapview) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.initialize(this)
    }
}
