package me.vldf.lab35

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import me.vldf.lab35.databinding.FragmentFragSecondBinding


class FragSecond : Fragment() {
    private lateinit var binding: FragmentFragSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFragSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toFirst.setOnClickListener {
            findNavController().navigate(R.id.action_frag_2_to_frag_1)
        }
        binding.toThird.setOnClickListener {
            findNavController().navigate(R.id.action_frag_2_to_frag_3)
        }
    }
}