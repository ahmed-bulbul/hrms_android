package com.walton.smarthrm.model

data class  Organization(
    val creationDateTime: String,
    val creationUser: String,
    val id: Int,
    val lastUpdateDateTime: String,
    val lastUpdateUser: String,
    val name: String
)