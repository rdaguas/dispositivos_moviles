package com.aguas.myapplication.ui.core

import com.aguas.myapplication.data.network.entities.NobelPrize
import com.aguas.myapplication.ui.entities.PremiosNobelDataUI

class FunctionExtensions
fun NobelPrize.toDataPremiosNobelUI(): PremiosNobelDataUI =
    PremiosNobelDataUI(
        this.awardYear,
        this.prizeAmount
    )


