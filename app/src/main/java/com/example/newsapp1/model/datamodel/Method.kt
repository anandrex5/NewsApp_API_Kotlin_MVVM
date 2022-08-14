package com.example.newsapp1.model.datamodel

import com.example.newsapp1.model.datamodel.Fermentation
import com.example.newsapp1.model.datamodel.MashTemp

data class Method(
    val fermentation: Fermentation,
    val mash_temp: List<MashTemp>,
    val twist: String
)