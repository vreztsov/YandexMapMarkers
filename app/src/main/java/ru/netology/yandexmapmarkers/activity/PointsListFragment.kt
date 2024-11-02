package ru.netology.yandexmapmarkers.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.*
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.netology.yandexmapmarkers.R
import ru.netology.yandexmapmarkers.databinding.FragmentPointsListBinding

@AndroidEntryPoint
class PointsListFragment : Fragment() {
    private lateinit var binding: FragmentPointsListBinding
//    private val viewModel: PointViewModel by activityViewModels()
//    private lateinit var adapter: PointsAdapter
//
//    private val interactionListener = object : OnInteractionListener {
//        override fun onEdit(pointMap: PointMap) {
//            findNavController().navigate(
//                R.id.action_pointsCrudFragment_to_fragmentNewPoint,
//                Bundle().apply {
//                    latitude = pointMap.latitude
//                    longitude = pointMap.longitude
//                    idPoint = pointMap.id
//                }
//            )
//        }
//
//        override fun onRemove(pointMap: PointMap) {
//            viewModel.removeById(pointMap.id)
//        }
//
//        override fun onMove(pointMap: PointMap) {
//            findNavController().navigate(
//                R.id.action_pointsCrudFragment_to_mapsFragment,
//                Bundle().apply {
//                    latitude = pointMap.latitude
//                    longitude = pointMap.longitude
//                    zoom = 15.0f
//                }
//            )
//        }
//    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPointsListBinding.inflate(layoutInflater)
//        adapter = PointsAdapter(interactionListener)
//        binding.list.adapter = adapter
//        viewModel.data.observe(viewLifecycleOwner) {
//            adapter.submitList(it)
//        }

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_pointsListFragment_to_mapsFragment)
        }
        return binding.root
    }
}