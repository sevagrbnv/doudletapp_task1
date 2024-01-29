fun parseParam(key: String, value: String?) = when (key) {
    "time", "expiry_date"-> value?.toLong()
    "age", "os_version", "radius" -> value?.toInt()
    "gender" -> value?.toGender()
    "x_coord", "y_coord" -> value?.toFloat()
    else -> throw RuntimeException()
}

enum class Gender {
    Male,
    Female
}

fun String.toGender() = when (this.lowercase()) {
    "m" -> Gender.Male
    "f" -> Gender.Female
    else -> throw IllegalStateException()
}

enum class PushType {
    LocationPush,
    AgeSpecificPush,
    TechPush,
    LocationAgePush,
    GenderAgePush,
    GenderPush
}