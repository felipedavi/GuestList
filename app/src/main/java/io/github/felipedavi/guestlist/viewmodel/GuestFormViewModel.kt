package io.github.felipedavi.guestlist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.felipedavi.guestlist.service.model.GuestModel
import io.github.felipedavi.guestlist.service.repository.GuestRepository

class GuestFormViewModel(application: Application): AndroidViewModel(application) {
    private val mContext by lazy { application.applicationContext }
    private var mRepository = GuestRepository.getInstance(mContext)
    private var mSaveGuest = MutableLiveData<Boolean>()
    val saveGuest: LiveData<Boolean> = mSaveGuest

    private var mGuest = MutableLiveData<GuestModel>()
    val guest: LiveData<GuestModel> = mGuest

    fun save(id: Int, name: String, presence: Boolean) {
        val guest = GuestModel(id, name, presence)
        if (id == 0) {
            mSaveGuest.value = mRepository.save(guest)
        } else {
            mSaveGuest.value = mRepository.update(guest)
        }
    }

    fun load(id: Int) {
        mGuest.value = mRepository.get(id)
    }
}