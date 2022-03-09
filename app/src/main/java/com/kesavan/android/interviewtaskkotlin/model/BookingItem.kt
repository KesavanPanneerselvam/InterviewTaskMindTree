package com.kesavan.android.interviewtaskkotlin.model

import java.io.Serializable
import java.util.*

data class BookingItem(
    val hotelName:String,
    val hotelImage:String,
    val bookeddate:Date,
    val bookingAmount:Double,
    val rating:Int,
    val address:String):Serializable
