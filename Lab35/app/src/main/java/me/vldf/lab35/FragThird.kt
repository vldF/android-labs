package me.vldf.lab35

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import me.vldf.lab35.databinding.FragmentFragThirdBinding

class FragThird : Fragment() {
    private lateinit var binding: FragmentFragThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFragThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toFirst.setOnClickListener {
            findNavController().navigate(R.id.action_frag_3_to_frag_1)
        }
        binding.toSecond.setOnClickListener {
            findNavController().navigate(R.id.action_frag_3_to_frag_2)
        }
    }
}