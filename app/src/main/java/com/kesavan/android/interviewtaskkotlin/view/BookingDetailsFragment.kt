package com.kesavan.android.interviewtaskkotlin.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kesavan.android.interviewtaskkotlin.R
import com.kesavan.android.interviewtaskkotlin.databinding.FragmentBookingDetailsBinding
import com.kesavan.android.interviewtaskkotlin.databinding.FragmentListBinding
import com.kesavan.android.interviewtaskkotlin.model.BookingItem
import com.kesavan.android.interviewtaskkotlin.utils.PARAM_BOOKINGITEM
import com.kesavan.android.interviewtaskkotlin.utils.dateFormat
import com.kesavan.android.interviewtaskkotlin.utils.moneyformat
import com.squareup.picasso.Picasso

class BookingDetailsFragment : Fragment() {
    lateinit var binding: FragmentBookingDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentBookingDetailsBinding.inflate(layoutInflater,container,false)

        val bookingItem=arguments?.getSerializable(PARAM_BOOKINGITEM) as BookingItem

        bookingItem?.let{ item ->
            binding.txtHotelname.text=item.hotelName
            binding.rating.rating= item.rating.toFloat()
            Picasso.get().load(item.hotelImage).into(binding.imgHotel);
            binding.address.text= item.address
        }

        return binding.root
    }
}