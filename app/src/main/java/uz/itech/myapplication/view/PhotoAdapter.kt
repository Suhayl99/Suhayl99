package uz.itech.myapplication.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uz.itech.myapplication.databinding.PhotoItemLayoutBinding
import uz.itech.myapplication.model.PhotoModel

class PhotoAdapter(val items: List<PhotoModel>):RecyclerView.Adapter<PhotoAdapter.ItemHolder>() {

    inner class ItemHolder(val binding: PhotoItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(PhotoItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var item=items[position]
       Picasso.get().load(item.url).into(holder.binding.imageView)
    }

    override fun getItemCount(): Int =items.count()
}