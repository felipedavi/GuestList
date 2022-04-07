package io.github.felipedavi.guestlist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.felipedavi.guestlist.service.model.GuestModel
import io.github.felipedavi.guestlist.service.repository.GuestRepository

class GuestFormViewModel(application: Application): AndroidViewModel(application) {
    private val mContext by lazy { application.applicationContext }
    private var mRepository = GuestRepository.getInstance(mContext)
    private var mSaveGuest = MutableLiveData<Boolean>()
    val saveGuest: LiveData<Boolean> = mSaveGuest

    fun save(id: Int, name: String, presence: Boolean) {
        val guest = GuestModel(id, name, presence)
        if (id == 0) {
            mRepository.save(guest)
        } else {
            mRepository.update(guest)
        }

    }
}