package io.github.felipedavi.guestlist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.felipedavi.guestlist.service.model.GuestModel
import io.github.felipedavi.guestlist.service.repository.GuestRepository

class GuestViewModel(application: Application) : AndroidViewModel(application) {
    private val mGuestRepository = GuestRepository.getInstance(application.applicationContext)
    private val mGuestList = MutableLiveData<List<GuestModel>>()
    val guestlist: LiveData<List<GuestModel>> = mGuestList
    fun load() {
        mGuestList.value = mGuestRepository.getAll()
    }
}