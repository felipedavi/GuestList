package io.github.felipedavi.guestlist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.github.felipedavi.guestlist.R

class AbsentFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, s: Bundle?): View {
        return inflater.inflate(R.layout.fragment_absent, container, false)
    }
}