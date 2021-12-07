package com.dreamyprogrammer.mygit.ui.base

interface IListPresenter<V: IItemView> {
    var itemClickListener: () -> Unit

    fun getCount(): Int

    fun bindView(View: V)

}