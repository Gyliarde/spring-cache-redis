package br.com.araujo.cacheredis

import java.io.Serializable

data class Product(val id: Long, val name: String, val description: String) : Serializable
