package mx.edu.uthermosillo.apps.renecastro.proyecto_final

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation

class DetallesFragment : Fragment() {

    private var users: List<User> = emptyList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_detalles, container, false)

        val volver = v.findViewById<TextView>(R.id.volver)

        volver.setOnClickListener{
            volver(it)
        }

        return v
    }

    private fun volver(view: View){
        val controller: NavController = Navigation.findNavController(view)
        controller.navigate(R.id.action_detallesFragment_to_principalFragment)
    }

}