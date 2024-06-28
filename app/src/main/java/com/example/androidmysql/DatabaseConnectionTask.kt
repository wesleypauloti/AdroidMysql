package com.example.androidmysql

import android.os.AsyncTask
import java.sql.Connection
import java.sql.SQLException

class DatabaseConnectionTask(private val user: User) : AsyncTask<Void, Void, Connection>() {
    override fun doInBackground(vararg params: Void?): Connection {
        return Database.getConnection()
    }

    override fun onPostExecute(connection: Connection?) {
        if (connection != null) {
            try {
                val statement = connection.prepareStatement("INSERT INTO users (userId, name, email, password) VALUES (?, ?, ?, ?)")
                statement.setString(1, user.userId)
                statement.setString(2, user.name)
                statement.setString(3, user.email)
                statement.setString(4, user.password)
                statement.executeUpdate()
                statement.close()
            } catch (e: SQLException) {
                e.printStackTrace()
            } finally {
                try {
                    connection.close()
                } catch (e: SQLException) {
                    e.printStackTrace()
                }
            }
        } else {
            // Handle the case where connection is null
        }
    }
}
