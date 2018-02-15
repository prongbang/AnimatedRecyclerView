package com.prongbang.animatedrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = GroupAdapter(this)
        adapter.setOnClickListener(object : GroupAdapter.OnClickListener {
            override fun onClick(v: View, group: String) {
                Log.i(MainActivity::class.java.simpleName, group)
            }
        })
        rvGroupName.layoutManager = GridLayoutManager(this, 4)
        rvGroupName.adapter = adapter

        // group data
        val groups = ArrayList<String>()
        groups.add("A")
        groups.add("B")
        groups.add("C")
        groups.add("D")
        groups.add("E")
        groups.add("F")
        groups.add("G")
        groups.add("H")
        groups.add("I")
        groups.add("J")
        groups.add("K")
        groups.add("L")
        groups.add("M")
        groups.add("N")
        groups.add("O")
        groups.add("P")
        groups.add("Q")
        groups.add("R")
        groups.add("S")
        groups.add("T")
        groups.add("U")
        groups.add("V")
        groups.add("W")
        groups.add("X")
        groups.add("Y")
        groups.add("Z")
        adapter.setData(groups)

    }
}
