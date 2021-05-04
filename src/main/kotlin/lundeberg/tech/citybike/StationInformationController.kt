package lundeberg.tech.citybike

import com.google.gson.FieldNamingPolicy
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import lundeberg.tech.citybike.model.CityBikeData
import lundeberg.tech.citybike.model.StationInformation
import lundeberg.tech.citybike.model.StationStatus
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
        val stationMap = stationStatus().data.stations.associateBy { it.stationId }
        model.addAttribute("stationMap", stationMap)
        return "stations"
    }

    suspend fun stationInformation() = httpClient
        .get<CityBikeData<StationInformation>>("https://gbfs.urbansharing.com/oslobysykkel.no/station_information.json")

    suspend fun stationStatus() = httpClient
        .get<CityBikeData<StationStatus>>("https://gbfs.urbansharing.com/oslobysykkel.no/station_status.json")
}

val httpClient = HttpClient(CIO) {
    install(JsonFeature) {
        serializer = GsonSerializer {
            setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        }
    }
}