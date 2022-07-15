package com.serdar.mnlist.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.serdar.mnlist.adapter.RecyclerViewAdapter
import com.serdar.mnlist.data.ShoppingDatabase
import com.serdar.mnlist.databinding.FragmentShoppingListBinding
import com.serdar.mnlist.viewmodel.ShoppingViewModel

class ShoppingListFragment : Fragment() {

    private  val shoppingViewModel by lazy { ShoppingViewModel(requireActivity().application) }
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var binding: FragmentShoppingListBinding
    private lateinit var shoppingDatabase: ShoppingDatabase
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentShoppingListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter=RecyclerViewAdapter()
        binding.rvShopping.layoutManager= LinearLayoutManager(requireContext())
        binding.rvShopping.adapter=adapter

        shoppingViewModel.readAllData.observe(requireActivity(), Observer { shoppingList ->
            adapter.setDataShopping(shoppingList)

        })

    }
}