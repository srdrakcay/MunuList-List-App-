package com.serdar.mnlist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.serdar.mnlist.R
import com.serdar.mnlist.data.Shopping
import com.serdar.mnlist.view.bottomBar.UpdateFragment

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private var shoppingList= emptyList<Shopping>()
    class MyViewHolder(view: View):RecyclerView.ViewHolder(view) {

        val shopStore=view.findViewById<TextView>(R.id.shopStore)
        val shopSize=view.findViewById<TextView>(R.id.shopSize)
        val shopName=view.findViewById<TextView>(R.id.shopName)


        fun bind(shopping: Shopping){
            shopName.setText(shopping.name)
            shopSize.setText(shopping.size)
            shopStore.setText(shopping.store)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):RecyclerViewAdapter.MyViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {
        val currentShopping=shoppingList[position]
        holder.bind(currentShopping)
        holder.itemView.setOnClickListener{

        }
    }

    override fun getItemCount(): Int {
        return shoppingList.size
    }
    fun setData(shoppingList: List<Shopping>){
        this.shoppingList=shoppingList
        notifyDataSetChanged()
    }
}