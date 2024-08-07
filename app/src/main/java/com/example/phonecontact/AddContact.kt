package com.example.phonecontact
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun Add(navController: NavHostController, contactViewModel: ContactViewModel  = viewModel()) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        TextField(value =firstName ,
            onValueChange = {firstName= it},
            placeholder = {
                Text(
                    "First Name",
                )
            }
        )
        Spacer(modifier = Modifier.padding(16.dp))
        TextField(value =lastName ,
            onValueChange = {lastName= it},
            placeholder = {Text( "Last Name")}
        )
        Spacer(modifier = Modifier.padding(16.dp))
        TextField(value =phoneNumber ,
            onValueChange = {phoneNumber= it},
            placeholder = {Text( "Phone number")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Button(
            onClick = {
                val newContact = Contact(firstName,lastName,phoneNumber)
                contactViewModel.addContact(newContact)
            },
            modifier = Modifier
                .width(95.dp)

            ) {
            Text(text = "Add")
        }
        Spacer(modifier = Modifier.padding(7.dp))
        Text(
            "Contact",
            modifier = Modifier.clickable { navController.navigate("contact") }
        )

    }


}
@Preview(showBackground = true)
@Composable
fun AddPriview(){

}
