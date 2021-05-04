package lundeberg.tech.citybike.model

data class StationInformation(
    val stationId: Int,
    val name: String,
    val address: String,
    val capacity: Int
)

data class StationInformationWrapper(
    val lastUpdated: Int,
    val ttl: Int,
    val data: StationInformationData
)

data class StationInformationData(
    val stations: List<StationInformation>
)