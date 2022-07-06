package com.serdar.mnlist.view.bottomBar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.serdar.mnlist.R
import com.serdar.mnlist.data.Shopping
import com.serdar.mnlist.databinding.FragmentShoppingBinding
import com.serdar.mnlist.viewmodel.ShoppingViewModel

class ShoppingFragment : Fragment() {
    private  val shoppingViewModel by lazy { ShoppingViewModel(requireActivity().application) }

    private lateinit var binding:FragmentShoppingBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding=FragmentShoppingBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addButton.setOnClickListener {
            val shopping=Shopping(id = 0,binding.productName.editText.toString(),binding.productStore.editText.toString(),binding.productSize.editText.toString())
            shoppingViewModel.addShoping(shopping)
        }
    }

}