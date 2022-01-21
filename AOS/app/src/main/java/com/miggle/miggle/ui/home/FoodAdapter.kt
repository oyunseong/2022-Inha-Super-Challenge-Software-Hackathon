package com.miggle.miggle.ui.home

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miggle.miggle.R
import com.miggle.miggle.model.Category

class FoodAdapter(private val context: Context) :
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    var datas = mutableListOf<Category>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_detail_category, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("++onBindViewHolder","onBindViewHolder 호출")

        holder.bind(datas[position], context)
        holder.itemView.setOnClickListener {

            it?.findNavController()?.navigate(R.id.postFragment)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = itemView.findViewById(R.id.title)
        private val image: ImageView = itemView.findViewById(R.id.image)

        // TODO 서버에서 받아온 데이터 뿌려주기
        fun bind(item: Category, context:Context) {
            Log.d("++onBind","onBind 호출")
            title.text = item.title
            Glide.with(itemView).load(item.img).into(image)
        }
    }

}