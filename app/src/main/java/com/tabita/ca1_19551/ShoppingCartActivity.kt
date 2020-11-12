package com.tabita.ca1_19551

import android.icu.text.NumberFormat
import android.icu.util.Currency
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.tabita.ca1_19551.adapters.ShoppingCartAdapter
import com.tabita.ca1_19551.screens.ShoppingCart

class ShoppingCartActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)

        var listView = findViewById<ListView>(R.id.tea_list_view)
        val adapter = ShoppingCartAdapter(this,  ShoppingCart.getCart())
        listView.adapter = adapter

        var totalPrice = ShoppingCart.getCart()
            .fold(0.toDouble()) { acc, cartItem -> acc + cartItem.quantity.times(cartItem.product.price!!.toDouble()) }

        var summary = findViewById<TextView>(R.id.summary)

        val format = NumberFormat.getCurrencyInstance()
        format.currency = Currency.getInstance("EUR")

        summary.text = "Total: ${format.format(totalPrice)}"
    }
}