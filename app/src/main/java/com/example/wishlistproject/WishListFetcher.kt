package com.example.wishlistproject

class WishListFetcher {
companion object{


   var names =""
    var prices = ""
    var urls = ""
    fun getWishLists(): MutableList<WishList> {
        var wishlists : MutableList<WishList> = ArrayList()
            val wishlist = WishList(names, prices, urls)
            wishlists.add(wishlist)

        return wishlists
    }

    }
}