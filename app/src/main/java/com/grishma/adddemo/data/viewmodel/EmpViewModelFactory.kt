package com.grishma.adddemo.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.grishma.adddemo.data.repositories.EmployeeRepository

@Suppress("UNCHECKED_CAST")
class EmpViewModelFactory(
    private val repository: EmployeeRepository
) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return EmpViewModel(repository) as T
    }
}