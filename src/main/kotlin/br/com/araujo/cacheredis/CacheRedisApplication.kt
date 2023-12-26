package br.com.araujo.cacheredis

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.stereotype.Component

@EnableCaching
@SpringBootApplication
class CacheRedisApplication

fun main(args: Array<String>) {
	runApplication<CacheRedisApplication>(*args)
}


@Component
class ApplicationRunner(val productService: ProductService) : ApplicationRunner {

	@Throws(Exception::class)
	override fun run(args: ApplicationArguments) {
		println("Id: 1 ${productService.getById(1)}")
		println("Id: 2 ${productService.getById(2)}")
		println("Id: 1 ${productService.getById(1)}")
		println("Id: 1 ${productService.getById(1)}")
		println("Id: 1 ${productService.getById(1)}")
	}
}

