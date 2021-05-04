package lundeberg.tech.citybike.model

data class CityBikeDataWrapper<T>(
    val lastUpdated: Int,
    val ttl: Int,
    val data: CityBikeStationsWrapper<T>
)

data class CityBikeStationsWrapper<T>(
    val stations: List<T>
)