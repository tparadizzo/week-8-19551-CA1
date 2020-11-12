package com.tabita.ca1_19551

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import androidx.appcompat.widget.Toolbar
import com.tabita.ca1_19551.adapters.TeaListAdapter
import com.tabita.ca1_19551.models.TeaViewModel
import io.paperdb.Paper

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Paper.init(this);

        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar)

        var listView = findViewById<ListView>(R.id.tea_list_view)
        val teaList: Array<TeaViewModel> = arrayOf(
            TeaViewModel("Darjelling", 8.50, 100),
            TeaViewModel("Assam", 7.50, 100),
            TeaViewModel("Lapsang", 9.50, 100),
            TeaViewModel("Earl Grey", 3.50, 100),
            TeaViewModel("Irish Breakfast", 2.50, 100)
        )
        val adapter = TeaListAdapter(this, teaList)
        listView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true;
    }

    fun goToShoppingCart(menuItem: MenuItem){
        val intent = Intent(this, ShoppingCartActivity::class.java)
        startActivity(intent)
    }
}