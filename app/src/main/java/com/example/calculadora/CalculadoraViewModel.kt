package com.example.calculadora

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculadoraViewModel: ViewModel() {
    var estado by mutableStateOf(EstadoCalculadora())
    fun onAction(action: AccionCalculadora) {
        when(action) {
            is AccionCalculadora.Numero -> enterNumber(action.number)
            is AccionCalculadora.Borrar -> delete()
            is AccionCalculadora.Limpiar -> estado = EstadoCalculadora()
            is AccionCalculadora.Operacion -> enterOperation(action.operacion)
            is AccionCalculadora.Decimal -> enterDecimal()
            is AccionCalculadora.Calcular -> calculate()
        }
    }

    private fun enterOperation(operation: OperacionCalculadora) {
        if(estado.numero1.isNotBlank()) {
            estado = estado.copy(operacion = operation)
        }
    }

    private fun calculate() {
        val numero1 = estado.numero1.toDoubleOrNull()
        val numero2 = estado.numero2.toDoubleOrNull()
        if(numero1 != null && numero2 != null) {
            val result = when(estado.operacion) {
                is OperacionCalculadora.Suma -> numero1 + numero2
                is OperacionCalculadora.Resta -> numero1 - numero2
                is OperacionCalculadora.Multiplicacion -> numero1 * numero2
                is OperacionCalculadora.Division -> numero1 / numero2
                null -> return
            }
            estado = estado.copy(
                numero1 = result.toString().take(15),
                numero2 = "",
                operacion = null
            )
        }
    }

    private fun delete() {
        when {
            estado.numero2.isNotBlank() -> estado = estado.copy(
                numero2 = estado.numero2.dropLast(1)
            )
            estado.operacion != null -> estado = estado.copy(
                operacion = null
            )
            estado.numero1.isNotBlank() -> estado = estado.copy(
                numero1 = estado.numero1.dropLast(1)
            )
        }
    }

    private fun enterDecimal() {
        if(estado.operacion == null && !estado.numero1.contains(".") && estado.numero1.isNotBlank()) {
            estado = estado.copy(
                numero1 = estado.numero1 + "."
            )
            return
        } else if(!estado.numero2.contains(".") && estado.numero2.isNotBlank()) {
            estado = estado.copy(
                numero2 = estado.numero2 + "."
            )
        }
    }

    private fun enterNumber(number: Int) {
        if(estado.operacion == null) {
            if(estado.numero1.length >= MAX_NUM_LENGTH) {
                return
            }
            estado = estado.copy(
                numero1 = estado.numero1 + number
            )
            return
        }
        if(estado.numero2.length >= MAX_NUM_LENGTH) {
            return
        }
        estado = estado.copy(
            numero2 = estado.numero2 + number
        )
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}