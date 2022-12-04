package com.korneliuszbarwinski.users.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.korneliuszbarwinski.users.R
import com.korneliuszbarwinski.users.databinding.ActivityMainBinding
import com.korneliuszbarwinski.users.databinding.ActivityUserDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserDetailsBinding
    private val args: UserDetailsActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Details"

        val user = args.user
        binding.apply {
            nameTV.text = user.name
            sourceTV.text = user.source

            Glide.with(this.root)
                .load(user.photoUrl)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .error(R.drawable.ic_image_error)
                .into(photoIV)
        }
    }
}