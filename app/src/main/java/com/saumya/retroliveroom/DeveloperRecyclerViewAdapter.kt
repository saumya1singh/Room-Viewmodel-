package com.saumya.retroliveroom

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.saumya.retroliveroom.Model.DeveloperModel


class DeveloperRecyclerViewAdapter(_context : Context, _developerList:List<DeveloperModel>) :
RecyclerView.Adapter<DeveloperRecyclerViewAdapter.DeveloperViewHolder>() {

    val context = _context
    val developerList = _developerList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeveloperViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.each_row,parent,false)
        return DeveloperViewHolder(view)
    }

    override fun getItemCount(): Int {
        return developerList.size
    }

    override fun onBindViewHolder(holder: DeveloperViewHolder, position: Int) {
        val developer = developerList[position]
        holder.Name.text = developer.username
        holder.github.text = developer.url
        Picasso.get().load(developer.avatar).into(holder.Image)
    }


    class DeveloperViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val Name : TextView = itemView.findViewById(R.id.name)
        val github : TextView = itemView.findViewById(R.id.github)
       
        val Image : ImageView = itemView.findViewById(R.id.image)
    }

}