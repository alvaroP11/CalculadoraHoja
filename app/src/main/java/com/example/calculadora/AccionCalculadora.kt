package com.example.calculadora

sealed class AccionCalculadora {
    data class Numero(val number: Int): AccionCalculadora()
    object Limpiar: AccionCalculadora()
    object Borrar: AccionCalculadora()
    object Decimal: AccionCalculadora()
    object Calcular: AccionCalculadora()
    data class Operacion(val operacion: OperacionCalculadora): AccionCalculadora()
}