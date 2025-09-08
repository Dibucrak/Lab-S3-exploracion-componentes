@file:OptIn(ExperimentalMaterial3Api::class, androidx.compose.foundation.layout.ExperimentalLayoutApi::class)

package com.example.labs3exploracioncomponentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaAct7()
        }
    }
}

@Composable
fun PantallaAct7() {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Actividad 7 · Black Sabbath",
                        color = Color(0xFF9C27B0),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFF0F0F0F))
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    coroutineScope.launch { snackbarHostState.showSnackbar("FAB presionado") }
                },
                containerColor = Color(0xFF4B0082),
                contentColor = Color.White
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Agregar")
            }
        },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        containerColor = Color.Black
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Color.Black)
                .padding(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Exploración de contenedores y controles",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Icon(Icons.Filled.Favorite, contentDescription = "fav", tint = Color(0xFF9C27B0))
            }
            Spacer(modifier = Modifier.height(12.dp))
            Image(
                painter = painterResource(id = R.drawable.ozzy_randy),
                contentDescription = "Ozzy cargando a Randy Rhoads",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(160.dp)
                    .fillMaxWidth()
                    .background(Color(0xFF111111), RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.height(12.dp))
            DemoContenedoresTema()
            Spacer(modifier = Modifier.height(12.dp))
            DemoControlesTema(snackbarHostState = snackbarHostState)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPantallaAct7() {
    PantallaAct7()
}

@Composable
fun DemoContenedoresTema() {
    Column(modifier = Modifier.fillMaxWidth()) {
        DemoColumnTema()
        Spacer(modifier = Modifier.height(8.dp))
        DemoRowTema()
        Spacer(modifier = Modifier.height(8.dp))
        DemoBoxTema()
        Spacer(modifier = Modifier.height(8.dp))
        DemoLazyColumnTema()
        Spacer(modifier = Modifier.height(8.dp))
        DemoLazyRowTema()
        Spacer(modifier = Modifier.height(8.dp))
        DemoGridTema()
        Spacer(modifier = Modifier.height(8.dp))
        DemoConstraintLayoutTema()
        Spacer(modifier = Modifier.height(8.dp))
        DemoFlowTema()
    }
}

@Preview(showBackground = true, name = "ColumnTema")
@Composable
fun DemoColumnTema() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF111111))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Column — vertical", color = Color.White)
        Text("Item 1", color = Color.White)
        Text("Item 2", color = Color.White)
    }
}

@Preview(showBackground = true, name = "RowTema")
@Composable
fun DemoRowTema() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF111111))
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Row", color = Color.White)
        Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4B0082))) {
            Text("A", color = Color.White)
        }
        Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)) {
            Text("B", color = Color.White)
        }
    }
}

@Preview(showBackground = true, name = "BoxTema")
@Composable
fun DemoBoxTema() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color(0xFF111111)),
        contentAlignment = Alignment.Center
    ) {
        Text("Box — superposición", color = Color.White)
    }
}

@Preview(showBackground = true, name = "LazyColumnTema")
@Composable
fun DemoLazyColumnTema() {
    val lista = List(6) { "Ítem ${it + 1}" }
    LazyColumn(
        modifier = Modifier
            .height(120.dp)
            .background(Color(0xFF111111))
            .padding(6.dp)
    ) {
        items(lista) { it ->
            Text(it, color = Color.White, modifier = Modifier.padding(6.dp))
            Divider(color = Color.DarkGray)
        }
    }
}

@Preview(showBackground = true, name = "LazyRowTema")
@Composable
fun DemoLazyRowTema() {
    val lista = List(8) { "C${it + 1}" }
    LazyRow(
        modifier = Modifier
            .height(80.dp)
            .background(Color(0xFF111111))
            .padding(6.dp)
    ) {
        items(lista) { item ->
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF222222)),
                modifier = Modifier.padding(6.dp)
            ) {
                Text(item, color = Color.White, modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Preview(showBackground = true, name = "GridTema")
@Composable
fun DemoGridTema() {
    val lista = List(6) { "G${it + 1}" }
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .height(160.dp)
            .background(Color(0xFF111111))
            .padding(6.dp)
    ) {
        items(lista) { item ->
            Box(
                modifier = Modifier
                    .padding(6.dp)
                    .background(Color(0xFF222222), RoundedCornerShape(8.dp))
                    .padding(10.dp)
            ) {
                Text(item, color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true, name = "ConstraintLayoutTema")
@Composable
fun DemoConstraintLayoutTema() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF111111))
            .padding(6.dp)
    ) {
        val (a, b, c) = createRefs()
        Text("A", color = Color.White, modifier = Modifier.constrainAs(a) { start.linkTo(parent.start) })
        Text("B", color = Color.White, modifier = Modifier.constrainAs(b) { centerTo(parent) })
        Text("C", color = Color.White, modifier = Modifier.constrainAs(c) { end.linkTo(parent.end) })
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Preview(showBackground = true, name = "FlowTema")
@Composable
fun DemoFlowTema() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF111111))
            .padding(6.dp)
    ) {
        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            repeat(6) {
                Text(
                    "FR${it + 1}",
                    color = Color.White,
                    modifier = Modifier.background(Color(0xFF222222)).padding(6.dp)
                )
            }
        }
        Spacer(Modifier.height(8.dp))
        FlowColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            repeat(4) {
                Text(
                    "FC${it + 1}",
                    color = Color.White,
                    modifier = Modifier.background(Color(0xFF222222)).padding(6.dp)
                )
            }
        }
    }
}

