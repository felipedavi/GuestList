package io.github.felipedavi.guestlist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import io.github.felipedavi.guestlist.R
import io.github.felipedavi.guestlist.databinding.ActivityGuestFormBinding
import io.github.felipedavi.guestlist.viewmodel.GuestFormViewModel

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityGuestFormBinding
    private lateinit var mViewModel: GuestFormViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuestFormBinding.inflate(layoutInflater)
        mViewModel = ViewModelProvider(this)[GuestFormViewModel::class.java]
        setListeners()
        observe()
        binding.radioPresence.isChecked = true
        val view = binding.root
        setContentView(view)
    }

    override fun onClick(v: View?) {
        val id = v?.id
        if (id == R.id.button_save) {
            val name = binding.editName.text.toString()
            val presence = binding.radioPresence.isChecked
            mViewModel.save(name, presence)
        }
    }

    private fun setListeners() {
        binding.buttonSave.setOnClickListener(this)
    }

    private fun observe() {
        mViewModel.saveGuest.observe(this) {
            if (it) {
                Toast.makeText(applicationContext, "Sucess", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Fail", Toast.LENGTH_SHORT).show()
            }
        }
    }
}