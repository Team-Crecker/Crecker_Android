package org.techtown.crecker.mypage

import java.util.*

data class UsageRecord(
    var title: String = "",
    var io: String = "",
    var money: Int = 0,
    var date: Date = Date()
)