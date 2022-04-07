package io.github.felipedavi.guestlist.service.repository

import android.content.Context
import io.github.felipedavi.guestlist.service.model.GuestModel

class GuestRepository private constructor(context: Context) {
    private var mGuestDataBaseHelper = GuestDataBaseHelper(context)

    companion object {
        private lateinit var repository: GuestRepository
        fun getInstance(context: Context): GuestRepository {
            if (!::repository.isInitialized) {
                repository = GuestRepository(context)
            }
            return repository
        }
    }

    fun save(guest: GuestModel) {

    }
}