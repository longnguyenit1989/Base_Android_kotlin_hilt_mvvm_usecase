package com.manhpham.baseandroid.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.manhpham.baseandroid.databinding.FragmentDetailImageBinding
import com.manhpham.baseandroid.ui.base.BaseFragment
import com.manhpham.baseandroid.ui.base.ScreenType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailImageFragment : BaseFragment<FragmentDetailImageBinding>(), DetailHandle {

    private val viewModel: DetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.let { binding ->
            binding.viewModel = viewModel
            binding.handle = this
            arguments?.getString("key")?.let {
                viewModel.img = it
            }
        }
    }

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailImageBinding {
        return FragmentDetailImageBinding.inflate(inflater, container, false)
    }

    override fun screenType(): ScreenType {
        return ScreenType.IMG_DETAIL
    }

    override fun didTapClose() {
        activity?.onBackPressedDispatcher?.onBackPressed()
    }
}
