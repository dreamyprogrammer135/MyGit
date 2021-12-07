package com.dreamyprogrammer.mygit.ui.users.adapter

import com.dreamyprogrammer.mygit.domain.GithubUserRepo
import com.dreamyprogrammer.mygit.model.GithubUserModel
import com.dreamyprogrammer.mygit.ui.base.IListPresenter
import com.dreamyprogrammer.mygit.ui.users.UserItemView
import com.dreamyprogrammer.mygit.ui.users.UsersView
import moxy.MvpPresenter

class UsersPresenter(
    private val usersRepo: GithubUserRepo
) : MvpPresenter<UsersView>() {
    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()

        usersListPresenter.itemClickListener = {} // TODO
    }

    private fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)

        viewState.updateList()
    }

    class UsersListPresenter : IListPresenter<UserItemView> {

        val users = mutableListOf<GithubUserModel>()

        override var itemClickListener: () -> Unit = {}

        override fun getCount() = users.size

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }
}