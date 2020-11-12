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


class TeaListAdapter(private val context: Context, private val arrayList: Array<TeaViewModel>) : BaseAdapter() {

    private lateinit var name: TextView
    private lateinit var price: TextView
    private lateinit var bagSize: TextView
    private lateinit var cartButton: Button

    @RequiresApi(Build.VERSION_CODES.N)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView

        var product = arrayList[position]

        convertView = LayoutInflater.from(context).inflate(R.layout.tea_list_item, parent, false)
        price = convertView.findViewById(R.id.price)
        name = convertView.findViewById(R.id.name)
        bagSize = convertView.findViewById(R.id.bagSize)
        cartButton = convertView.findViewById(R.id.cartButton)

        name.text = arrayList[position].name

        val format = NumberFormat.getCurrencyInstance()
        format.currency = Currency.getInstance("EUR")
        price.text = format.format(arrayList[position].price)

        bagSize.text = "per " + arrayList[position].bagSize.toString() + " g"

        cartButton.setOnClickListener {
            Log.i("TeaListAdapter", "Adding tea $name in the cart")

            val item = CartItem(product)

            ShoppingCart.addItem(item)
        }

        return convertView
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return arrayList.size
    }

}