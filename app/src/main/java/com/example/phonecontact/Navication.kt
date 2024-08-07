package com.example.phonecontact

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Nav(){
    val navController = rememberNavController()
    val contactViewModel : ContactViewModel = viewModel()

    NavHost(navController = navController, startDestination = "Home" ){
        composable("Home"){
            Home(navController)
        }
        composable(route = "Add"){
            Add(navController,contactViewModel)
        }
        composable("contact"){
            contact(navController,contactViewModel)
        }
    }

}