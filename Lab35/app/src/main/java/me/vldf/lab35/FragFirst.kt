package me.vldf.lab35

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import me.vldf.lab35.databinding.FragmentFragFirstBinding
import me.vldf.lab35.databinding.MainActivityBinding

class FragFirst : Fragment() {
    private lateinit var binding: FragmentFragFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFragFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bnToSecond.setOnClickListener {
            findNavController().navigate(R.id.action_frag_1_to_frag_2)
        }

    }
}