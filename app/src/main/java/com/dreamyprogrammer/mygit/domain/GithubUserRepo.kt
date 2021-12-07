package com.dreamyprogrammer.mygit.domain

import com.dreamyprogrammer.mygit.model.GithubUserModel

class GithubUserRepo {
    private val users = listOf(
        GithubUserModel("user1"),
        GithubUserModel("user2"),
        GithubUserModel("user3"),
        GithubUserModel("user4"),
        GithubUserModel("user5"),
        GithubUserModel("user6"),
        GithubUserModel("user7"),
        GithubUserModel("user8"),
        GithubUserModel("user9"),
        GithubUserModel("user10"),
        GithubUserModel("user11"),
        GithubUserModel("user12"),
        GithubUserModel("user13"),
        GithubUserModel("user14"),
        GithubUserModel("user15")
    )

    fun getUsers(): List<GithubUserModel>{
        return users
    }
}