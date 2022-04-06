package io.github.felipedavi.guestlist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.felipedavi.guestlist.R
import io.github.felipedavi.guestlist.databinding.ActivityGuestFormBinding

class GuestFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGuestFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuestFormBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}