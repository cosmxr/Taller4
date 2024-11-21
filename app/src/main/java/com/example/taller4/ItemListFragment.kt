package com.example.taller4

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.taller4.databinding.FragmentItemListBinding
import java.text.SimpleDateFormat
import java.util.*

class ItemListFragment : Fragment() {
    private var _binding: FragmentItemListBinding? = null
    private val binding get() = _binding!!
    private lateinit var clockTextView: TextView
    private lateinit var greetingTextView: TextView
    private val handler = Handler(Looper.getMainLooper())
    private val timeFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clockTextView = binding.clockTextView
        greetingTextView = binding.greetingTextView
        val navigateButton: Button = binding.navigateButton

        updateClock()
        updateGreeting()

        navigateButton.setOnClickListener {
            val action = ItemListFragmentDirections.actionItemListFragmentToItemDetailFragment()
            findNavController().navigate(action)
        }
    }

    private fun updateClock() {
        clockTextView.text = timeFormat.format(Date())
        handler.postDelayed({ updateClock() }, 1000)
    }

    private fun updateGreeting() {
        val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        val greeting = when (hour) {
            in 0..11 -> "Buenos dias"
            in 12..21 -> "Buenas tardes"
            else -> "Buenas noches"
        }
        greetingTextView.text = greeting
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}