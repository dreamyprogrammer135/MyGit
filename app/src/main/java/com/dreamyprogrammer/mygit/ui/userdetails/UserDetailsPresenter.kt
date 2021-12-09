package com.dreamyprogrammer.mygit.ui.userdetails

class UserDetailsPresenter : UserDetailsContract.Presenter() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    override fun onClose() {
        viewState.exit()
    }
}