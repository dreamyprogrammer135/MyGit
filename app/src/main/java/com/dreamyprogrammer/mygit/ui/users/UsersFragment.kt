package com.dreamyprogrammer.mygit.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dreamyprogrammer.mygit.App
import com.dreamyprogrammer.mygit.databinding.FragmentUsersBinding
import com.dreamyprogrammer.mygit.domain.GithubUserRepo
import com.dreamyprogrammer.mygit.ui.base.BackButtonListener
import com.dreamyprogrammer.mygit.ui.users.adapter.UserAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {

    private val presenter by moxyPresenter { UsersPresenter(App.instance.router, GithubUserRepo()) }
    private val adapter by lazy {
        UserAdapter(presenter.usersListPresenter)
    }

    private var _biding: FragmentUsersBinding? = null
    private val binding
        get() = _biding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _biding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.usersRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.usersRecycler.adapter = adapter

    }

    override fun updateList() {
        adapter.notifyDataSetChanged()
    }
}