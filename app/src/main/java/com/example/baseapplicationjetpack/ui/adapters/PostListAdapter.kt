package com.example.baseapplicationjetpack.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baseapplicationjetpack.R
import com.example.baseapplicationjetpack.data.entities.PostEntity
import kotlinx.android.synthetic.main.item_list.view.*
import java.util.*

class PostListAdapter : RecyclerView.Adapter<PostListAdapter.PostViewHolder>() {
    private var data: List<PostEntity> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list, parent, false)
        )
    }

    override fun getItemCount() = data.size
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) = holder.bind(data[position])
    fun swapData(data: List<PostEntity>) {
        this.data = data
        notifyDataSetChanged()
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: PostEntity) {
            itemView.text_post.text = item.title
        }
    }
}