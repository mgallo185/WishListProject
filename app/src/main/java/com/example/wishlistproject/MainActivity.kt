package com.example.wishlistproject

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var wishlists: List<WishList>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fun hideKeyboard() {
            val view = this.currentFocus
            if (view != null){
                val hide = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                hide.hideSoftInputFromWindow(view.windowToken,0)
            }
            else{
                window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
            }
        }

        val button= findViewById<Button>(R.id.button)

        val wishlistRv = findViewById<RecyclerView>(R.id.wish_list)
        wishlists= WishListFetcher.blankList()
        var adapter = WishListAdapter(wishlists as MutableList<WishList>)
        // Attach the adapter to the RecyclerView to populate items
        wishlistRv.adapter = adapter
        // Set layout manager to position the items
        wishlistRv.layoutManager = LinearLayoutManager(this)

        button.setOnClickListener {
            var enterName= findViewById<EditText>(R.id.inputName)
            var enterPrice = findViewById<EditText>(R.id.inputPrice)
            var enterURL = findViewById<EditText>(R.id.inputURL)


            WishListFetcher.names=enterName.text.toString()
            WishListFetcher.prices=enterPrice.text.toString()
            WishListFetcher.urls=enterURL.text.toString()


            var newItem= WishListFetcher.getWishLists()

            (wishlists as MutableList<WishList>).addAll(newItem)

            adapter.notifyDataSetChanged()




            hideKeyboard()
            enterName.getText().clear()
            enterPrice.getText().clear()
            enterURL.getText().clear()
        }



    }


}




