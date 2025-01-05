package com.kosmasfn.pcs.view

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kosmasfn.data.common.Resource
import com.kosmasfn.domain.usecase.UseCase
import com.kosmasfn.pcs.converter.toUIModel
import com.kosmasfn.pcs.model.TestUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    private val useCase: UseCase
) : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading: Flow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow("")
    val errorMessage: Flow<String> = _errorMessage

    private val _data = MutableStateFlow(listOf<TestUIModel>())
    val data: Flow<List<TestUIModel>> = _data

    fun fetchData() {
        viewModelScope.launch {
            useCase.fetchData().collect {
                when (it.status) {
                    Resource.Status.LOADING -> {
                        _isLoading.value = true
                    }

                    Resource.Status.SUCCESS -> {
                        it.data?.let { data ->
                            _data.value = data.map { d -> d.toUIModel() }
                        }
                        _isLoading.value = false
                    }

                    Resource.Status.ERROR -> {
                        _isLoading.value = false
                        _errorMessage.value = it.error?.data?.message ?: "Unknown Error"
                    }
                }
            }
        }
    }
}