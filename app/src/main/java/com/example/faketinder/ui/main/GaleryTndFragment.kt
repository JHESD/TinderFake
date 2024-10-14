package com.example.faketinder.ui.main

import android.os.Bundle
import android.view.GestureDetector
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GestureDetectorCompat
import com.example.faketinder.adapter.Users
import com.example.faketinder.databinding.FragmentGaleryTndBinding
import com.example.faketinder.db.UserData
import com.example.faketinder.ui.viewmodel.GaleryTndModel

class GaleryTndFragment : Fragment() {
    private lateinit var binding: FragmentGaleryTndBinding
    private lateinit var gestureDetector: GestureDetectorCompat

    // Instancia de usuario
    var currentUser: Users? = null
    private var indice: Int = 0
   // private val model: GaleryTndModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGaleryTndBinding.inflate(
            inflater,
            container,
            false
        )

        // Obtenemos el usuario
        val id = arguments?.getInt("id") ?: 1
        setUpUser(id)
        binding.imgUserGalery.setImageDrawable(currentUser?.historias?.get(indice))

        // Eventos
        setupEventListener()
        //setupGestureDetector()
        return binding.root
    }

   /* private fun setupGestureDetector() {
        gestureDetector = GestureDetectorCompat(
            this,
            object : GestureDetector.SimpleOnGestureListener() {
            private val SWIPE_THRESHOLD = 100
            private val SWIPE_VELOCITY_THRESHOLD = 100

            override fun onFling(
                e1: MotionEvent?,
                e2: MotionEvent?,
                velocityX: Float,
                velocityY: Float
            ): Boolean {
                val diffX = e2?.x?.minus(e1!!.x) ?: 0f
                val diffY = e2?.y?.minus(e1!!.y) ?: 0f

                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD &&
                        Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            model.goBack(indice) // Swipe derecha, ir atrás
                        } else {
                            model.goNext(indice, currentUser?.historias?.size ?: 0) // Swipe izquierda, siguiente
                        }
                        return true
                    }
                }
                return false
            }
        })
    }*/

    private fun setUpUser(id : Int){
        // Obtenemos el usuario
        val personData = UserData(context = requireContext())
        currentUser = personData.getPersonasById(id)
    }

    private fun setupEventListener() {
        binding.imgUserGalery.setImageDrawable(
            currentUser?.historias?.get(
            indice
            )
        )

        /*model.siguiente.observe(this) {
            if (it) {
                indice++
                )
            }
        }
        model.atras.observe(this) {
            if (it) {
                indice--
                binding.imgUserGalery.setImageDrawable(currentUser?.historias?.get(indice))
            }
        }
        model.terminar.observe(this) {
            if (it) {
                finish()
            }
        }*/
    }
}