package com.korneliuszbarwinski.users.presentation.userlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.korneliuszbarwinski.users.R
import com.korneliuszbarwinski.users.databinding.FragmentUserListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserListFragment : Fragment(R.layout.fragment_user_list) {

    private val viewModel: UserListViewModel by viewModels()
    private val userListAdapter = UserListAdapter()

    private var _binding: FragmentUserListBinding? = null
    private val binding: FragmentUserListBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentUserListBinding.bind(view)

        userListAdapter.setOnItemClickListener {
            findNavController().navigate(UserListFragmentDirections.actionUserListFragmentToUserDetailsActivity(it))
        }

        binding.apply {
            userListRV.adapter = userListAdapter
        }

        viewModel.users.observe(viewLifecycleOwner){
            userListAdapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}