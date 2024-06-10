package com.aguas.myapplication.ui.core

import com.aguas.myapplication.data.network.entities.Photo
import com.aguas.myapplication.ui.entities.NasaDataUI

class FunctionExtensions
fun Photo.toNasaDataUI(): NasaDataUI =
    NasaDataUI(
        this.img_src,
        this.earth_date,
        this.rover.name,
        this.sol
    )


