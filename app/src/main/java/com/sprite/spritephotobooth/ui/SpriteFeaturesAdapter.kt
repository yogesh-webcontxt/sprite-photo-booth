package com.sprite.spritephotobooth.ui


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sprite.spritephotobooth.data.model.SpriteFeature
import com.sprite.spritephotobooth.databinding.ItemSpriteFeatureBinding

class SpriteFeaturesAdapter (private var spriteFeatureList: List<SpriteFeature>? = null  ): RecyclerView.Adapter<SpriteFeaturesAdapter.SpriteFeaturesVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpriteFeaturesAdapter.SpriteFeaturesVH {
        val binding = ItemSpriteFeatureBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SpriteFeaturesVH(binding)
    }
    @SuppressLint("NotifyDataSetChanged")
    fun updateData(spriteFeatureList: List<SpriteFeature>? ){
        this.spriteFeatureList = spriteFeatureList
        notifyDataSetChanged()
    }

    companion object : DiffUtil.ItemCallback<SpriteFeature>() {
        override fun areItemsTheSame(oldItem: SpriteFeature, newItem: SpriteFeature): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: SpriteFeature, newItem: SpriteFeature): Boolean {
            return oldItem.id == newItem.id && oldItem.featureName == newItem.featureName
        }
    }


    override fun getItemCount(): Int {
        return spriteFeatureList?.size ?: 0
    }

    override fun onBindViewHolder(holder: SpriteFeaturesAdapter.SpriteFeaturesVH, position: Int) {
        holder.loadData(spriteFeatureList?.get(position))
    }
    inner  class SpriteFeaturesVH(private val binding : ItemSpriteFeatureBinding): RecyclerView.ViewHolder(binding.root){
        fun loadData(spriteFeature : SpriteFeature?){
            binding.featureIdTxt.text = spriteFeature?.id.toString()
            binding.featureNameTxt.text = spriteFeature?.featureName
            binding.featureNameTxt.setOnClickListener {
            }
            // Determine if the current item is the last item
            val isLastItem = position == itemCount - 1

            // Set visibility of the divider based on whether it's the last item or not
            binding.divider.visibility = if (isLastItem) View.GONE else View.VISIBLE


        }
    }
}