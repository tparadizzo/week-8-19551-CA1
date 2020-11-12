package com.tabita.ca1_19551.adapters

import android.content.Context
import android.icu.text.NumberFormat
import android.icu.util.Currency
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.tabita.ca1_19551.R
import com.tabita.ca1_19551.models.TeaViewModel
import com.tabita.ca1_19551.screens.CartItem
import com.tabita.ca1_19551.screens.ShoppingCart


class ShoppingCartAdapter(private val context: Context, var cartItems: List<CartItem>) : BaseAdapter() {

    private lateinit var name: TextView
    private lateinit var price: TextView
    private lateinit var quantity: TextView
    private lateinit var removeButton: Button

    @RequiresApi(Build.VERSION_CODES.N)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView

        var cartItem = cartItems[position]

        convertView = LayoutInflater.from(context).inflate(R.layout.cart_item, parent, false)
        name = convertView.findViewById(R.id.name)
        quantity = convertView.findViewById(R.id.quantity)
        price = convertView.findViewById(R.id.price)
        removeButton = convertView.findViewById(R.id.removeButton)

        name.text = cartItem.product.name
        quantity.text = cartItem.quantity.toString()

        var totalPrice = cartItem.quantity * cartItem.product.price;

        val format = NumberFormat.getCurrencyInstance()
        format.currency = Currency.getInstance("EUR")
        price.text = format.format(totalPrice)

        return convertView
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return cartItems.size
    }

}