package mx.edu.uthermosillo.apps.renecastro.proyecto_final

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView

class PrincipalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_principal, container, false)

        // Acceder al BottomNavigationView desde el diseño del fragmento
        val bottomNavigationView: BottomNavigationView = v.findViewById(R.id.bottomNavigationView)

        // Manejar las selecciones del BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.mpassword -> {
                    // Acción para el primer ítem
                    PriD(v)
                    true
                }
                R.id.msecurity -> {
                    // Acción para el segundo ítem
                    RegC(v)
                    true
                }
                R.id.mexit -> {
                    // Acción para el tercer ítem
                    PriL(v)
                    true
                }
                // Agrega más casos según sea necesario
                else -> false
            }
        }

        return v
    }

    private fun PriD(view: View) {
        val controller: NavController = Navigation.findNavController(view)
        controller.navigate(R.id.action_principalFragment_to_detallesFragment)
    }

    private fun RegC(view: View) {
        val controller: NavController = Navigation.findNavController(view)
        controller.navigate(R.id.action_principalFragment_to_consejosFragment)
    }

    private fun PriL(view: View) {
        val controller: NavController = Navigation.findNavController(view)
        controller.navigate(R.id.action_principalFragment_to_loginFragment)
    }
}