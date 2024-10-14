package com.example.faketinder.db

import android.content.Context
import androidx.core.content.ContextCompat
import com.example.faketinder.R
import com.example.faketinder.adapter.Users

class UserData(private val context: Context) {
    fun getUser(): MutableList<Users>{
        return mutableListOf(
            Users(
                1,
                "Klein Moretti",
                ContextCompat.getDrawable(context, R.drawable.usuario1  ), //Perfil
                listOf(
                    ContextCompat.getDrawable(context, R.drawable.salar), //Fotos
                    ContextCompat.getDrawable(context, R.drawable.salar2),
                    ContextCompat.getDrawable(context, R.drawable.salar3)
                )
            )
        )
    }
    fun getPersonasById(id: Int): Users? {
        return getUser().find { it.id == id }
    }
}