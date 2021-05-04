package lundeberg.tech.citybike.model

data class StationInformation(
    val stationId: Int,
    val name: String,
    val address: String,
    val capacity: Int
)