package com.grishma.adddemo

import com.grishma.adddemo.db.entities.DepartmentItem
import com.grishma.adddemo.db.entities.EmployeeItem


interface AddDialogListener {
    fun onAddButtonClicked(
        item: EmployeeItem,
        curShoppingItem : DepartmentItem
    )
}