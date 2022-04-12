package io.github.felipedavi.guestlist.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.github.felipedavi.guestlist.R
import io.github.felipedavi.guestlist.service.model.GuestModel

class GuestViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(guest: GuestModel) {
        val textName = itemView.findViewById<TextView>(R.id.text_name)
        textName.text = guest.name
    }
}