package com.example.frmuladequeda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var x =""

    fun xVelocidade(componente: View){
        et_v.visibility = View.GONE
        et_g.visibility = View.VISIBLE
        et_t.visibility = View.VISIBLE
        bt_c.visibility = View.VISIBLE
        x = "v"
    }

    fun xTempo(componente: View){
        et_t.visibility = View.GONE
        et_g.visibility = View.VISIBLE
        et_v.visibility = View.VISIBLE
        bt_c.visibility = View.VISIBLE
        x = "t"
    }

    fun xGravidade(componente: View){
        et_g.visibility = View.GONE
        et_t.visibility = View.VISIBLE
        et_v.visibility = View.VISIBLE
        bt_c.visibility = View.VISIBLE
        x = "g"
    }

    fun calcular(componente:View){

        val velReal = et_v.text.toString().toDouble()
        val temReal = et_t.text.toString().toDouble()
        val graReal = et_t.text.toString().toDouble()

        if(x == "g"){
            tv_resultado.text = "g = v/t, ou seja, g = $velReal/$temReal. Portanto, g = ${velReal/temReal}"
            val gFrase = when(velReal/temReal){
                in Double.MIN_VALUE.. 0.0 -> "Cadê aa gravidade?"
                in 0.1..2.9 -> "Até parece que esá na Lua"
                in 3.0..5.0 -> "Essa queda poderia ter sido em Marte"
                in 5.1..8.5 -> "Ihh, ainda não parece estar na Terra"
                in 8.6..10.9 -> "Essa queda provavelmente aconteceu em nosso planeta"
                in 11.0..Double.MAX_VALUE -> "A gravidade tava bem forte ai, hein!"
                else -> "Caiu no Horizonte de Eventos !"
            }

        }
        if(x == "v"){
            tv_resultado.text = "v = v*t, ou seja, v = $graReal/$temReal. Portanto, v = ${graReal/temReal}"
        }
        if(x == "t"){
            tv_resultado.text = "t = v/g, ou seja, v = $velReal/$graReal. Portanto, v = ${velReal/graReal}"
        }

    }
}