package ni.edu.uam.navegacionentrepantallas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ni.edu.uam.navegacionentrepantallas.ui.theme.NavegacionEntrePantallasTheme
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            NavegacionEntrePantallasTheme {
                AppNavegacion()
            }
        }
    }
}

@Composable
fun AppNavegacion() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "inicio"
    ) {

        composable("inicio") {
            PantallaInicio(navController)
        }

        composable("detalle") {
            PantallaDetalle(navController)
        }

        composable("perfil") {
            PantallaPerfil(navController)
        }
    }
}

@Composable
fun PantallaInicio(navController: NavController) {

    Column(
        modifier = Modifier.background(
            Brush.verticalGradient(
                colors = listOf(
                    Color(0xFFFFF8E1),
                    Color(0xFFFFE0B2),
                    Color(0xFFFFFFFF)
                )
            )
        )
            .fillMaxSize()
            .padding(20.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.michiapplogo),
            contentDescription = "Logo MichiApp",
            modifier = Modifier
                .height(80.dp)
        )

        Text(
            text = "¡Bienvenido a la red social #1 para mininos!",
            modifier = Modifier.padding(top = 8.dp, bottom = 20.dp)
        )

        Button(
            onClick = {
                navController.navigate("detalle")
            }
        ) {
            Text("Ir a Detalle")
        }
    }
}

@Composable
fun PantallaDetalle(navController: NavController) {

    Column(
        modifier = Modifier.background(
            Brush.verticalGradient(
                colors = listOf(
                    Color(0xFFE3F2FD),
                    Color(0xFFBBDEFB),
                    Color(0xFFFFFFFF)
                )
            )
        )
            .fillMaxSize()
            .padding(20.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Pantalla Detalle",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Aquí va información importante.",
            modifier = Modifier.padding(top = 8.dp, bottom = 20.dp)
        )

        Button(
            onClick = {
                navController.navigate("perfil")
            }
        ) {
            Text("Ir a Perfil")
        }
    }
}

@Composable
fun PantallaPerfil(navController: NavController) {

    Column(
        modifier = Modifier.background(
            Brush.verticalGradient(
                colors = listOf(
                    Color(0xFFF3E5F5),
                    Color(0xFFE1BEE7),
                    Color(0xFFFFFFFF)
                )
            )
        )
            .fillMaxSize()
            .padding(20.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Pantalla Perfil",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Nombre: Usuario Demo",
            modifier = Modifier.padding(top = 8.dp)
        )

        Text(
            text = "Resumen de información",
            modifier = Modifier.padding(bottom = 20.dp)
        )

        Button(
            onClick = {
                navController.navigate("inicio")
            }
        ) {
            Text("Volver al Inicio")
        }
    }
}