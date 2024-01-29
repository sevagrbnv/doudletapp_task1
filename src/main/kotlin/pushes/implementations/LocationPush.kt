package pushes.implementations

import pushes.abstractions.Push
import pushes.abstractions.HasExpiryDateParam
import pushes.abstractions.HasLocationParams

data class LocationPush(
    override val text: String,
    override val x_coord: Float,
    override val y_coord: Float,
    override val radius: Int,
    override val expiry_date: Long
) : Push(text = text, type = PushType.LocationPush),
    HasLocationParams,
    HasExpiryDateParam
