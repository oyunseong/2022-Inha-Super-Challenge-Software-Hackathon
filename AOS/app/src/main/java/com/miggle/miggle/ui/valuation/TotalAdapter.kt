package com.miggle.miggle.ui.valuation

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.miggle.miggle.R
import com.miggle.miggle.model.total

class TotalAdapter (private val context: Context) : RecyclerView.Adapter<TotalAdapter.ViewHolder>() {

    private var list = mutableListOf<total>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_total_recycler,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
        Log.e("--onBindViewHolder",list[position].toString())
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = itemView.findViewById(R.id.post_title)
        private val txtAge: TextView = itemView.findViewById(R.id.post_content)
//        private val imgProfile: ImageView = itemView.findViewById(R.id.img_rv_photo)

        fun bind(item: total) {
            title.text = item.title
            txtAge.text = item.text1
//            Glide.with(itemView).load(item.img).into(imgProfile)
        }
    }
    fun addItem(){
        list.add(total(title = "삼성전자", text1 = "PER: 31  PBR: 2.7  PSR: 2.7"))
        list.add(total(title = "LG전자", text1 = "PER: 25.53  PBR: 2.02  PSR: 2.9"))
        list.add(total(title = "대한항공", text1 = "PER: 35  PBR: 35  PSR: 35"))
        list.add(total(title = "DB 하이텍", text1 = "PER: 14  PBR: 2.9  PSR: 2.4"))
        list.add(total(title = "솔브레인", text1 = "PER: 0.3  PBR: 0.7  PSR: 2.6"))
        list.add(total(title = "티웨이항공", text1 = "PER: 35  PBR: 35  PSR: 35"))
        list.add(total(title = "SK하이닉스", text1 = "PER: 15  PBR: 1.3  PSR: 2.8"))
        list.add(total(title = "동진쎄미캠", text1 = "PER: 12  PBR: 4  PSR: 3"))
        list.add(total(title = "신풍제약", text1 = "PER: 24.84  PBR: 26.56  PSR: 19.02"))
        list.add(total(title = "대웅제약", text1 = "PER: 221.26  PBR: 47.11  PSR: 41.9"))
        list.add(total(title = "후성", text1 = "PER: 22.35  PBR: 131.91  PSR: 117.35"))
        list.add(total(title = "티웨이항공", text1 = "PER: 35  PBR: 35  PSR: 35"))
        list.add(total(title = "삼성전자", text1 = "PER: 31  PBR: 2.7  PSR: 2.7"))
        list.add(total(title = "LG전자", text1 = "PER: 25.53  PBR: 2.02  PSR: 2.9"))
        list.add(total(title = "대한항공", text1 = "PER: 35  PBR: 35  PSR: 35"))
        list.add(total(title = "DB 하이텍", text1 = "PER: 14  PBR: 2.9  PSR: 2.4"))
        list.add(total(title = "솔브레인", text1 = "PER: 0.3  PBR: 0.7  PSR: 2.6"))
        list.add(total(title = "티웨이항공", text1 = "PER: 35  PBR: 35  PSR: 35"))
        list.add(total(title = "SK하이닉스", text1 = "PER: 15  PBR: 1.3  PSR: 2.8"))
        list.add(total(title = "동진쎄미캠", text1 = "PER: 12  PBR: 4  PSR: 3"))
        list.add(total(title = "신풍제약", text1 = "PER: 24.84  PBR: 26.56  PSR: 19.02"))
        list.add(total(title = "대웅제약", text1 = "PER: 221.26  PBR: 47.11  PSR: 41.9"))
        list.add(total(title = "후성", text1 = "PER: 22.35  PBR: 131.91  PSR: 117.35"))
        list.add(total(title = "티웨이항공", text1 = "PER: 35  PBR: 35  PSR: 35"))
        list.add(total(title = "삼성전자", text1 = "PER: 31  PBR: 2.7  PSR: 2.7"))
        list.add(total(title = "LG전자", text1 = "PER: 25.53  PBR: 2.02  PSR: 2.9"))
        list.add(total(title = "대한항공", text1 = "PER: 35  PBR: 35  PSR: 35"))
        list.add(total(title = "DB 하이텍", text1 = "PER: 14  PBR: 2.9  PSR: 2.4"))
        list.add(total(title = "솔브레인", text1 = "PER: 0.3  PBR: 0.7  PSR: 2.6"))
        list.add(total(title = "티웨이항공", text1 = "PER: 35  PBR: 35  PSR: 35"))
        list.add(total(title = "SK하이닉스", text1 = "PER: 15  PBR: 1.3  PSR: 2.8"))
        list.add(total(title = "동진쎄미캠", text1 = "PER: 12  PBR: 4  PSR: 3"))
        list.add(total(title = "신풍제약", text1 = "PER: 24.84  PBR: 26.56  PSR: 19.02"))
        list.add(total(title = "대웅제약", text1 = "PER: 221.26  PBR: 47.11  PSR: 41.9"))
        list.add(total(title = "후성", text1 = "PER: 22.35  PBR: 131.91  PSR: 117.35"))
        list.add(total(title = "티웨이항공", text1 = "PER: 35  PBR: 35  PSR: 35"))

        notifyDataSetChanged()
    }


}