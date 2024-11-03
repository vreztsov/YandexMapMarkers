package ru.netology.yandexmapmarkers.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.Map
import dagger.hilt.android.AndroidEntryPoint
import ru.netology.yandexmapmarkers.R
import ru.netology.yandexmapmarkers.databinding.FragmentMapsBinding
import ru.netology.yandexmapmarkers.util.MapUtils.Companion.idPoint
import ru.netology.yandexmapmarkers.util.MapUtils.Companion.latitude
import ru.netology.yandexmapmarkers.util.MapUtils.Companion.longitude
import ru.netology.yandexmapmarkers.util.MapUtils.Companion.zoom

@AndroidEntryPoint
class MapsFragment : Fragment() {

    private lateinit var binding: FragmentMapsBinding
    private lateinit var map: Map

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMapsBinding.inflate(layoutInflater)
        map = binding.mapview.mapWindow.map
        val latitudeMap = arguments?.latitude ?: 55.753475
        val longitudeMap = arguments?.longitude ?: 37.621555
        var zoomMap = arguments?.zoom ?: 12.0f
        map.move(
            CameraPosition(Point(latitudeMap, longitudeMap), zoomMap, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 3F),
            null
        )
        zoomMap = map.cameraPosition.zoom

        map.addCameraListener { _, cameraPosition, _, _ ->

            binding.point.setOnLongClickListener {
                val point = cameraPosition.target
                findNavController().navigate(
                    R.id.action_mapsFragment_to_newPointFragment,
                    Bundle().apply {
                        latitude = point.latitude
                        longitude = point.longitude
                        idPoint = 0
                    }
                )
                true
            }
        }
        binding.zoomIn.setOnClickListener {
            zoom(2F)
            zoomMap = map.cameraPosition.zoom
        }
        binding.zoomOut.setOnClickListener {
            zoom(-2F)
            zoomMap = map.cameraPosition.zoom
        }

        binding.savedPlaces.setOnClickListener {
            findNavController().navigate(R.id.action_mapsFragment_to_pointsListFragment)
        }
        return binding.root
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        with(map.cameraPosition) {
//            outState.latitude = target.latitude
//            outState.longitude = target.longitude
//            outState.zoom = zoom
//        }
//    }

    private fun zoom(delta: Float) {
        val position = map.cameraPosition
        with(position) {
            val localZoomMap = zoom + delta
                map.move(
                CameraPosition(target, localZoomMap, azimuth, tilt),
                Animation(com.yandex.mapkit.Animation.Type.SMOOTH, 0.5F),
                null
            )
        }
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        binding.mapview.onStart()
    }

    override fun onStop() {
        binding.mapview.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

}