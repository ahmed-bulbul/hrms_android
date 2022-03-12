package com.walton.smarthrm.model

data class User(
    val address: String,
    val creationDateTime: String,
    val creationUser: String,
    val email: String,
    val gender: String,
    val groupUser: String,
    val groupUsername: String,
    val id: Int,
    val lastUpdateDateTime: String,
    val lastUpdateUser: String,
    val name: String,
    val organization: Organization,
    val password: String,
    val phone: String,
    val roles: List<Role>,
    val userTitle: String,
    val username: String
)