package mx.edu.uthermosillo.apps.renecastro.proyecto_final

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation

class RegistroFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_registro, container, false)

        val user = v.findViewById<EditText>(R.id.usuario)
        val password = v.findViewById<EditText>(R.id.contrasena)
        val button = v.findViewById<Button>(R.id.recuperar)

        val volver_l = v.findViewById<Button>(R.id.volver)

        button.setOnClickListener {
            val userText = user.text.toString()
            val passwordText = password.text.toString()

            if (userText.isNotBlank() && passwordText.isNotBlank()) {
                // Aquí realizarías el registro del usuario
                Toast.makeText(context, "Registro Correcto", Toast.LENGTH_SHORT).show()
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
        controller.navigate(R.id.action_registroFragment_to_loginFragment)
    }
}