package com.example.fuelondemand.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fuelondemand.R
import com.example.fuelondemand.databinding.FragmentHomeBinding
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root


    }

    override fun onViewCreated(view: android.view.View, savedInstanceState: android.os.Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner1,
            com.denzcoskun.imageslider.constants.ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner2,
            com.denzcoskun.imageslider.constants.ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner3,
            com.denzcoskun.imageslider.constants.ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList, com.denzcoskun.imageslider.constants.ScaleTypes.FIT)
        imageSlider.setOnClickListener(object: ItemClickListener, View.OnClickListener {
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemPosition = imageList[position]
                val itemMessage = "Selected Image $position"
                Toast.makeText(requireContext(), itemMessage, Toast.LENGTH_SHORT).show()

            }

            override fun onClick(p0: View?) {
                TODO("Not yet implemented")
            }
        })
    }
    companion object {

                }

    
}