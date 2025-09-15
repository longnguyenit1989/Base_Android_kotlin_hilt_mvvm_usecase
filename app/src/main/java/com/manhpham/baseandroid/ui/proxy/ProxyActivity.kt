package com.manhpham.baseandroid.ui.proxy

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.manhpham.baseandroid.R
import com.manhpham.baseandroid.databinding.ActivityProxyBinding
import com.manhpham.baseandroid.ui.base.BaseActivity
import com.manhpham.baseandroid.ui.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProxyActivity : BaseActivity<ActivityProxyBinding>() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun inflateBinding(inflater: LayoutInflater): ActivityProxyBinding {
        return ActivityProxyBinding.inflate(inflater)
    }

    override fun setupUI() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.proxy_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        val graph = navController.navInflater.inflate(R.navigation.app_nav)

        if (viewModel.isLogin()) {
            graph.setStartDestination(R.id.homeFragment)
        } else {
            graph.setStartDestination(R.id.loginFragment)
        }

        navController.setGraph(graph = graph, startDestinationArgs = null)
    }
}
