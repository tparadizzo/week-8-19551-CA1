package com.tabita.ca1_19551.models

import android.util.Log
import androidx.lifecycle.ViewModel

class TeaViewModel(name: String, price: Double, bagSize: Int) : ViewModel() {
    var name = name
    var price = price
    var bagSize = bagSize
}