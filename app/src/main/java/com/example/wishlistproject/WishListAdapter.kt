package com.example.wishlistproject

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class WishListAdapter (private val wishList: MutableList<WishList>): RecyclerView.Adapter<WishListAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // TODO: Create member variables for any view that will be set
        // as you render a row.
            val nameView:TextView
            val priceView:TextView
            val urlView: TextView

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {

            // the public final member variables created above

            nameView= itemView.findViewById(R.id.nametv)
            priceView= itemView.findViewById(R.id.pricetv)
            urlView = itemView.findViewById(R.id.urltv)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.wish_list_item,parent,false)
        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {

        return wishList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val wishlist = wishList.get(position)

        holder.nameView.text= wishlist.name
        holder.priceView.text=wishlist.price
        holder.urlView.text=wishlist.url

        holder.itemView.setOnClickListener(View.OnClickListener {
            try {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(wishList[position].url))
                ContextCompat.startActivity(it.context, browserIntent, null)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(it.context, "Invalid URL for " + wishList[position].name, Toast.LENGTH_LONG).show()
            }
        }


        )

        holder.itemView.setOnLongClickListener{
            wishList.removeAt(position)
            notifyItemRemoved(position)
            Toast.makeText(it.context, "Item Removed ", Toast.LENGTH_LONG).show()
            true
        }



    }




}