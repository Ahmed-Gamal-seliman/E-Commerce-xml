package com.example.e_commerce.home.ui.banner.adapter


import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.e_commerce.databinding.BannerItemBinding
import com.example.e_commerce.home.ui.banner.model.Banner


class BannerAdapter(
    private val bannerList: List<Banner>,
):RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {

    private lateinit var binding:BannerItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        binding = BannerItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
//        binding.btnShopNow.bringToFront()
        return BannerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bindingViewHolder.tvTitle.text = bannerList[position].title
        holder.bindingViewHolder.tvSubtitle.text = bannerList[position].subtitle
        holder.bindingViewHolder.ivBanner.setImageResource(bannerList[position].image)
//        holder.bindingViewHolder.btnShopNow.backgroundTintList =
//            ContextCompat.getColorStateList(holder.itemView.context, bannerList[position].buttonBackground);

//        holder.bindingViewHolder.btnShopNow.setTextColor(Color.parseColor(convertColortoString(holder, position,bannerList[position].textButtonColor)))

        holder.bindingViewHolder.tvTitle.setTextColor(Color.parseColor(convertColortoString(holder, position,bannerList[position].titleColor)))
        holder.bindingViewHolder.tvSubtitle.setTextColor(Color.parseColor(convertColortoString(holder, position,bannerList[position].subtitleColor)))
    }

    private fun convertColortoString(
        holder: BannerViewHolder,
        position: Int,
        color:Int
    ): String {
        val colorAsString = String.format(
            "#%06X",
            (0xFFFFFF and ContextCompat.getColor(
                holder.itemView.context,
                color
            ))
        )
        return colorAsString
    }

    override fun getItemCount()= bannerList.size

    class BannerViewHolder(val bindingViewHolder:BannerItemBinding):ViewHolder(bindingViewHolder.root)


}