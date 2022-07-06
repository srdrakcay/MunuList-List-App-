package com.serdar.mnlist.repository

import androidx.lifecycle.LiveData
import com.serdar.mnlist.data.Shopping
import com.serdar.mnlist.data.ShoppingDao

class ShoppingRepository(private val shoppingDao: ShoppingDao) {

    val readAllData : LiveData<List<Shopping>> = shoppingDao.readAllData()

    suspend fun addShopping(shopping: Shopping){
        shoppingDao.addShopping(shopping)
    }
    suspend fun updateShopping(shopping: Shopping){
        shoppingDao.updateShopping(shopping)
    }
    suspend fun deleteShopping(shopping: Shopping){
        shoppingDao.deleteShopping(shopping)
    }
}