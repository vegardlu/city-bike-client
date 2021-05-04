package lundeberg.tech.citybike

import com.google.gson.FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*


val httpClient = HttpClient(CIO) {
    install(JsonFeature) {
        serializer = gsonSerializer()
    }
}

private fun gsonSerializer() = GsonSerializer {
    setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES)
}