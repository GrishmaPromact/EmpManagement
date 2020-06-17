package com.grishma.adddemo.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.grishma.adddemo.data.repositories.DepartmentRepository

@Suppress("UNCHECKED_CAST")
class DepartmentViewModelFactory(
    private val repository: DepartmentRepository
) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DepartmentViewModel(repository) as T
    }
}