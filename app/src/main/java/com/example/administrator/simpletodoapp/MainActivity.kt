package com.example.administrator.simpletodoapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    var items:ArrayList<String>
    var itemsAdapter:ArrayAdapter<String>
    var lvItems:ListView
    init {
        items = ArrayList<String>()
        itemsAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1)
        lvItems = findViewById<ListView>(R.id.lvItems)
        //lvItems = ListView()

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lvItems = findViewById(R.id.lvItems)
        items = ArrayList<String>()
        itemsAdapter = ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items)
        lvItems.setAdapter(itemsAdapter)
        items.add("First Item")
        items.add("Second Item")
    }

    fun onAddItem(v: View) {
        val etNewItem = findViewById<EditText>(R.id.etNewItem)
        val itemText = etNewItem.getText().toString()
        itemsAdapter.add(itemText)
        etNewItem.setText("")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
