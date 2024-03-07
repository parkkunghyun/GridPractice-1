package org.techtown.gridpractice_1.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

// 이미지 제목 수량?
data class Topic(
    @StringRes val titleResourceId: Int,
    val amount: Int,
    @DrawableRes val imageResourceId: Int,
    @DrawableRes val grainResourceId: Int
)
