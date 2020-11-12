package com.tabita.ca1_19551.screens

import android.util.Log
import io.paperdb.Paper

class ShoppingCart {
    companion object {

        fun addItem(cartItem: CartItem) {
            val cart = getCart()

            val targetItem = cart.singleOrNull { it.product.name == cartItem.product.name }

            if (targetItem == null) {
                cartItem.quantity++
                cart.add(cartItem)
                Log.i("ShoppingCart", "Cart is empty, adding product in the cart.")
            } else {

                targetItem.quantity++
                Log.i("ShoppingCart", "Adding one more item in the cart.")
            }

            saveCart(cart)

        }

        fun saveCart(cart: MutableList<CartItem>) {
            Paper.book().write("cart", cart)
        }

        fun getCart(): MutableList<CartItem> {
            return Paper.book().read("cart", mutableListOf())
        }
    }
}