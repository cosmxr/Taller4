package com.example.taller4

import Product
import ProductViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.taller4.databinding.FragmentAddProductBinding

class AddProductFragment : Fragment() {
    private var _binding: FragmentAddProductBinding? = null
    private val binding get() = _binding!!
    private val productViewModel: ProductViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveButton.setOnClickListener {
            try {
                val serialNumber = binding.serialNumberEditText.text.toString()
                val productName = binding.productNameEditText.text.toString()
                val price = binding.priceEditText.text.toString().toDoubleOrNull()
                val quantity = binding.quantityEditText.text.toString().toIntOrNull()

                if (serialNumber.isBlank() || productName.isBlank() || price == null || quantity == null) {
                    binding.errorTextView.text = "Error: Input incorrecto."
                    return@setOnClickListener
                }

                val product = Product(serialNumber, productName, price, quantity)
                productViewModel.addProduct(product)
                findNavController().navigateUp()
            } catch (e: Exception) {
                binding.errorTextView.text = "Error: ${e.message}"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}