package com.example.faketinder.adapter

import android.graphics.drawable.Drawable

class Users(
    var id: Int = 0,
    var name: String = "",
    var pPhoto: Drawable? = null,
    var historias: List<Drawable?> = emptyList(),
    var likes: Boolean = false
)