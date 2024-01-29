package pushes.implementations

import pushes.abstractions.Push
import pushes.abstractions.HasAgeParam
import pushes.abstractions.HasExpiryDateParam

data class AgeSpecificPush(
    override val text: String,
    override val age: Int,
    override val expiry_date: Long
) : Push(text = text, type = PushType.AgeSpecificPush),
    HasAgeParam,
    HasExpiryDateParam
