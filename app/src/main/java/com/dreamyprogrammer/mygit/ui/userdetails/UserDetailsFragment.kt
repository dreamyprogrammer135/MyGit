package com.dreamyprogrammer.mygit.ui.userdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.core.view.isVisible
import com.dreamyprogrammer.mygit.databinding.FragmentUserDetailsBinding
import com.dreamyprogrammer.mygit.model.GithubUserModel
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserDetailsFragment : MvpAppCompatFragment(), UserDetailsContract.View {
    private var _binding: FragmentUserDetailsBinding? = null
    private val binding: FragmentUserDetailsBinding
        get() = _binding!!

    private val presenter by moxyPresenter { UserDetailsPresenter() }

    override fun setState(state: UserDetailsContract.ViewState) {
        binding.root.children.forEach { it.isVisible = false }
        when (state) {
            UserDetailsContract.ViewState.IDLE -> binding.container.isVisible = true
            UserDetailsContract.ViewState.LOADING -> binding.container.isVisible = true
        }
    }

    override fun exit() {
        TODO("Not yet implemented")
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = arguments?.getParcelable<GithubUserModel>(EXTRA_KEY_USER)

        user?.let {
            binding.loginTextView.text = it.login
        }

        binding.buttonClose.setOnClickListener { presenter.onClose() }
    }

    // Филипп вопрос. если используем Moxy onDestroy нужно делать или Moxy сама это делает?
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val EXTRA_KEY_USER = "user"
        fun newInstance(user: GithubUserModel) = UserDetailsFragment().apply {
            arguments = Bundle().apply {
                putParcelable(EXTRA_KEY_USER, user)
            }
        }
    }
}