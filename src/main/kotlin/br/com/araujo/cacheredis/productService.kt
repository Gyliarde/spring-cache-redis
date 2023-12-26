package br.com.araujo.cacheredis

import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class ProductService {

    val products = mapOf(
        1L to Product(1, "Caneta", "Azul"),
        2L to Product(2, "Lapís", "Preto"),
        3L to Product(3, "Borracha", "Branca"),
        4L to Product(4, "Caderno", "90 Folhas")
    )


    @Cacheable("products")
    fun getById(id: Long): Product {
        println("Buscando Produtos")
        simulateLatency()
        return products[id]!!
    }

    private fun simulateLatency() {
        try {
            Thread.sleep(1000L)
        } catch (e: InterruptedException) {
            throw IllegalStateException(e)
        }

    }
}