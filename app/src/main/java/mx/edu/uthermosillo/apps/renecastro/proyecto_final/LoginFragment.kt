package mx.edu.uthermosillo.apps.renecastro.proyecto_final

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation

class LoginFragment : Fragment() {

    private var users: List<User> = emptyList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_login, container, false)

        val user = v.findViewById<EditText>(R.id.usuario)
        val password = v.findViewById<EditText>(R.id.contrasena)
        val button = v.findViewById<Button>(R.id.ingresar)

        val olvido = v.findViewById<TextView>(R.id.contrasena_olvidada)
        val nuevo_u = v.findViewById<TextView>(R.id.nuevo_usuario)

        button.setOnClickListener{
            ingreso()

            if(user.text != null && password.text != null) {

                val email = user.text.toString()
                val pass = password.text.toString()

                if(checkUser(email, pass, users)){
                    Toast.makeText(context,"Login Correcto", Toast.LENGTH_SHORT)
                        .show()

                    val controller: NavController = Navigation.findNavController(it)
                    controller.navigate(R.id.principalFragment)

                } else {
                    Toast.makeText(context,
                        "Las credenciales no coinciden",
                        Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(
                    context,
                    "Ambos campos son requeridos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        olvido.setOnClickListener{
            olvido(it)
        }

        nuevo_u.setOnClickListener{
            nuevo_u(it)
        }

        return v
    }

    private fun checkUser(username: String, password: String,
                          users: List<User>): Boolean {
        return users.any { user ->
            username == user.email && password == user.password
        }
    }
    private fun ingreso(){
        users = listOf(
            User(1, "Rene Castro", "123"),
            User(2, "Javier Romo", "123"),
            User(3, "Alan Ortiz", "123"),
        )
    }
    private fun olvido(view: View){
        val controller: NavController = Navigation.findNavController(view)
        controller.navigate(R.id.action_loginFragment_to_olvidoFragment)
    }
    private fun nuevo_u(view: View){
        val controller: NavController = Navigation.findNavController(view)
        controller.navigate(R.id.action_loginFragment_to_registroFragment)
    }
}

