package com.androiddevs.grocerylist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.grishma.adddemo.data.repositories.DepartmentRepository
import com.grishma.adddemo.data.viewmodel.DepartmentViewModel

@Suppress("UNCHECKED_CAST")
class DepartmentViewModelFactory(
    private val repository: DepartmentRepository
) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DepartmentViewModel(repository) as T
    }
}