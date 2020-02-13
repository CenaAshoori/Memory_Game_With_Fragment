package com.ciniur.memorygame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.ciniur.memorygame.databinding.FragmentLoseBinding

/**
 * A simple [Fragment] subclass.
 */
class GameLoseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentLoseBinding>(inflater,R.layout.fragment_lose
        ,container,false)

        binding.btnTry.setOnClickListener {
            it.findNavController().navigate(R.id.action_gameLoseFragment_to_gameFragment)
        }
        return binding.root
    }
}
