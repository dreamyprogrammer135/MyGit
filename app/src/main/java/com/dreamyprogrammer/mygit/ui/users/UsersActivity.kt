package com.dreamyprogrammer.mygit.ui.users

import moxy.MvpAppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dreamyprogrammer.mygit.databinding.ActivityUsersBinding
import com.dreamyprogrammer.mygit.domain.GithubUserRepo
import com.dreamyprogrammer.mygit.ui.users.adapter.UserAdapter
import com.dreamyprogrammer.mygit.ui.users.adapter.UsersPresenter
import moxy.ktx.moxyPresenter

class UsersActivity : MvpAppCompatActivity(), UsersView {

    private val presenter by moxyPresenter { UsersPresenter(GithubUserRepo()) }
    private val adapter by lazy {
        UserAdapter(presenter.usersListPresenter)
    }

    private var _biding: ActivityUsersBinding? = null
    private val binding
        get() = _biding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _biding = ActivityUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.usersRecycler.layoutManager = LinearLayoutManager(this)
        binding.usersRecycler.adapter = adapter
    }

    override fun updateList() {
        adapter.notifyDataSetChanged()
    }
}