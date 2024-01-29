package pushes.implementations

import Gender
import pushes.abstractions.*

data class GenderAgePush(
    override val text: String,
    override val gender: Gender,
    override val age: Int
) : Push(text = text, type = PushType.GenderAgePush),
    HasGenderParam,
    HasAgeParam
