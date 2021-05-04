package lundeberg.tech.citybike

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CityBikeApplication

fun main(args: Array<String>) {
	runApplication<CityBikeApplication>(*args)
}
