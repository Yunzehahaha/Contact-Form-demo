package com.example.codetest.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codetest.App
import com.example.codetest.R
import com.example.codetest.model.DetailInfo
import com.example.codetest.viewModel.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*

class FirstActivity : AppCompatActivity(), ListItemAdapter.OnItemClickListener {
    private var adapter: ListItemAdapter? = null
    private val vm: MyViewModel by viewModels {
        MyViewModel.myViewModelFactory((application as App).repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        adapter = ListItemAdapter()

        adapter?.setOnItemClickListener(this)
        val layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        itemRV?.layoutManager = layoutManager
        itemRV.adapter = this.adapter

        vm.allData.observe(this) {
            this.adapter?.updateList(it)
        }
    }

    override fun onItemClick(view: View, value: DetailInfo, position: Int) {
        val intent = Intent(this, InfoActivity::class.java)
        intent.putExtra("id", value.id)
        intent.putExtra("firstName", value.firstName)
        intent.putExtra("lastName", value.lastName)
        intent.putExtra("email", value.email)
        intent.putExtra("phone", value.phone)
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 1) {
            val id = data?.getStringExtra("id") ?: ""
            val firstName = data?.getStringExtra("firstName") ?: ""
            val lastName = data?.getStringExtra("lastName") ?: ""
            val email = data?.getStringExtra("email") ?: ""
            val phone = data?.getStringExtra("phone") ?: ""

            vm.updateData(
                DetailInfo(
                    id = id,
                    firstName = firstName,
                    lastName = lastName,
                    email = email,
                    phone = phone
                )
            )
        }
    }
}