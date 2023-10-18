package com.example.calculadora

sealed class OperacionCalculadora (val symbol: String){
    object Suma: OperacionCalculadora ("+")
    object Resta: OperacionCalculadora ("-")
    object Multiplicacion: OperacionCalculadora ("x")
    object Division: OperacionCalculadora ("/")
}
