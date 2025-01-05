package com.kosmasfn.domain.converter

import com.kosmasfn.data.model.TestDataModel
import com.kosmasfn.domain.model.TestDomainModel

fun TestDataModel.toDomainModel(): TestDomainModel = TestDomainModel(
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