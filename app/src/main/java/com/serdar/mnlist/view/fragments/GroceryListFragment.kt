package com.serdar.mnlist.view.fragments

import RecyclerViewAdapterTwo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.serdar.mnlist.data.ShoppingDatabase
import com.serdar.mnlist.databinding.FragmentGroceryListBinding
import com.serdar.mnlist.viewmodel.GroceryViewModel


class GroceryListFragment : Fragment() {

    private  val shoppingViewModel by lazy { GroceryViewModel(requireActivity().application) }
    private lateinit var recyclerViewAdapter: RecyclerViewAdapterTwo
    private lateinit var binding: FragmentGroceryListBinding
    private lateinit var shoppingDatabase: ShoppingDatabase
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentGroceryListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter=RecyclerViewAdapterTwo()
        binding.rcGrocery.layoutManager= LinearLayoutManager(requireContext())
        binding.rcGrocery.adapter=adapter

        shoppingViewModel.readAllDataGrocerys.observe(requireActivity(), Observer { groceryList ->
            adapter.setData(groceryList)

        })
    }

}