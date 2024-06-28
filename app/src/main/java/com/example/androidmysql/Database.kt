package com.example.androidmysql

import java.sql.Connection
import java.sql.DriverManager

object Database {
    private const val URL = "jdbc:mysql://192.168.18.119:3306:3306/login"
    private const val USER = "root"
    private const val PASSWORD = ""

    fun getConnection(): Connection {
        return DriverManager.getConnection(URL, USER, PASSWORD)
    }
}
