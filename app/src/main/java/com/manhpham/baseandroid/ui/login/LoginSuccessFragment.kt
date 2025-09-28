package com.manhpham.baseandroid.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.manhpham.baseandroid.R
import com.manhpham.baseandroid.databinding.FragmentLoginSuccessBinding
import com.manhpham.baseandroid.ui.base.BaseFragment
import com.manhpham.baseandroid.ui.base.ScreenType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginSuccessFragment : BaseFragment<FragmentLoginSuccessBinding>(), LoginHandle {

    private val viewModel: LoginViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.let {
            it.viewModel = viewModel
            it.handle = this
        }
    }

    override fun didTapLogin() {
        requireActivity().findNavController(R.id.proxy_fragment_container)
            .navigate(R.id.action_loginSuccessFragment_to_homeFragment)
    }

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginSuccessBinding {
        return FragmentLoginSuccessBinding.inflate(inflater, container, false)
    }

    override fun screenType(): ScreenType {
        return ScreenType.LOGIN_SUCCESS
    }
}
