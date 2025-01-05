package com.kosmasfn.pcs.converter

import com.kosmasfn.domain.model.TestDomainModel
import com.kosmasfn.pcs.model.TestUIModel

fun TestDomainModel.toUIModel(): TestUIModel = TestUIModel(
    this.addressNo ?: "",
    this.avatar ?: "",
    this.city ?: "",
    this.country ?: "",
    this.county ?: "",
    this.createdAt ?: "",
    this.id ?: "",
    this.name ?: "",
    this.street ?: "",
    this.zipCode ?: ""
)