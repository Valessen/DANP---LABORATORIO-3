package com.example.byrnemaciasvalery_lab3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.byrnemaciasvalery_lab3.ui.theme.ByrneMaciasValeryLab3Theme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ByrneMaciasValeryLab3Theme {
                val congreso= remember { mutableStateListOf<Asistente>()
                }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box (modifier = Modifier.fillMaxSize()){

                        CRUD(congreso)
                    }
                }
            }
        }
    }
}

@Composable
fun CRUD( congreso: MutableList<Asistente>){

    var nombre by remember { mutableStateOf("") }
    var apellidoP by remember { mutableStateOf("") }
    var apellidoM by remember { mutableStateOf("") }
    var fechaInscripcion by remember { mutableStateOf("") }
    var tipoSangre by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var montopagado by remember { mutableStateOf(0.0) }

    var isEditando by remember { mutableStateOf(false) }
    var textButton by remember { mutableStateOf("Agregar Asistente") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(12.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(395.dp)
        ) {
            Formulario (
                nombre = nombre,
                funNombre = {nombre = it},
                apellidoPat = apellidoP,
                funapellidoPat = {apellidoP = it},
                apellidoMat = apellidoM,
                funapellidoMat = {apellidoM = it},
                fechaInscrip = fechaInscripcion,
                funfechaInscrip = {fechaInscripcion = it},
                tipoDeSangre = tipoSangre,
                funtipoDeSangre = {tipoSangre = it},
                telefono = telefono,
                funtelefono = {telefono = it},
                correo = correo,
                funcorreo = {correo = it},
                montopagado = montopagado,
                funmontopagado = {montopagado = it},
                isEdit = isEditando,
                funisEdit = {isEditando = false},
                textButton = textButton,
                funtextButton = {textButton = it},

                congreso=congreso,
                funResetCampos = {
                    nombre = ""
                    apellidoP = ""
                    apellidoM = ""
                    fechaInscripcion = ""
                    tipoSangre = ""
                    telefono = " "
                    correo = ""
                    montopagado = 0.0
                }
            )

        }
        Column (modifier= Modifier.fillMaxSize()){
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                items(congreso) { asistente ->
                    MostrarAsistente(
                        funNombre = {nombre = it} ,
                        funapellidoPat = {apellidoP = it},
                        funapellidoMat = {apellidoM = it},
                        funfechaInscrip = {fechaInscripcion = it},
                        funtipoDeSangre = {tipoSangre = it},
                        funtelefono = {telefono = it},
                        funcorreo = {correo = it},
                        funmontopagado = {montopagado = it},

                        funTextButton = {textButton = it} ,
                        funIsEditando = {isEditando = it} ,
                        funBorrarAsistente = { borrarAsistente(it, congreso)} ,
                        asistente=asistente
                    )
                }
            }
        }
    }
}

fun agregarAsistente(nombre:String , apellidoP:String, apellidoM: String, fechaInscripcion: String,
                         tipoSangre: String, telefono: String, correo: String, montoPagado: Double,
                     congreso: MutableList<Asistente>){
    congreso.add(Asistente(nombre,apellidoP,apellidoM,fechaInscripcion,tipoSangre,telefono,correo,montoPagado))
}

fun editarAsistente(nombre:String , apellidoP:String, apellidoM: String, fechaInscripcion: String,
                    tipoSangre: String, telefono: String, correo: String, montoPagado: Double,
                    congreso: MutableList<Asistente>){

    congreso.forEach{ asistente ->
        if (asistente.nombre == nombre){
            asistente.apellidoPat= apellidoP
            asistente.apellidoMat= apellidoM
            asistente.fechaInscrip= fechaInscripcion
            asistente.tipoDeSangre= tipoSangre
            asistente.telefono= telefono
            asistente.correo= correo
            asistente.montopagado= montoPagado
        }
    }
}

fun borrarAsistente(nombre:String , congreso: MutableList<Asistente>){
    congreso.forEach{ asistente ->
        if (asistente.nombre == nombre){
            congreso.remove(asistente)
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Pruebita $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ByrneMaciasValeryLab3Theme {
        Greeting("Hola")
    }
}