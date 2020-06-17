package com.grishma.adddemo.data.viewmodel

import androidx.lifecycle.ViewModel
import com.grishma.adddemo.data.repositories.DepartmentRepository
import com.grishma.adddemo.data.repositories.EmployeeRepository
import com.grishma.adddemo.db.entities.DepartmentItem
import com.grishma.adddemo.db.entities.EmployeeItem
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EmpViewModel(
    private val repository: EmployeeRepository) : ViewModel() {

    fun insert(item: EmployeeItem) = GlobalScope.launch {
            repository.insert(item)
        }

    fun delete(item: EmployeeItem) = GlobalScope.launch {
        repository.delete(item)
    }

    fun getAllEmpItems() = repository.getAllEmpItems()

}
