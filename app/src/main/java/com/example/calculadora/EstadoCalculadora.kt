package com.example.calculadora

data class EstadoCalculadora(
    val numero1: String = "",
    val numero2: String = "",
    val operacion: OperacionCalculadora? = null
)
