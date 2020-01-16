package com.example.myfirstandroidapplication.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class Account (val name: String, val age: Int): Parcelable{

}