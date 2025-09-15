package com.manhpham.baseandroid.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.manhpham.baseandroid.ui.dialog.LoadingProgress

abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: T

    val progress: LoadingProgress by lazy { LoadingProgress() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateBinding(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    protected abstract fun inflateBinding(inflater: LayoutInflater): T

    protected abstract fun setupUI()
}
