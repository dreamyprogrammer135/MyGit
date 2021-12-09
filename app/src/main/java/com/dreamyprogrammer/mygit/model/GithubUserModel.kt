package com.dreamyprogrammer.mygit.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class GithubUserModel(
    val login: String
):Parcelable