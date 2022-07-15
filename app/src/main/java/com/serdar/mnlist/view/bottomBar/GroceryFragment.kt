package com.serdar.mnlist.view.bottomBar

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.serdar.mnlist.R
import com.serdar.mnlist.data.grocery.Grocery
import com.serdar.mnlist.databinding.FragmentGroceryBinding
import com.serdar.mnlist.viewmodel.GroceryViewModel

class GroceryFragment : Fragment() {
    private  val groceryViewModel by lazy { GroceryViewModel(requireActivity().application) }

    private lateinit var binding: FragmentGroceryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentGroceryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addButtonz.setOnClickListener {
            insertData()
            findNavController().navigate(R.id.action_groceryFragment_to_homeFragment)

        }
    }

    private fun insertData() {
        val productName =binding.productNamez.text.toString()
        val productSize =binding.productSizez.text.toString()
        val productStore =binding.productStorez.text.toString()

        val grocery= Grocery(0,productName,productSize.toInt(),productStore)
        groceryViewModel.addGrocery(grocery)

        if(inputCheck(productName,productSize,productStore)){
            Toast.makeText(requireContext(),"Empty List ", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(productNamez:String,prodoctSizez:String,productStorez:String):Boolean{
        return !(TextUtils.isEmpty(productNamez)&& TextUtils.isEmpty(prodoctSizez)&& TextUtils.isEmpty(productStorez))

    }

}