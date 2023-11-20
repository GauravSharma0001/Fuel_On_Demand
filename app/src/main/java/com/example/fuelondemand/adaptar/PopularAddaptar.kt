package com.example.fuelondemand.adaptar

import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fuelondemand.R
import com.example.fuelondemand.databinding.PopularItemBinding

class PopularAddaptar(private val items:List<String>,private val price:List<String> ,private val image: List<Int> ) :RecyclerView.Adapter<PopularAddaptar.PopularViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }



    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val items = items[position]
        val images = image[position]
        val price = price[position]
        holder.bind(items,price,images)
    }
    override fun getItemCount(): Int {
        return items.size
    }
    class PopularViewHolder(private val binding: PopularItemBinding):RecyclerView.ViewHolder(binding.root) {
        private val imageView = binding.imageView4
        fun bind(items: String, price: String, images: Int) {

            binding.fuelPopular.text = items
            binding.pricePopular.text = price
            imageView.setImageResource(images)


        }


    }
    }
