package com.altaf.fbiwanted

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.altaf.fbiwanted.databinding.ItemWantedBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.squareup.picasso.Picasso

class WantedAdapter : RecyclerView.Adapter<WantedAdapter.MyViewHolder>() {
    private var listWanted = ArrayList<ItemsItem>()

    fun setData(data: List<ItemsItem>?){
        if(data == null) return
        listWanted.clear()
        listWanted.addAll(data)
    }

//    private var onItemClickCallback: OnItemClickCallback? = null
//
//    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
//        this.onItemClickCallback = onItemClickCallback
//    }

    class MyViewHolder(val binding: ItemWantedBinding):
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        ItemWantedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = listWanted[position]
        holder.binding.apply {
            tvItemTitle.text = data.title
            //tvItemRewards.text = data.rewardText
            // data gambar ada di dalam data class ItemsItem > Images > data clas ImagesItem > original
            val urlImages = data.images?.get(0)?.original
            Glide.with(ivItemWanted.context)
                .load(urlImages)
                .apply(RequestOptions())
                    // jk tidak tampil maka akan menampilkan default image
                .placeholder(R.drawable.ic_image)
                .override(500, 500)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
                .into(ivItemWanted)
        }
    }

    override fun getItemCount() = listWanted.size
}

//class MyViewHolder (val binding: ItemWantedBinding): RecyclerView.ViewHolder(binding.root)
//
//override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= MyViewHolder (
//
//    ItemWantedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//)
//
//override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//    holder.binding.apply {
//        tvItemTitle.text = listWanted[position]
//        tvItemRewards.text = listWanted[position]
//        Picasso.get().load(listWanted[position]).into(ivItemWanted)
//    }
//}
//override fun getItemCount() = listWanted.size