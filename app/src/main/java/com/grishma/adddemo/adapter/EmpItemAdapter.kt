package com.grishma.adddemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.grishma.adddemo.R
import com.grishma.adddemo.data.viewmodel.DepartmentViewModel
import com.grishma.adddemo.data.viewmodel.EmpViewModel
import com.grishma.adddemo.db.entities.DepartmentItem
import com.grishma.adddemo.db.entities.EmployeeItem
import kotlinx.android.synthetic.main.item_employee.view.*

class EmpItemAdapter(
    var itemsEmpList: MutableList<EmployeeItem>,
    private val viewModel: EmpViewModel,
    var viewModel1: DepartmentViewModel,
    var departmentItem: DepartmentItem
) :
    RecyclerView.Adapter<EmpItemAdapter.EmpViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmpViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_employee, parent, false)
        return EmpViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemsEmpList.size
    }

    override fun onBindViewHolder(holder: EmpViewHolder, position: Int) {
        val curShoppingItem = itemsEmpList[position]

        holder.itemView.tvEmail.text = curShoppingItem.email

        holder.itemView.ivRemove.setOnClickListener {
            if (itemsEmpList.size == 0)
                viewModel1.delete(departmentItem)
            else {
                if (position == 0 && itemsEmpList.size==1)
                    viewModel1.delete(departmentItem)
                else {
                    departmentItem.empList.removeAt(position)
                    viewModel1.insert(departmentItem)
                }
            }
            //itemsEmpList.removeAt(position)
            viewModel.delete(curShoppingItem)
            notifyItemRemoved(position)

        }
    }

    inner class EmpViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}

private fun observe() {

}
