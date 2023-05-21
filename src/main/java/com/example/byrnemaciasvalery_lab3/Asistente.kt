package com.example.byrnemaciasvalery_lab3

class Asistente {
    var nombre: String =""
    var apellidoPat: String = ""
    var apellidoMat: String = ""
    var fechaInscrip: String = ""
    var tipoDeSangre: String = ""
    var telefono: String = ""
    var correo: String = ""
    var montopagado: Double = 0.0

    constructor(
        nombre: String,
        apellidoPat: String,
        apellidoMat: String,
        fechaInscrip: String,
        tipoDeSangre: String,
        telefono: String,
        correo: String,
        montopagado: Double
    ) {
        this.nombre = nombre
        this.apellidoPat = apellidoPat
        this.apellidoMat = apellidoMat
        this.fechaInscrip = fechaInscrip
        this.tipoDeSangre = tipoDeSangre
        this.telefono = telefono
        this.correo = correo
        this.montopagado = montopagado
    }
}