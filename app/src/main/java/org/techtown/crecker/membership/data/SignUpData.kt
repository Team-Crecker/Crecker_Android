package org.techtown.crecker.membership.data

data class SignUpData(
    val agreement: Int,
    val channelName: String,
    val email: String,
    val interest: List<String>,
    val location: String,
    val name: String,
    val notRegisterUrl: String,
    val password: String,
    val phone: String,
    val youtubeUrl: String
)