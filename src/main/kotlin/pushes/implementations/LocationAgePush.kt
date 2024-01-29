package pushes.implementations

import pushes.abstractions.Push
import pushes.abstractions.HasAgeParam
import pushes.abstractions.HasLocationParams

data class LocationAgePush(
    override val text: String,
    override val x_coord: Float,
    override val y_coord: Float,
    override val radius: Int,
    override val age: Int
) : Push(text = text, type = PushType.LocationAgePush),
    HasLocationParams,
    HasAgeParam
