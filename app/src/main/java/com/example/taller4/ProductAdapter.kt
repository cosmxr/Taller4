package com.example.taller4

import Product
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val serialNumberTextView: TextView = view.findViewById(R.id.serialNumberTextView)
        val productNameTextView: TextView = view.findViewById(R.id.productNameTextView)
        val priceTextView: TextView = view.findViewById(R.id.priceTextView)
        val quantityTextView: TextView = view.findViewById(R.id.quantityTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.serialNumberTextView.text = "Número de Serie:  ${product.serialNumber}"
        holder.productNameTextView.text = "Nombre:  ${product.productName}"
        holder.priceTextView.text = "Precio:  ${product.price}"
        holder.quantityTextView.text = "Cantidad: ${product.quantity}"
    }

    override fun getItemCount() = products.size
}