package ru.netology.yandexmapmarkers.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.netology.yandexmapmarkers.dto.PointMap
import ru.netology.yandexmapmarkers.R
import ru.netology.yandexmapmarkers.databinding.FragmentNewPointBinding
import ru.netology.yandexmapmarkers.util.MapUtils.Companion.idPoint
import ru.netology.yandexmapmarkers.util.MapUtils.Companion.latitude
import ru.netology.yandexmapmarkers.util.MapUtils.Companion.longitude
//import ru.netology.yandexmapmarkers.viewmodel.PointViewModel

@AndroidEntryPoint
class NewPointFragment : Fragment() {
    private lateinit var binding: FragmentNewPointBinding
//    private val viewModel: PointViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewPointBinding.inflate(layoutInflater)
        val coordinate = "${arguments?.latitude}; ${arguments?.longitude}"
        binding.coordinate.text = coordinate
        binding.sendPoint.setOnClickListener {
            if (!binding.inputEditTitle.text.isNullOrEmpty()) {
//                arguments?.idPoint?.let {
//                    with(requireArguments()) {
//                        viewModel.savePoint(
//                            PointMap(
//                                idPoint, latitude, longitude,
//                                binding.inputEditTitle.text.toString(),
//                                binding.inputEditDescription.text.toString()
//                            )
//                        )
//
//                    }
//                }
                findNavController().navigate(R.id.action_newPointFragment_to_pointsListFragment)
            }
        }
        return binding.root
    }
}