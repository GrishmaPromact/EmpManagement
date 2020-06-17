package com.androiddevs.grocerylist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.grishma.adddemo.data.repositories.DepartmentRepository
import com.grishma.adddemo.data.repositories.EmployeeRepository
import com.grishma.adddemo.data.viewmodel.DepartmentViewModel
import com.grishma.adddemo.data.viewmodel.EmpViewModel

@Suppress("UNCHECKED_CAST")
class EmpViewModelFactory(
    private val repository: EmployeeRepository
) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return EmpViewModel(repository) as T
    }
}