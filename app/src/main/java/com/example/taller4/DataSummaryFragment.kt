package com.example.taller4

import ProductViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taller4.databinding.FragmentDataSummaryBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DataSummaryFragment : Fragment() {
    private var _binding: FragmentDataSummaryBinding? = null
    private val binding get() = _binding!!
    private val productViewModel: ProductViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDataSummaryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ProductAdapter(productViewModel.products.value ?: mutableListOf())
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        productViewModel.products.observe(viewLifecycleOwner) { products ->
            adapter.notifyDataSetChanged()
            binding.productCountTextView.text = "Total de Productos: ${products.size}"
        }

        binding.addButton.setOnClickListener {
            findNavController().navigate(R.id.action_dataSummaryFragment_to_addProductFragment)
        }

        binding.updateButton.setOnClickListener {
            binding.clockTextView.text = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}