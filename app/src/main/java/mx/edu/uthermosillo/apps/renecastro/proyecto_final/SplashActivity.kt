package mx.edu.uthermosillo.apps.renecastro.proyecto_final

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logo = findViewById<ImageView>(R.id.logo);

        Handler().postDelayed({
            val i = Intent(this, AuthActivity::class.java)
            startActivity(i)
            finish()
        }, 5000)
    }

}