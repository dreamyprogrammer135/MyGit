package com.dreamyprogrammer.mygit.screens

import com.dreamyprogrammer.mygit.ui.users.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object AppScreens {
    fun usersScreen() = FragmentScreen {
        UsersFragment()
    }
}