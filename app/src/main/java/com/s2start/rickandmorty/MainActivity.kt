package com.s2start.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.s2start.rickandmorty.ui.theme.RickAndMortyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Screen()
        }
    }
}




@Composable
fun ListCharacter() {
    val (search,setSearch) = remember {
        mutableStateOf(TextFieldValue(""))
    }

    LazyColumn {
        item {
            TextField(
                value = search,
                onValueChange = setSearch,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .border(1.dp, Color.Gray, RoundedCornerShape(3.dp)),
                placeholder = { Text(text = "Buscar")},

                )

        }
        item {

            var expandedState by remember { mutableStateOf(false) }

            val rotationState by animateFloatAsState(
                targetValue = if (expandedState) 180f else 0f, label = ""
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize(
                        animationSpec = tween(
                            durationMillis = 300,
                            easing = LinearOutSlowInEasing
                        )
                    )
                    .padding(12.dp),
                shape = RoundedCornerShape(10.dp),
                onClick = {
                   expandedState = !expandedState
                }
            ) {
                Row(Modifier) {
                    AsyncImage(
                        model = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                        contentDescription = null,
                        placeholder = painterResource(id = R.drawable.ic_back),
                        modifier = Modifier.size(50.dp)
                    )

                    Column (Modifier.padding(start = 10.dp)){
                        Text(
                            text = "Rick Sanchez C-137",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                        Text(
                            text = "Human - Alive",
                            fontWeight = FontWeight.Light,
                            fontSize = 12.sp
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(
                        modifier = Modifier
                            .alpha(0.2f)
                            .rotate(rotationState),
                        onClick = {
                            expandedState = !expandedState
                        }) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Drop-Down Arrow"
                        )
                    }
                }
                if (expandedState) {
                    Column(Modifier.padding(20.dp)) {
                        Row (verticalAlignment = Alignment.CenterVertically){
                            Text(
                                text = "Status: ",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp
                            )
                            Text(
                                text = "Vivo",
                                fontWeight = FontWeight.Light,
                                fontSize = 12.sp
                            )
                        }

                        Row (verticalAlignment = Alignment.CenterVertically){
                            Text(
                                text = "Sexo: ",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp
                            )
                            Text(
                                text = "Homem",
                                fontWeight = FontWeight.Light,
                                fontSize = 12.sp
                            )
                        }

                        Row (verticalAlignment = Alignment.CenterVertically){
                            Text(
                                text = "Idade: ",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp
                            )
                            Text(
                                text = "70 anos",
                                fontWeight = FontWeight.Light,
                                fontSize = 12.sp
                            )
                        }

                        Row (verticalAlignment = Alignment.CenterVertically){
                            Text(
                                text = "Origem: ",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp
                            )
                            Text(
                                text = "Seattle",
                                fontWeight = FontWeight.Light,
                                fontSize = 12.sp
                            )
                        }

                    }
                }
            }
        }
        item {

            var expandedState by remember { mutableStateOf(false) }

            val rotationState by animateFloatAsState(
                targetValue = if (expandedState) 180f else 0f, label = ""
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize(
                        animationSpec = tween(
                            durationMillis = 300,
                            easing = LinearOutSlowInEasing
                        )
                    )
                    .padding(12.dp),
                shape = RoundedCornerShape(10.dp),
                onClick = {
                    expandedState = !expandedState
                }
            ) {
                Row(Modifier) {
                    AsyncImage(
                        model = "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
                        contentDescription = null,
                        placeholder = painterResource(id = R.drawable.ic_back),
                        modifier = Modifier.size(50.dp)
                    )

                    Column (Modifier.padding(start = 10.dp)){
                        Text(
                            text = "Morty Smith",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                        Text(
                            text = "Human - Alive",
                            fontWeight = FontWeight.Light,
                            fontSize = 12.sp
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(
                        modifier = Modifier
                            .alpha(0.2f)
                            .rotate(rotationState),
                        onClick = {
                            expandedState = !expandedState
                        }) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Drop-Down Arrow"
                        )
                    }
                }
                if (expandedState) {
                    Column(Modifier.padding(20.dp)) {
                        Row (verticalAlignment = Alignment.CenterVertically){
                            Text(
                                text = "Status: ",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp
                            )
                            Text(
                                text = "Vivo",
                                fontWeight = FontWeight.Light,
                                fontSize = 12.sp
                            )
                        }

                        Row (verticalAlignment = Alignment.CenterVertically){
                            Text(
                                text = "Sexo: ",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp
                            )
                            Text(
                                text = "Homem",
                                fontWeight = FontWeight.Light,
                                fontSize = 12.sp
                            )
                        }

                        Row (verticalAlignment = Alignment.CenterVertically){
                            Text(
                                text = "Idade: ",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp
                            )
                            Text(
                                text = "14 anos",
                                fontWeight = FontWeight.Light,
                                fontSize = 12.sp
                            )
                        }

                        Row (verticalAlignment = Alignment.CenterVertically){
                            Text(
                                text = "Origem: ",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp
                            )
                            Text(
                                text = "Seattle",
                                fontWeight = FontWeight.Light,
                                fontSize = 12.sp
                            )
                        }

                    }
                }
            }
        }
        item {

            var expandedState by remember { mutableStateOf(false) }

            val rotationState by animateFloatAsState(
                targetValue = if (expandedState) 180f else 0f, label = ""
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize(
                        animationSpec = tween(
                            durationMillis = 300,
                            easing = LinearOutSlowInEasing
                        )
                    )
                    .padding(12.dp),
                shape = RoundedCornerShape(10.dp),
                onClick = {
                    expandedState = !expandedState
                }
            ) {
                Row(Modifier) {
                    AsyncImage(
                        model = "https://rickandmortyapi.com/api/character/avatar/5.jpeg",
                        contentDescription = null,
                        placeholder = painterResource(id = R.drawable.ic_back),
                        modifier = Modifier.size(50.dp)
                    )

                    Column (Modifier.padding(start = 10.dp)){
                        Text(
                            text = "Jerry Smith",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                        Text(
                            text = "Human - Alive",
                            fontWeight = FontWeight.Light,
                            fontSize = 12.sp
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(
                        modifier = Modifier
                            .alpha(0.2f)
                            .rotate(rotationState),
                        onClick = {
                            expandedState = !expandedState
                        }) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Drop-Down Arrow"
                        )
                    }
                }
                if (expandedState) {
                    Column(Modifier.padding(20.dp)) {
                        Row (verticalAlignment = Alignment.CenterVertically){
                            Text(
                                text = "Status: ",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp
                            )
                            Text(
                                text = "Vivo",
                                fontWeight = FontWeight.Light,
                                fontSize = 12.sp
                            )
                        }

                        Row (verticalAlignment = Alignment.CenterVertically){
                            Text(
                                text = "Sexo: ",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp
                            )
                            Text(
                                text = "Homem",
                                fontWeight = FontWeight.Light,
                                fontSize = 12.sp
                            )
                        }

                        Row (verticalAlignment = Alignment.CenterVertically){
                            Text(
                                text = "Idade: ",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp
                            )
                            Text(
                                text = "35 anos",
                                fontWeight = FontWeight.Light,
                                fontSize = 12.sp
                            )
                        }

                        Row (verticalAlignment = Alignment.CenterVertically){
                            Text(
                                text = "Origem: ",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp
                            )
                            Text(
                                text = "seattle",
                                fontWeight = FontWeight.Light,
                                fontSize = 12.sp
                            )
                        }

                    }
                }
            }
        }

        }
        }







@Preview("List Rick")
@Composable
fun Screen(){
    RickAndMortyTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column (Modifier.padding(innerPadding)){
                ListCharacter()
            }
        }
    }
}
