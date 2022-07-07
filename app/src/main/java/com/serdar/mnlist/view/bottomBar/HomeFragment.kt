package com.serdar.mnlist.view.bottomBar

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.serdar.mnlist.adapter.RecyclerViewAdapter
import com.serdar.mnlist.data.ShoppingDatabase
import com.serdar.mnlist.databinding.FragmentHomeBinding
import com.serdar.mnlist.viewmodel.ShoppingViewModel

class HomeFragment : Fragment() {

    private  val shoppingViewModel by lazy { ShoppingViewModel(requireActivity().application) }
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var binding: FragmentHomeBinding
    private lateinit var shoppingDatabase: ShoppingDatabase


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter=RecyclerViewAdapter()

        binding.rvView.layoutManager=LinearLayoutManager(requireContext())
        binding.rvView.adapter=adapter

        shoppingViewModel.readAllData.observe(requireActivity(), Observer { shoppingList ->
            adapter.setData(shoppingList)
            if (shoppingList !=null){
                Toast.makeText(requireContext(),"No Data",Toast.LENGTH_SHORT).show()
            }
        })
}

}