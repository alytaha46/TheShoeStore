package com.example.theshoestore.baseViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.theshoestore.models.Shoes

class AppViewModel : ViewModel() {
    val name: MutableLiveData<String> = MutableLiveData<String>("")
    val company: MutableLiveData<String> = MutableLiveData<String>("")
    val size: MutableLiveData<String> = MutableLiveData<String>("")
    val description: MutableLiveData<String> = MutableLiveData<String>("")

    private var _shoe_list: MutableLiveData<MutableList<Shoes>> =
        MutableLiveData<MutableList<Shoes>>(
            mutableListOf()
        )
    val shoe_list: LiveData<MutableList<Shoes>> get() = _shoe_list

    private val _state: MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)
    val state: LiveData<Boolean> get() = _state


    fun save() {
        _shoe_list.value?.add(
            Shoes(
                name.value.toString(),
                company.value.toString(),
                size.value.toString(),
                description.value.toString()
            )
        )
        _state.value = true
    }

    fun cancel() {
        _state.value = true
    }

    fun onNavigateDone() {
        _state.value = false
    }

    fun resetAttr() {
        name.value = ""
        company.value = ""
        size.value = ""
        description.value = ""
    }
}