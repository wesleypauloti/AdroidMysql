package com.example.androidmysql

data class User(
    var userId: String?,
    val name: String?,
    val email: String?,
    val password: String?
) {
    // Construtor sem argumentos exigido pelo Firebase
    constructor() : this("", "", "", "")
}
