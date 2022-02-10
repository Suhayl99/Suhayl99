package uz.itech.myapplication.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.itech.myapplication.databinding.PostItemLayoutBinding
import uz.itech.myapplication.model.PostModel

class PostAdapter(val items:List<PostModel>) : RecyclerView.Adapter<PostAdapter.ItemHolder>(){
    inner class ItemHolder(val binding: PostItemLayoutBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(PostItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
       var item=items[position]
        holder.binding.tvBody.text=item.body
        holder.binding.tvTitle.text=item.title
    }

    override fun getItemCount(): Int {
        return items.count()
    }
}