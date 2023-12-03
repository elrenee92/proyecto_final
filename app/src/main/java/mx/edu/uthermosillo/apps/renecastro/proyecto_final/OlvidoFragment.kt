package mx.edu.uthermosillo.apps.renecastro.proyecto_final

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation

class OlvidoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_olvido, container, false)

        val user = v.findViewById<EditText>(R.id.usuario)
        val email = v.findViewById<EditText>(R.id.email)
        val password_n = v.findViewById<EditText>(R.id.contrasena_n)
        val password_c = v.findViewById<EditText>(R.id.confirmar_c)
        val button = v.findViewById<Button>(R.id.recuperar)

        val volver_l = v.findViewById<Button>(R.id.volver)

        button.setOnClickListener {
            val userText = user.text.toString()
            val emailText = email.text.toString()
            val passwordNew = password_n.text.toString()
            val confirmPassword = password_c.text.toString()

            if (userText.isNotBlank() && emailText.isNotBlank() && passwordNew.isNotBlank() && confirmPassword.isNotBlank()) {
                if (passwordNew == confirmPassword) {
                    Toast.makeText(context, "Se ha enviado un correo electrónico para confirmar la nueva contraseña", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Registro Incompleto", Toast.LENGTH_SHORT).show()
            }
        }

        volver_l.setOnClickListener {
            volver_l(it)
        }

        return v
    }

        private fun volver_l(view: View) {
            val controller: NavController = Navigation.findNavController(view)
            controller.navigate(R.id.action_olvidoFragment_to_loginFragment)
        }
}