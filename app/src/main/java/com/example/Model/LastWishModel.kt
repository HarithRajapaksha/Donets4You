package com.example.Model

data class LastWishModel(
    val uid: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val phoneNumber: String? = null,
    val email: String? = null,
    val address: String? = null,
    val isCertified: Boolean = false,
    val notifierName: String? = null,
    val notifierPhoneNumber: String? = null,
    val lastWish: String? = null
)
