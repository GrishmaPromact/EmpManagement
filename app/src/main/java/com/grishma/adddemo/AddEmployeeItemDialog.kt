package com.grishma.adddemo

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.grishma.adddemo.db.entities.DepartmentItem
import com.grishma.adddemo.db.entities.EmployeeItem
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*

class AddEmployeeItemDialog(
    context: Context,
    var curShoppingItem : DepartmentItem,
    var addDialogListener: AddDialogListener
) :
    AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_add_shopping_item)

        tvAdd.setOnClickListener {
            val name = etEmail.text.toString()
            if(name.isNullOrEmpty()) {
                Toast.makeText(context, "Please enter a email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = EmployeeItem(name)
            curShoppingItem.empList.add(item)
            addDialogListener.onAddButtonClicked(item,curShoppingItem)
            dismiss()
        }

        tvCancel.setOnClickListener {
            cancel()
        }
    }
}