package com.grishma.adddemo

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.androiddevs.grocerylist.ui.shoppinglist.EmpViewModelFactory
import com.grishma.adddemo.adapter.CustomDropDownAdapter
import com.grishma.adddemo.adapter.DepartmentItemAdapter
import com.grishma.adddemo.data.viewmodel.DepartmentViewModel
import com.grishma.adddemo.data.viewmodel.DepartmentViewModelFactory
import com.grishma.adddemo.data.viewmodel.EmpViewModel
import com.grishma.adddemo.db.entities.DepartmentItem
import com.grishma.adddemo.db.entities.EmployeeItem
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val factory: DepartmentViewModelFactory by instance()
    lateinit var viewModel: DepartmentViewModel

    private val factory1: EmpViewModelFactory by instance()
    lateinit var viewModel1: EmpViewModel
    var empList: MutableList<EmployeeItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, factory).get(DepartmentViewModel::class.java)
        viewModel1 = ViewModelProvider(this, factory1).get(EmpViewModel::class.java)

        val adapter = DepartmentItemAdapter(this,listOf(), viewModel,viewModel1,kodein = kodein)

        rvItems.layoutManager = LinearLayoutManager(this)
        rvItems.adapter = adapter

        viewModel.getAllDepartmentItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })


        //String array.
        val myStrings = ArrayList<String>()//Creating an empty arraylist
        myStrings.add("Select Department")
        myStrings.add("android")
        myStrings.add("ios")
        myStrings.add("web")


        //Adapter for spinner
        var spinnerAdapter = CustomDropDownAdapter(this, myStrings)
        itemSpinner?.adapter = spinnerAdapter

        itemSpinner?.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {

                Toast.makeText(this@MainActivity, myStrings[position], LENGTH_LONG).show()
                //rvItems.apply {
                if(!myStrings[position].contains("Select Department")) {
                    viewModel.insert(DepartmentItem(myStrings[position],empList))
                    myStrings.remove(myStrings[position])
                    itemSpinner?.adapter = spinnerAdapter
                }
            }
        })

    }
}


