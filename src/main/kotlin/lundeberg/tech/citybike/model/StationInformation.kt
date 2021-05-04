package lundeberg.tech.citybike.model

data class StationInformation(
    val lastUpdated: Int,
    val ttl: Int,
    val data: StationInformationData
)

data class StationInformationData(
    val stations: List<Station>
)