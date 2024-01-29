package pushes

import Gender
import parseParam
import pushes.implementations.*

class PushFactory {

    companion object {
        fun create(params: Map<String, String>) = when (params["type"]) {
            "LocationPush" -> LocationPush(
                text = params["text"] as String,
                x_coord = parseParam("x_coord", params["x_coord"]) as Float,
                y_coord = parseParam("y_coord", params["y_coord"]) as Float,
                radius = parseParam("radius", params["radius"]) as Int,
                expiry_date = parseParam("expiry_date", params["expiry_date"]) as Long
            )
            "AgeSpecificPush" -> AgeSpecificPush(
                text = params["text"] as String,
                age = parseParam("age", params["age"]) as Int,
                expiry_date = parseParam("expiry_date", params["expiry_date"]) as Long
            )
            "TechPush" -> TechPush(
                text = params["text"] as String,
                os_version = parseParam("os_version", params["os_version"]) as Int
            )

            "LocationAgePush" -> LocationAgePush(
                text = params["text"] as String,
                x_coord = parseParam("x_coord", params["x_coord"]) as Float,
                y_coord = parseParam("y_coord", params["y_coord"]) as Float,
                radius = parseParam("radius", params["radius"]) as Int,
                age = parseParam("age", params["age"]) as Int
            )
            "GenderAgePush" -> GenderAgePush(
                text = params["text"] as String,
                gender = parseParam("gender", params["gender"]) as Gender,
                age = parseParam("age", params["age"]) as Int
            )
            "GenderPush" -> GenderPush(
                text = params["text"] as String,
                gender = parseParam("gender", params["gender"]) as Gender
            )
            else -> throw RuntimeException("Unknown type of push")
        }
    }
}