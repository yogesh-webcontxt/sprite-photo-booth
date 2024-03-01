package com.sprite.spritephotobooth.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.sprite.spritephotobooth.Base.BaseActivity
import com.sprite.spritephotobooth.data.model.SpriteFeature
import com.sprite.spritephotobooth.databinding.ActivityMainBinding
import com.sprite.spritephotobooth.ui.SpriteFeaturesAdapter

class SelectSceneActivity : BaseActivity() {
    private var binding: ActivityMainBinding? = null
    private val mSpriteFeaturesAdapter by lazy{
        SpriteFeaturesAdapter(ArrayList())
    }
    companion object{
        const val TAG = "MainActivityTAG"
    }
    private val myLinearLayoutManager = object : LinearLayoutManager(this) {
        override fun canScrollVertically(): Boolean {
            return false
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding?.apply {
            setContentView(this.root)
            lifecycleOwner = this@SelectSceneActivity
            executePendingBindings()
        }
        init()
    }

    override fun initArguments() {

    }

    override fun initViews() {
        // Calling the override functions from
        // the Linear Layout Manager inner class

        binding?.spriteFeatureRc?.apply {
            layoutManager = myLinearLayoutManager
            adapter =  mSpriteFeaturesAdapter
        }
        mSpriteFeaturesAdapter.updateData(getFeatureList())
    }

    override fun setupListener() {
    }

    override fun loadData() {
    }

    private fun getFeatureList(): List<SpriteFeature> {
        // Create a list of SpriteFeature objects
        return listOf(
            SpriteFeature(id = 1, featureName = "Feature 1"),
            SpriteFeature(id = 2, featureName = "Feature 2"),
            SpriteFeature(id = 4, featureName = "Feature 3"),
            SpriteFeature(id = 5, featureName = "Feature 3"),
            SpriteFeature(id = 6, featureName = "Feature 3"),
        )
    }
}