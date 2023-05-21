package com.example.byrnemaciasvalery_lab3

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MostrarAsistente(
    funNombre : (String) -> Unit,
    funapellidoPat : (String) -> Unit,
    funapellidoMat : (String) -> Unit,
    funfechaInscrip : (String) -> Unit,
    funtipoDeSangre : (String) -> Unit,
    funtelefono : (String) -> Unit,
    funcorreo : (String) -> Unit,
    funmontopagado : (Double) -> Unit,

    funTextButton : (String) -> Unit ,
    funIsEditando : (Boolean) -> Unit ,
    funBorrarAsistente : (String) -> Unit ,
    asistente : Asistente
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = 8.dp
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp), Arrangement.Center) {
            Text(text = asistente.nombre, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = asistente.apellidoPat, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = asistente.apellidoMat, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = asistente.fechaInscrip, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = asistente.tipoDeSangre, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = asistente.telefono, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = asistente.correo, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = asistente.montopagado.toString(), modifier = Modifier.align(Alignment.CenterHorizontally))
            Row(modifier = Modifier.fillMaxWidth()) {
                Button(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                    onClick = {
                        funNombre(asistente.nombre)
                        funapellidoPat(asistente.apellidoPat)
                        funapellidoMat(asistente.apellidoMat)
                        funfechaInscrip(asistente.fechaInscrip)
                        funtipoDeSangre(asistente.tipoDeSangre)
                        funtelefono(asistente.telefono)
                        funcorreo(asistente.correo)
                        funmontopagado(asistente.montopagado)

                        funTextButton("Editar Usuario")
                        funIsEditando(true)
                    }
                ){
                    Text(text = "Editar", color = Color.White)
                }

                Button(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                    onClick = {
                        funBorrarAsistente(asistente.nombre)
                    }
                ){
                    Text(text = "Borrar", color = Color.White)
                }

            }
        }
    }
}