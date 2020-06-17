package com.grishma.adddemo.data.viewmodel

import androidx.lifecycle.ViewModel
import com.grishma.adddemo.data.repositories.DepartmentRepository
import com.grishma.adddemo.db.entities.DepartmentItem
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DepartmentViewModel(
    private val repository: DepartmentRepository) : ViewModel() {

    fun insert(item: DepartmentItem) = GlobalScope.launch {
            repository.insert(item)
        }

    fun delete(item: DepartmentItem) = GlobalScope.launch {
        repository.delete(item)
    }

    fun getAllDepartmentItems() = repository.getAllDepartmentItems()

}
