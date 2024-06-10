package com.ramos.myapplication.ui.core

import com.ramos.myapplication.data.network.entities.NasaData
import com.ramos.myapplication.data.network.entities.Photo
import com.ramos.myapplication.ui.entities.NasaDataUI

class FunctionExtensions
fun Photo.toNasaDataUI(): NasaDataUI =
    NasaDataUI(
        this.img_src,
        this.earth_date,
        this.rover.name,
        this.sol
    )


