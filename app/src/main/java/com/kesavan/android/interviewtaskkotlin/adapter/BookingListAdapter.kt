package com.kesavan.android.interviewtaskkotlin.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kesavan.android.interviewtaskkotlin.databinding.LayBookingitemBinding
import com.kesavan.android.interviewtaskkotlin.model.BookingItem
import com.kesavan.android.interviewtaskkotlin.utils.dateFormat
import com.kesavan.android.interviewtaskkotlin.utils.moneyformat
import com.squareup.picasso.Picasso

class BookingListAdapter(val adapterOnClick : (BookingItem) -> Unit): RecyclerView.Adapter<BookingViewHolder>() {
    private val bookingItems: MutableList<BookingItem> = mutableListOf()

    fun loadBookings(bookingItems:MutableList<BookingItem>){
        this.bookingItems.addAll(bookingItems)
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingViewHolder {
        return BookingViewHolder(LayBookingitemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: BookingViewHolder, position: Int) {
       holder.updateView(bookingItems[position])
        holder.itemView.setOnClickListener {  adapterOnClick(bookingItems[position])}
    }

    override fun getItemCount(): Int {
        return bookingItems.size
    }
}

class BookingViewHolder(itemView: LayBookingitemBinding) :
    RecyclerView.ViewHolder(itemView.root) {
    private val txtHotelname = itemView.txtHotelname
    private val txtBookingdate = itemView.txtBookingdate
    private val imgHotel = itemView.imgHotel
    private val txtHotelprice = itemView.txtHotelprice

    fun updateView(item:BookingItem){
        txtHotelname.text=item.hotelName
        txtBookingdate.text= dateFormat.format(item.bookeddate)
        Picasso.get().load(item.hotelImage).into(imgHotel);
        txtHotelprice.text= moneyformat.format(item.bookingAmount)


    }
}