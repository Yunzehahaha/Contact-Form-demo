package com.example.codetest.viewModel

import androidx.lifecycle.*
import com.example.codetest.model.DetailInfo
import com.example.codetest.repository.Repository
import kotlinx.coroutines.launch

class MyViewModel(private val repository: Repository): ViewModel() {

    val allData: LiveData<List<DetailInfo>> = repository.allData.asLiveData()

    fun updateData(detailInfo: DetailInfo) = viewModelScope.launch {
        repository.update(detailInfo)
    }

    class myViewModelFactory(private val repo: Repository): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
                return MyViewModel(repo) as T
            }
            throw IllegalArgumentException("Unknow ViewModel class")
        }
    }
}