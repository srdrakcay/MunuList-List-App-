package com.serdar.mnlist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serdar.mnlist.data.Shopping
import com.serdar.mnlist.data.ShoppingDatabase
import com.serdar.mnlist.repository.ShoppingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ShoppingViewModel(application: Application): AndroidViewModel(application) {

    val readAllData:LiveData<List<Shopping>>
    private val repository:ShoppingRepository


    init{
    val shoppingDao = ShoppingDatabase.getDatabase(application).shoppingDao()
     repository= ShoppingRepository(shoppingDao)
     readAllData=shoppingDao.readAllData()
    }

    fun addShoping(shopping: Shopping){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addShopping(shopping)
        }
    }
    fun updateShoping(shopping: Shopping) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateShopping(shopping)
        }
    }
    fun deleteShoping(shopping: Shopping) {
            viewModelScope.launch(Dispatchers.IO) {
                repository.deleteShopping(shopping)
            }
        }
}