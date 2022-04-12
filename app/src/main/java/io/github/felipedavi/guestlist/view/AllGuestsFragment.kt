package io.github.felipedavi.guestlist.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.felipedavi.guestlist.R
import io.github.felipedavi.guestlist.view.adapter.GuestAdapter
import io.github.felipedavi.guestlist.viewmodel.GuestViewModel

class AllGuestsFragment : Fragment() {
    private lateinit var mViewModel: GuestViewModel
    private val mAdapter: GuestAdapter = GuestAdapter()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, s: Bundle?): View {
        mViewModel = ViewModelProvider(this)[GuestViewModel::class.java]
        val root = inflater.inflate(R.layout.fragment_all, container, false)
        val recycler = root.findViewById<RecyclerView>(R.id.recycler_all_guests)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = mAdapter
        observe()
        mViewModel.load()
        return root
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observe() {
        mViewModel.guestlist.observe(viewLifecycleOwner, Observer {
            mAdapter.updateGuests(it)
        })
    }
}