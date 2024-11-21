package com.example.taller4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.taller4.databinding.FragmentItemDetailBinding

class ItemDetailFragment : Fragment() {
    private var _binding: FragmentItemDetailBinding? = null
    private val binding get() = _binding!!
    private val args: ItemDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.detailTextView.text = args.item
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}