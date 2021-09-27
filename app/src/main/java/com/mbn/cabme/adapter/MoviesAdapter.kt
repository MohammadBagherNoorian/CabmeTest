package com.mbn.cabme.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mbn.cabme.R
import com.mbn.cabme.model.Movie


class MoviesAdapter(
    private val itemslist: List<Movie>,private val context: Context) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.movieDate.text=itemslist[position].releaseState
        holder.movieGeners.text=itemslist[position].genres
        holder.movieTitle.text=itemslist[position].title
        Glide.with(context).load(itemslist[position].image).into(holder.movieImage);
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(v)
    }


    override fun getItemCount(): Int {
        return itemslist.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieDate: AppCompatTextView = itemView.findViewById(R.id.item_release)
        val movieGeners:AppCompatTextView = itemView.findViewById(R.id.item_geners)
        val movieTitle:AppCompatTextView = itemView.findViewById(R.id.item_title)
        val movieImage:AppCompatImageView = itemView.findViewById(R.id.item_image)


    }


}