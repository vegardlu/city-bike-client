package lundeberg.tech.citybike

import com.google.gson.FieldNamingPolicy
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import lundeberg.tech.citybike.model.StationInformation
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class StationInformationController {

    @GetMapping("/stations")
    suspend fun greeting(
        @RequestParam(name = "stationId", required = false) name: String?,
        model: Model
    ): String {
        val stationInformation = stationInformation()
        model.addAttribute("stations", stationInformation.data.stations)
        return "stations"
    }

    suspend fun stationInformation() =
        HttpClient(CIO) {
            install(JsonFeature) {
                serializer = GsonSerializer {
                    setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                }
            }
        }.get<StationInformation>("https://gbfs.urbansharing.com/oslobysykkel.no/station_information.json")
}