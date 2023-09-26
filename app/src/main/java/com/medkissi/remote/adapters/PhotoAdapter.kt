package com.medkissi.remote.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.medkissi.remote.R
import com.medkissi.remote.data.model.Photo
import com.medkissi.remote.data.model.Post


class PhotoAdapter: ListAdapter<Photo, PhotoAdapter.PhotoViewHolder>(PhotoDiffUtil()) {

    class PhotoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView.rootView){
        val title  = itemView.findViewById<TextView>(R.id.title1)
        val image  = itemView.findViewById<ImageView>(R.id.photo)

        fun bind(photo: Photo){
            title.text = photo.title
            Glide.with(itemView)
                .load(photo.url)
                .centerCrop()
                .into(image)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list2,parent,false)
        return  PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo= getItem(position)
        holder.bind(photo)
    }
}

class PhotoDiffUtil(): DiffUtil.ItemCallback<Photo>(){
    override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return  oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return  oldItem == newItem
    }

}