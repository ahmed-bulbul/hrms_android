package com.walton.smarthrm.model

data class Role(
    val authority: String,
    val creationDateTime: Long,
    val creationUser: String,
    val description: String,
    val id: Int,
    val lastUpdateDateTime: String,
    val lastUpdateUser: String
)