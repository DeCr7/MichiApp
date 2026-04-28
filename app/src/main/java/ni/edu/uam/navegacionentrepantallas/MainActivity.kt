package ni.edu.uam.navegacionentrepantallas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
                .height(360.dp)
        )

        Text(
            text = "¡La Red Social Gatuna #1!",
            modifier = Modifier.padding(top = 8.dp, bottom = 20.dp),
        )

        Button(
            onClick = {
                navController.navigate("detalle")
            }
        ) {
            Text("Ir al Feed de Hoy")
        }
    }
}

@Composable
fun PantallaDetalle(navController: NavController) {

    val publicaciones = listOf(
        R.drawable.gato1,
        R.drawable.gato2,
        R.drawable.gato3,
        R.drawable.gato4,
        R.drawable.gato5,
        R.drawable.gato6,
        R.drawable.gato7,
        R.drawable.gato8,
        R.drawable.gato9,
        R.drawable.gato10,
        R.drawable.gato11,
        R.drawable.gato12,
        R.drawable.gato13,
        R.drawable.gato14,
        R.drawable.gato15
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFE3F2FD),
                        Color(0xFFBBDEFB),
                        Color.White
                    )
                )
            )
            .padding(16.dp)
    ) {
        item {
            Text(
                text = "Feed Gatuno 🐱",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Button(
                onClick = { navController.navigate("perfil") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ir a tu Perfil")
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

        items(publicaciones) { imagen ->
            Publicacion(imagen)
        }
    }
}

@Composable
fun Publicacion(imagen: Int) {

    var rating by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Image(
            painter = painterResource(id = imagen),
            contentDescription = "Gato",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Michi publicando 🐱",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            for (i in 1..5) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Estrella $i",
                    tint = if (i <= rating)
                        MaterialTheme.colorScheme.primary
                    else
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
                    modifier = Modifier
                        .size(32.dp)
                        .clickable {
                            rating = i
                        }
                )
            }
        }
    }
}

@Composable
fun PantallaPerfil(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFF3E5F5),
                        Color(0xFFE1BEE7),
                        Color.White
                    )
                )
            )
            .verticalScroll(rememberScrollState())
            .padding(16.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Perfil de Leo 🐱",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = painterResource(id = R.drawable.catface),
            contentDescription = "Foto de perfil",
            modifier = Modifier
                .size(140.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
                text = "Leo",
                style = MaterialTheme.typography.titleLarge
            )

        Spacer(modifier = Modifier.height(12.dp))

        Text("Analista de Software")
        Text("Apasionado por el senderismo y pelear en los techos a las 3 AM")

        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = painterResource(id = R.drawable.diagrama),
            contentDescription = "Publicación destacada",
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { }
        ) {
            Text("🔄 Compartir Perfil")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                navController.navigate("inicio")
            }
        ) {
            Text("Volver al Inicio")
        }
    }
}