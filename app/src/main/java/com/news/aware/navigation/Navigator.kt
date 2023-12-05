package com.news.aware.navigation

import androidx.navigation.NavHostController

class Navigator(private val controller: NavHostController){
    fun toPage(page: String, pop: String?){
        controller.navigate(page){
            if(pop != null){
                popUpTo(pop){
                    inclusive = true
                }
            }
        }
    }
}