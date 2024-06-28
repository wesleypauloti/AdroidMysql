package com.example.androidmysql

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSignup = findViewById<Button>(R.id.btnSignup)
        val btnBack = findViewById<Button>(R.id.btnBack)
        val etName = findViewById<EditText>(R.id.editName)
        val etEmail = findViewById<EditText>(R.id.editEmail)
        val etPassword = findViewById<EditText>(R.id.editPassword)
        val etPassword2 = findViewById<EditText>(R.id.editPassword2)

        btnSignup.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val password2 = etPassword2.text.toString()

            if (name.isNotEmpty() && password.isNotEmpty() && password2.isNotEmpty()) {
                if (name.length < 3) {
                    Toast.makeText(
                        baseContext,
                        "Mínimo de 3 caracteres para o Nome",
                        Toast.LENGTH_LONG
                    ).show()
                } else if (!name.matches(Regex("[\\p{IsLatin}]+( [\\p{IsLatin}]+)*"))) {
                    Toast.makeText(
                        baseContext,
                        "Nome Inválido, digite somente letras",
                        Toast.LENGTH_LONG
                    ).show()
                } else if (password.length < 6) {
                    Toast.makeText(
                        baseContext,
                        "Mínimo de 6 caracteres para a Senha",
                        Toast.LENGTH_LONG
                    ).show()
                } else if (password != password2) {
                    Toast.makeText(baseContext, "Senhas não coincidem", Toast.LENGTH_LONG).show()
                } else {
                    val userId = ""
                    val newUser = User(userId, name, email, password)

                    DatabaseConnectionTask(newUser).execute()

                    Toast.makeText(baseContext, "Cadastrado", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(baseContext, "Preencha todos os Campos", Toast.LENGTH_SHORT).show()
            }
        }



        btnBack.setOnClickListener {
            finish()
        }
    }
}