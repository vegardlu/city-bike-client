package lundeberg.tech.citybike

import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking
import lundeberg.tech.citybike.model.CityBikeData
import lundeberg.tech.citybike.model.StationInformation
import lundeberg.tech.citybike.model.StationStatus
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class StationInformationController {

    @GetMapping("/stations")
    fun stations(
        model: Model,
        @Value("\${endpoint.stationstatus}") stationStatusEndpoint: String,
        @Value("\${endpoint.stationinformation}") stationInformationEndpoint: String
    ) = try {
        model
            .stations(stationInformationEndpoint)
            .stationStatusMap(stationStatusEndpoint)
        "stations"
    } catch (e: Exception) {
        "stations_error"
    }
}

fun Model.stations(endpoint: String) =
    addAttribute(
        "stations",
        get<CityBikeData<StationInformation>>(endpoint).data.stations
    )

fun Model.stationStatusMap(endpoint: String) =
    addAttribute(
        "stationStatusMap",
        get<CityBikeData<StationStatus>>(endpoint).data.stations.associateBy { it.stationId }
    )

inline fun <reified T> get(url: String) = runBlocking {
    httpClient.get<T>(url) {
        header("Client-Identifier", "lundebergtech-citybikeclient")
    }
}