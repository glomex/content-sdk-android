package com.glomex.contentsdk.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/** Error. */
@SuppressWarnings("ParcelCreator")
@Parcelize
internal data class Error(
        @SerializedName("error") val message: String
): Parcelable