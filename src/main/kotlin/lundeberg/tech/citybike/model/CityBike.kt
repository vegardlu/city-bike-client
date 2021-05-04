package lundeberg.tech.citybike.model

data class CityBikeData<T>(
    val lastUpdated: Int,
    val ttl: Int,
    val data: CityBikeStations<T>
)

data class CityBikeStations<T>(
    val stations: List<T>
)