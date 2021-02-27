package com.example.codetest

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codetest.model.DetailInfo
import com.example.codetest.utils.ListItemAdapter
import com.example.codetest.utils.Utils
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ListItemAdapter.OnItemClickListener {

    private var adapter: ListItemAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ListItemAdapter(Utils.readFromJson())

        adapter?.setOnItemClickListener(this)
        val layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        itemRV?.layoutManager = layoutManager
        itemRV.adapter = this.adapter

    }

    override fun onResume() {
        super.onResume()
        adapter?.notifyDataSetChanged()
    }

    override fun onItemClick(view: View, value: DetailInfo, position: Int) {
        val intent = Intent(this, InfoActivity::class.java)
        intent.putExtra("id", value.id)
        startActivity(intent)
    }
}