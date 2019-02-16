package com.example.meetaptravel

import android.os.Parcel
import android.os.Parcelable

class PlaceModel() : Parcelable {
    var id: Int = 0
    var image: String = ""
    var name: String = ""
    var desc: String = ""
    var distance: Int = 0
    var address: String = ""
    var district: String = ""
    var operationalTime: List<String>? = null
    var numbTelp: String? = ""
    var price: Int = 0
    var latlong: String = ""

    constructor(id: Int, image: String, name: String,
                desc: String, distance: Int, address: String,
                district:String,operationalTime:List<String>?,
                numbTelp:String?,price:Int,latlong:String) : this(){
        this.id = id
        this.image = image
        this.name = name
        this.desc = desc
        this.distance = distance
        this.address = address
        this.district = district
        this.operationalTime = operationalTime
        this.numbTelp = numbTelp
        this.price = price
        this.latlong = latlong
    }
    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        image = parcel.readString()
        name = parcel.readString()
        desc = parcel.readString()
        distance = parcel.readInt()
        address = parcel.readString()
        district = parcel.readString()
        operationalTime = parcel.createStringArrayList()
        numbTelp = parcel.readString()
        price = parcel.readInt()
        latlong = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(image)
        parcel.writeString(name)
        parcel.writeString(desc)
        parcel.writeInt(distance)
        parcel.writeString(address)
        parcel.writeString(district)
        parcel.writeStringList(operationalTime)
        parcel.writeString(numbTelp)
        parcel.writeInt(price)
        parcel.writeString(latlong)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PlaceModel> {
        override fun createFromParcel(parcel: Parcel): PlaceModel {
            return PlaceModel(parcel)
        }

        override fun newArray(size: Int): Array<PlaceModel?> {
            return arrayOfNulls(size)
        }
    }

}