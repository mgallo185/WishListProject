package com.example.wishlistproject

class WishListFetcher {
companion object{

   /* val names= listOf<String>()
    val prices = listOf<String>()
    val urls= listOf<String>()

    fun getWishLists(): MutableList<WishList>{

    var wishLists : MutableList<WishList> = ArrayList()

        val wishlist= WishList(names.last(), prices.last(), urls.last() )

        wishLists.add(wishlist)
        return wishLists

    }*/
   var names ="tes"
    var prices = "test"
    var urls = "new"
    fun getWishLists(): MutableList<WishList> {
        var wishlists : MutableList<WishList> = ArrayList()
            val wishlist = WishList(names, prices, urls)
            wishlists.add(wishlist)

        return wishlists
    }

    }
}