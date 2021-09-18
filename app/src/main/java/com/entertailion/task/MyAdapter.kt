package com.entertailion.task

import android.content.Context
import android.net.Uri
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import java.io.File


/**
 * created By mohammadmuddasir
 * Muddasir107@gmail.com
 */
class MyAdapter(private val mList: List<DataClassItems>):
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    var context:Context?=null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
      //  holder.imageView.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
      holder.id.text = ItemsViewModel.id.toString()

        holder.slug.text = ItemsViewModel.slug.toString()
        holder.type.text = ItemsViewModel.type.toString()
        Log.e("imageUrl",ItemsViewModel.publi.toString())

       // holder.image.setImageURI(Uri.parse(ItemsViewModel.publi.toString()))
       // holder.image.setImageURI(Uri.parse(ItemsViewModel.publi.toString()))
      Glide.with(context!!).load(Uri.parse(ItemsViewModel.publi.toString()))

            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(holder.image)

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val id: TextView = itemView.findViewById(R.id.id)
        val slug: TextView = itemView.findViewById(R.id.slug)
        val type: TextView = itemView.findViewById(R.id.type)
        val image :ImageView =itemView.findViewById(R.id.image)

    }
}

