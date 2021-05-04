package lundeberg.tech.citybike.model

data class StationStatus(
    val stationId: Int,
    val numBikesAvailable: Int,
    val numDocksAvailable: Int
)