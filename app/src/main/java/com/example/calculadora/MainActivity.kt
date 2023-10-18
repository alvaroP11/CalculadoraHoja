package com.example.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculadora.ui.theme.CalculadoraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraTheme {
                val viewModel = viewModel<CalculadoraViewModel>()
                val estado = viewModel.estado
                val espaciadoBotones = 8.dp
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(id = (R.color.Dark_Brown)))
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter),
                    verticalArrangement = Arrangement.spacedBy(espaciadoBotones),
                ) {
                    Text(
                        text = estado.numero1 + (estado.operacion?.symbol ?: "") + estado.numero2,
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 32.dp),
                        fontWeight = FontWeight.Light,
                        fontSize = 80.sp,
                        color = Color.White,
                        maxLines = 2
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(espaciadoBotones)
                    ) {
                        BotonCalculadora(
                            symbol = "AC",
                            color = colorResource(id = (R.color.Fall_Red)),
                            modifier = Modifier
                                .aspectRatio(2f)
                                .weight(2f)
                        ) {
                            viewModel.onAction(AccionCalculadora.Limpiar)
                        }
                        BotonCalculadora(
                            symbol = "Del",
                            color = colorResource(id = (R.color.Fall_Red)),
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(AccionCalculadora.Borrar)
                        }
                        BotonCalculadora(
                            symbol = "/",
                            color = colorResource(id = (R.color.Fall_Brown)),
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(AccionCalculadora.Operacion(OperacionCalculadora.Division))
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(espaciadoBotones)
                    ) {
                        BotonCalculadora(
                            symbol = "7",
                            color = colorResource(id = (R.color.Fall_Green)),
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(AccionCalculadora.Numero(7))
                        }
                        BotonCalculadora(
                            symbol = "8",
                            color = colorResource(id = (R.color.Fall_Orange)),
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(AccionCalculadora.Numero(8))
                        }
                        BotonCalculadora(
                            symbol = "9",
                            color = colorResource(id = (R.color.Fall_Orange)),
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(AccionCalculadora.Numero(9))
                        }
                        BotonCalculadora(
                            symbol = "x",
                            color = colorResource(id = (R.color.Fall_Brown)),
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(AccionCalculadora.Operacion(OperacionCalculadora.Multiplicacion))
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(espaciadoBotones)
                    ) {
                        BotonCalculadora(
                            symbol = "4",
                            color = colorResource(id = (R.color.Fall_Orange)),
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(AccionCalculadora.Numero(4))
                        }
                        BotonCalculadora(
                            symbol = "5",
                            color = colorResource(id = (R.color.Fall_Green)),
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(AccionCalculadora.Numero(5))
                        }
                        BotonCalculadora(
                            symbol = "6",
                            color = colorResource(id = (R.color.Fall_Orange)),
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(AccionCalculadora.Numero(6))
                        }
                        BotonCalculadora(
                            symbol = "-",
                            color = colorResource(id = (R.color.Fall_Brown)),
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(AccionCalculadora.Operacion(OperacionCalculadora.Resta))
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(espaciadoBotones)
                    ) {
                        BotonCalculadora(
                            symbol = "1",
                            color = colorResource(id = (R.color.Fall_Green)),
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(AccionCalculadora.Numero(1))
                        }
                        BotonCalculadora(
                            symbol = "2",
                            color = colorResource(id = (R.color.Fall_Green)),
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(AccionCalculadora.Numero(2))
                        }
                        BotonCalculadora(
                            symbol = "3",
                            color = colorResource(id = (R.color.Fall_Green)),
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(AccionCalculadora.Numero(3))
                        }
                        BotonCalculadora(
                            symbol = "+",
                            color = colorResource(id = (R.color.Fall_Brown)),
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(AccionCalculadora.Operacion(OperacionCalculadora.Suma))
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(espaciadoBotones)
                    ) {
                        BotonCalculadora(
                            symbol = "0",
                            color = colorResource(id = (R.color.Fall_Green)),
                            modifier = Modifier
                                .aspectRatio(2f)
                                .weight(2f)
                        ) {
                            viewModel.onAction(AccionCalculadora.Numero(0))
                        }
                        BotonCalculadora(
                            symbol = ".",
                            color = colorResource(id = (R.color.Fall_Orange)),
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        ) {
                            viewModel.onAction(AccionCalculadora.Decimal)
                        }
                        BotonCalculadora(
                            symbol = "=",
                            color = colorResource(id = (R.color.Fall_Red)),
                            modifier = Modifier
                                .aspectRatio(1f)
                                .weight(1f)
                        )   {
                            viewModel.onAction(AccionCalculadora.Calcular)
                            }
                        }
                    }
                }
            }
        }
    }
}

