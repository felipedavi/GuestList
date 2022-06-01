package io.github.felipedavi.guestlist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.felipedavi.guestlist.service.constants.GuestConstants
import io.github.felipedavi.guestlist.service.model.GuestModel
import io.github.felipedavi.guestlist.service.repository.GuestRepository

class GuestViewModel(application: Application) : AndroidViewModel(application) {
    private val mGuestRepository = GuestRepository(application.applicationContext)
    private val mGuestList = MutableLiveData<List<GuestModel>>()
    val guestlist: LiveData<List<GuestModel>> = mGuestList
    fun load(filter: Int) {
        when (filter) {
            GuestConstants.FILTER.EMPTY -> {
                mGuestList.value = mGuestRepository.getAll()
            }
            GuestConstants.FILTER.PRESENT -> {
                mGuestList.value = mGuestRepository.getPresent()
            }
            else -> {
                mGuestList.value = mGuestRepository.getAbsent()
            }
        }
    }
    fun delete(id: Int) {
        val guest = mGuestRepository.get(id)
        mGuestRepository.delete(guest)
    }
}