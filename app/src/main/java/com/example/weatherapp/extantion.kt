package com.example.weatherapp

fun Float.toC (): String {
    return "${(this-273).toInt()}c"
}

fun Float.tom ():String{
    return "$this %"
}

fun Float.toKM():String{
    return "$this km/h"
}