package com.walton.smarthrm.model

data class User2(
    val creationDateTime: Long,
    val creationUser: String,
    val email: String,
    val groupUser: String,
    val groupUsername: String,
    val id: Int,
    val lastUpdateDateTime: String,
    val lastUpdateUser: String,
    val name: String,
    val organization: String,
    val password: String,
    val phone: String,
    val role: List<String>,
    val userTitle: String,
    val username: String
)