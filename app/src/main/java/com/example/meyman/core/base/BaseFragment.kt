package com.example.meyman.core.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.example.meyman.presentation.base.Resource
import com.example.meyman.presentation.state.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel>(
    @LayoutRes layoutId: Int
) : Fragment(layoutId) {

    abstract val binding: VB
    abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
        setupRequests()
        setupSubscribes()
    }

    protected open fun initialize() {}

    protected open fun setupListener() {}

    protected open fun setupRequests() {}

    protected open fun setupSubscribes() {}

    protected open fun <T> Flow<Resource<T>>.subscribes(
        state: ((state: Resource<T>) -> Unit)? = null,
        onFailure: (failure: String) -> Unit,
        onSuccess: ((data: T) -> Unit)
    ) {
        lifecycleScope.launch {
            collect {
                when (it) {
                    is Resource.Error -> {}
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        it.data?.let { data ->
                            onSuccess(data)
                        }
                    }
                }
            }
        }
    }
}