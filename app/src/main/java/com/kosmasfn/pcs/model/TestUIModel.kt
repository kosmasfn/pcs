package com.kosmasfn.pcs.model

import java.io.Serializable

data class TestUIModel(
    val addressNo: String = "",
    val avatar: String = "",
    val city: String = "",
    val country: String = "",
    val county: String = "",
    val createdAt: String = "",
    val id: String = "",
    val name: String = "",
    val street: String = "",
    val zipCode: String = ""
) : Serializable