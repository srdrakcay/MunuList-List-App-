package com.serdar.mnlist.view.bottomBar

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.serdar.mnlist.R
import com.serdar.mnlist.data.Shopping
import com.serdar.mnlist.databinding.FragmentUpdateBinding
import com.serdar.mnlist.viewmodel.ShoppingViewModel

class UpdateFragment : Fragment() {
    private  val shoppingViewModel by lazy { ShoppingViewModel(requireActivity().application) }
    private lateinit var binding:FragmentUpdateBinding
    private   val args by navArgs<UpdateFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentUpdateBinding.inflate(layoutInflater)

        binding.deleteButton.setOnClickListener {
            deleteShoppingData()
        }


        return binding.root
    }

    private fun deleteShoppingData() {

        shoppingViewModel.deleteShoping(args.currentShopping)
        findNavController().navigate(R.id.action_updateFragment_to_homeFragment)
        }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.productNames.setText(args.currentShopping.name)
        binding.productStores.setText(args.currentShopping.store)
        binding.productSizes.setText(args.currentShopping.size)
        binding.updateButton.setOnClickListener {
            updateItem()
        }
    }
    private fun updateItem(){
        val shoppingName=binding.productNames.text.toString()
        val shoppingStore=binding.productStores.text.toString()
        val shoppingSizes=binding.productSizes.text.toString()

        val updateShopping=Shopping(args.currentShopping.id,shoppingName,shoppingStore,shoppingSizes)
        shoppingViewModel.updateShoping(updateShopping)
        findNavController().navigate(R.id.action_updateFragment_to_homeFragment)

        if(inputCheck(shoppingName,shoppingStore,shoppingSizes)){
            Toast.makeText(requireContext(),"Updated ", Toast.LENGTH_SHORT).show()
        }
    }
    private fun inputCheck(shoppingName:String,shoppingStore:String,shoppingSizes:String):Boolean{
        return !(TextUtils.isEmpty(shoppingName)&& TextUtils.isEmpty(shoppingStore)&& TextUtils.isEmpty(shoppingSizes))
}

}


