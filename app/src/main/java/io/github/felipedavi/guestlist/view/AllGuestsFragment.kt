package io.github.felipedavi.guestlist.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.felipedavi.guestlist.R
import io.github.felipedavi.guestlist.service.constants.GuestConstants
import io.github.felipedavi.guestlist.view.adapter.GuestAdapter
import io.github.felipedavi.guestlist.view.listener.GuestListener
import io.github.felipedavi.guestlist.viewmodel.GuestViewModel

class AllGuestsFragment : Fragment() {
    private lateinit var mViewModel: GuestViewModel
    private lateinit var mListener: GuestListener
    private val mAdapter: GuestAdapter = GuestAdapter()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, s: Bundle?): View {
        mViewModel = ViewModelProvider(this)[GuestViewModel::class.java]
        val root = inflater.inflate(R.layout.fragment_all, container, false)
        val recycler = root.findViewById<RecyclerView>(R.id.recycler_all_guests)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = mAdapter
        mListener = object: GuestListener{
            override fun onClick(id: Int) {
                val intent = Intent(context, GuestFormActivity::class.java)
                val bundle = Bundle()
                bundle.putInt(GuestConstants.GUESTID, id)

                intent.putExtras(bundle)
                startActivity(intent)
            }

            override fun onDelete(id: Int) {
                mViewModel.delete(id)
                mViewModel.load()
            }
        }
        mAdapter.attachListener(mListener)
        observe()
        mViewModel.load()
        return root
    }

    override fun onResume() {
        super.onResume()
        mViewModel.load()
    }

    private fun observe() {
        mViewModel.guestlist.observe(viewLifecycleOwner) {
            mAdapter.updateGuests(it)
        }
    }
}