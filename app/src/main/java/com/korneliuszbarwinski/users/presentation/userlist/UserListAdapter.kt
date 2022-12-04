package com.korneliuszbarwinski.users.presentation.userlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.korneliuszbarwinski.users.R
import com.korneliuszbarwinski.users.databinding.ListItemUserBinding
import com.korneliuszbarwinski.users.domain.model.User

class UserListAdapter : ListAdapter<User, UserListAdapter.UserListHolder>(UserDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListHolder {
        val binding = ListItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserListHolder(binding)
    }

    inner class UserListHolder(private val binding: ListItemUserBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindData(user: User){
            binding.apply {
                nameTV.text = user.name
                sourceTV.text = user.source

                Glide.with(this.root)
                    .load(user.photoUrl)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_image_error)
                    .into(photoIV)

                root.setOnClickListener {
                    onItemClickListener?.let { it(user) }
                }
            }
        }
    }

    override fun onBindViewHolder(holder: UserListHolder, position: Int) {
        val user = getItem(position)
        holder.bindData(user)
    }

    private var onItemClickListener: ((User) -> Unit)? = null

    fun setOnItemClickListener(listener: (User) -> Unit) {
        onItemClickListener = listener
    }

}

class UserDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}