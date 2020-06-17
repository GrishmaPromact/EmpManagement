package com.grishma.adddemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androiddevs.grocerylist.ui.shoppinglist.EmpViewModelFactory
import com.grishma.adddemo.AddDialogListener
import com.grishma.adddemo.AddEmployeeItemDialog
import com.grishma.adddemo.R
import com.grishma.adddemo.data.viewmodel.DepartmentViewModel
import com.grishma.adddemo.data.viewmodel.EmpViewModel
import com.grishma.adddemo.db.entities.DepartmentItem
import com.grishma.adddemo.db.entities.EmployeeItem
import kotlinx.android.synthetic.main.item_categories.view.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class DepartmentItemAdapter(
    var context: Context,
    var items: List<DepartmentItem>,
    private val viewModel: DepartmentViewModel,
    private val viewModel1: EmpViewModel,
    override val kodein: Kodein
):
    RecyclerView.Adapter<DepartmentItemAdapter.DepartmentViewHolder>() ,KodeinAware{

    private val factory1: EmpViewModelFactory by instance()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepartmentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_categories, parent, false)

        return DepartmentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: DepartmentViewHolder, position: Int) {
        val curShoppingItem = items[position]
        val adapterEmp = EmpItemAdapter(
            curShoppingItem.empList,
            viewModel1,
            viewModel,
            curShoppingItem
        )

        holder.itemView.rvEmployee?.layoutManager = LinearLayoutManager(context)
        holder.itemView.rvEmployee?.adapter = adapterEmp
        viewModel1.getAllEmpItems().observe(this@DepartmentItemAdapter, Observer {
            adapterEmp.itemsEmpList = it
            adapterEmp.notifyDataSetChanged()
        })
        holder.itemView.tvCategory.text = curShoppingItem.name

        holder.itemView.ivAdd.setOnClickListener {
            AddEmployeeItemDialog(context,curShoppingItem, object : AddDialogListener {
                    override fun onAddButtonClicked(
                        item: EmployeeItem,
                        curShoppingItem :DepartmentItem
                    ) {

                        holder.itemView.rvEmployee?.layoutManager = LinearLayoutManager(context)
                        holder.itemView.rvEmployee?.adapter = adapterEmp
                        viewModel1.getAllEmpItems().observe(this@DepartmentItemAdapter, Observer {
                            adapterEmp.itemsEmpList = it
                            adapterEmp.notifyDataSetChanged()
                        })
                        viewModel.insert(curShoppingItem)
                    }
                }).show()
        }

    }

    inner class DepartmentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    interface AddButtonListener {
        fun onAddButtonClickedOfDepartment(
            item: EmployeeItem,
            context: Context,
            curShoppingItem :DepartmentItem
        )
    }
}

private fun <T> LiveData<T>.observe(departmentItemAdapter: DepartmentItemAdapter, observer: Observer<T>) {

}



