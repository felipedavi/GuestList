package io.github.felipedavi.guestlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.felipedavi.guestlist.service.model.GuestModel
import io.github.felipedavi.guestlist.service.repository.GuestRepository

class GuestFormViewModel: ViewModel() {
    private var mSaveGuest = MutableLiveData<Boolean>()
    private lateinit var mRepository: GuestRepository
    val saveGuest: LiveData<Boolean> = mSaveGuest
    fun save(name: String, presence: Boolean) {
        val guest = GuestModel(name,presence)
        mRepository.save(guest)
    }
}