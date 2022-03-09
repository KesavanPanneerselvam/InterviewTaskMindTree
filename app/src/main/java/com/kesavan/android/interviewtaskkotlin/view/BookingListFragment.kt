package com.kesavan.android.interviewtaskkotlin.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kesavan.android.interviewtaskkotlin.R
import com.kesavan.android.interviewtaskkotlin.adapter.BookingListAdapter
import com.kesavan.android.interviewtaskkotlin.databinding.FragmentListBinding
import com.kesavan.android.interviewtaskkotlin.model.BookingItem
import com.kesavan.android.interviewtaskkotlin.utils.PARAM_BOOKINGITEM
import java.util.Date
import kotlin.random.Random


class BookingListFragment : Fragment() {

    lateinit var binding:FragmentListBinding
    lateinit var adapter: BookingListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentListBinding.inflate(layoutInflater,container,false)
        adapter=BookingListAdapter{ item -> onAdapterItemClick(item) }
        binding.rcvBookinglist.layoutManager=LinearLayoutManager(context)
        binding.rcvBookinglist.adapter=adapter

        var bookingItems:MutableList<BookingItem> = mutableListOf()
        for(n in 1..9){
            bookingItems.add(BookingItem(
                "Hotel $n",
                "https://photos.hotelbeds.com/giata/00/004200/004200a_hb_ro_00$n.jpg",
                Date(),
                Random.nextDouble(500.0, 1500.0),
                Random.nextInt(1, 5),
                "No. $n, Oxford Street, $n Chesterfield Road, London E10 6EW"
            ))
        }
        adapter.loadBookings(bookingItems)
        return binding.root
    }
    fun onAdapterItemClick(item:BookingItem) {
        val bundle= bundleOf()
        bundle.putSerializable(PARAM_BOOKINGITEM,item)
        findNavController().navigate(R.id.action_bookingListFragment_to_bookingDetailsFragment,bundle)
    }

}