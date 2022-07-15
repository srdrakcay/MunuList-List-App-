package com.serdar.mnlist.view.bottomBar

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.serdar.mnlist.adapter.RecyclerViewAdapter
import com.serdar.mnlist.adapter.ViewPagerAdapter
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

        val adapter =ViewPagerAdapter(requireActivity().supportFragmentManager,lifecycle)

        binding.viewPager.adapter=adapter
        TabLayoutMediator(binding.tabLayout,binding.viewPager){tab,position->
            when(position){
               0->{tab.text="Grocery List" }
                1->{tab.text="Shopping List"}
        }
        }.attach()
}
}