package com.example.wishlistproject

class WishListFetcher {
companion object{


   var names: String? = ""
    var prices : String? = ""
    var urls : String? = ""
    fun getWishLists(): MutableList<WishList> {
        var wishlists : MutableList<WishList> = ArrayList()
            val wishlist = WishList(names.toString(), prices.toString(), urls.toString())
            wishlists.add(wishlist)

        return wishlists
    }

    fun blankList():MutableList<WishList>{
        var wishlists : MutableList<WishList> = ArrayList()
        return wishlists
    }

    }
}