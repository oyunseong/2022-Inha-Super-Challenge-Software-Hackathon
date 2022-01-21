package com.miggle.miggle.ui.community

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miggle.miggle.databinding.ItemCommentRecyclerBinding
import com.miggle.miggle.model.Comment

class CommentAdapter : RecyclerView.Adapter<CommentAdapter.ViewHolder>() {
    private lateinit var commentList: ArrayList<Comment>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentAdapter.ViewHolder {
        return ViewHolder(
            ItemCommentRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: CommentAdapter.ViewHolder, position: Int) {
        val comment = commentList[position]
        //TODO 출력 요소 추가필요
        holder.binding.commentNickname.text = comment.writer
    }

    override fun getItemCount(): Int {
        return commentList.size
    }
    class ViewHolder(val binding: ItemCommentRecyclerBinding):
            RecyclerView.ViewHolder(
                binding.root
            )
}