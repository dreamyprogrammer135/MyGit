package com.dreamyprogrammer.mygit.ui.users

import com.dreamyprogrammer.mygit.domain.GithubUserRepo
import com.dreamyprogrammer.mygit.model.GithubUserModel
import com.dreamyprogrammer.mygit.ui.base.IListPresenter
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(
    private val router: Router,
    private val usersRepo: GithubUserRepo
) : MvpPresenter<UsersView>() {
    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()

        usersListPresenter.itemClickListener = {} // TODO открываем фрагмент с юзером из списка
    }

    private fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)

        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
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