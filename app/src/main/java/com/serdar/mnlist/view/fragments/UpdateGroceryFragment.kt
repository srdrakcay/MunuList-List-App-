package com.serdar.mnlist.view.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.serdar.mnlist.R
import com.serdar.mnlist.data.Shopping
import com.serdar.mnlist.data.grocery.Grocery
import com.serdar.mnlist.databinding.FragmentUpdateBinding
import com.serdar.mnlist.databinding.FragmentUpdateGroceryBinding
import com.serdar.mnlist.view.bottomBar.UpdateFragmentArgs
import com.serdar.mnlist.viewmodel.GroceryViewModel
import com.serdar.mnlist.viewmodel.ShoppingViewModel

class UpdateGroceryFragment : Fragment() {
    private  val groceryViewModel by lazy { GroceryViewModel(requireActivity().application) }
    private lateinit var binding: FragmentUpdateGroceryBinding
    private   val args by navArgs<UpdateGroceryFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentUpdateGroceryBinding.inflate(layoutInflater)
        binding.deleteGrocery.setOnClickListener {

            deleteShoppingData()
        }
        return binding.root
    }

    private fun deleteShoppingData() {
        groceryViewModel.deleteGrocery(args.currentGrocery)
        findNavController().navigate(R.id.action_updateGroceryFragment_to_homeFragment)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.productNames.setText(args.currentGrocery.name)
        binding.productStoresd.setText(args.currentGrocery.store)
        binding.productSizes.setText(args.currentGrocery.size.toString())
        binding.updateButtonGrocery.setOnClickListener {
            updateItem()
        }
    }
    private fun updateItem(){
        val groceryName=binding.productNames.text.toString()
        val groceryStore=binding.productStoresd.text.toString()
        val grocerySizes=binding.productSizes.text.toString()

        val updateGrocery=
            Grocery(args.currentGrocery.id,groceryName,groceryStore.toInt(),grocerySizes)
        groceryViewModel.updateGrocery(updateGrocery)
        findNavController().navigate(R.id.action_updateGroceryFragment_to_homeFragment)

        if(inputCheck(groceryName,groceryStore,grocerySizes)){
            Toast.makeText(requireContext(),"Updated ", Toast.LENGTH_SHORT).show()
        }
    }
    private fun inputCheck(shoppingName:String,shoppingStore:String,shoppingSizes:String):Boolean{
        return !(TextUtils.isEmpty(shoppingName)&& TextUtils.isEmpty(shoppingStore)&& TextUtils.isEmpty(shoppingSizes))
    }
}