@Composable
fun DemoControlesTema(snackbarHostState: SnackbarHostState) {
    val coroutineScope = rememberCoroutineScope()
    var checked by remember { mutableStateOf(true) }
    var opcion by remember { mutableStateOf("A") }
    var sliderValue by remember { mutableStateOf(0.3f) }
    var switchOn by remember { mutableStateOf(false) }
    var texto by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Selecciona...") }
    val opciones = listOf("Perú", "México", "Chile", "Argentina")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF111111))
            .padding(8.dp)
    ) {
        Text("Controles", color = Color.White, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(6.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it },
                colors = CheckboxDefaults.colors(checkedColor = Color(0xFF4B0082))
            )
            Spacer(Modifier.width(8.dp))
            Text("Checkbox", color = Color.White)
        }
        Spacer(Modifier.height(6.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = opcion == "A",
                onClick = { opcion = "A" },
                colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF4B0082))
            )
            Text("A", color = Color.White)
            Spacer(Modifier.width(12.dp))
            RadioButton(
                selected = opcion == "B",
                onClick = { opcion = "B" },
                colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF4B0082))
            )
            Text("B", color = Color.White)
        }
        Spacer(Modifier.height(6.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Switch", color = Color.White)
            Spacer(Modifier.width(8.dp))
            Switch(
                checked = switchOn,
                onCheckedChange = { switchOn = it },
                colors = SwitchDefaults.colors(checkedThumbColor = Color(0xFF4B0082))
            )
        }
        Spacer(Modifier.height(8.dp))
        Text("Slider", color = Color.White)
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            colors = SliderDefaults.colors(thumbColor = Color(0xFF9C27B0), activeTrackColor = Color(0xFF4B0082))
        )
        LinearProgressIndicator(progress = sliderValue, color = Color(0xFF4B0082))
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = texto,
            onValueChange = { texto = it },
            label = { Text("Texto", color = Color(0xFF9C27B0)) },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color(0xFF9C27B0),
                unfocusedIndicatorColor = Color.Gray,
                focusedContainerColor = Color(0xFF0A0A0A),
                unfocusedContainerColor = Color(0xFF0A0A0A),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                value = selectedOption,
                onValueChange = {},
                readOnly = true,
                label = { Text("País", color = Color.White) },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color(0xFF9C27B0),
                    unfocusedIndicatorColor = Color.Gray,
                    focusedContainerColor = Color(0xFF0A0A0A),
                    unfocusedContainerColor = Color(0xFF0A0A0A),
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                opciones.forEach { opt ->
                    DropdownMenuItem(text = { Text(opt) }, onClick = {
                        selectedOption = opt
                        expanded = false
                    })
                }
            }
        }
        Spacer(Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(
                onClick = {
                    coroutineScope.launch { snackbarHostState.showSnackbar("Acción ejecutada") }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4B0082))
            ) {
                Text("Mostrar Snackbar", color = Color.White)
            }
            Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)) {
                Text("Otra", color = Color.White)
            }
        }
        Spacer(Modifier.height(8.dp))
        TabRow(selectedTabIndex = 0, containerColor = Color(0xFF111111)) {
            Tab(selected = true, onClick = {}, text = { Text("T1", color = Color.White) })
            Tab(selected = false, onClick = {}, text = { Text("T2", color = Color.White) })
        }
        Spacer(Modifier.height(8.dp))
        Card(colors = CardDefaults.cardColors(containerColor = Color(0xFF111111))) {
            Column(modifier = Modifier.padding(8.dp)) {
                Text("Card", color = Color.White)
                Divider(color = Color.DarkGray)
                Text("Contenido de la tarjeta", color = Color.White)
            }
        }
        Spacer(Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            CircularProgressIndicator(color = Color(0xFF4B0082))
            Spacer(modifier = Modifier.width(8.dp))
            Text("Cargando...", color = Color.White)
        }
    }
}
