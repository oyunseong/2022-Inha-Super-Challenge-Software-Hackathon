package com.miggle.miggle.ui.community.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.miggle.miggle.databinding.ItemPostRecyclerBinding
import com.miggle.miggle.model.Post
import com.miggle.miggle.ui.community.CommunityAdapter

class SearchHolder(
    var itemPostRecyclerBinding: ItemPostRecyclerBinding,
    private val itemClickListener: CommunityAdapter.OnItemClickListener?
) : CommunityHolder(
    itemPostRecyclerBinding.root
) {
    fun onBind(post: Post) {
        itemPostRecyclerBinding.root.setOnClickListener { v: View? ->
            val pos = adapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                itemClickListener?.onItemClick(v, pos)
            }
        }
        itemPostRecyclerBinding.itemPostTitle.text = post.title
//        itemPostRecyclerBinding.itemPostContent.text = post.content
//        itemPostRecyclerBinding.itemPostNickname.text = post.writerNickname
//        itemPostRecyclerBinding.itemPostTime.text = post.createAt
    }
}