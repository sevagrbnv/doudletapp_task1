package pushes.implementations

import Gender
import PushType
import pushes.abstractions.HasGenderParam
import pushes.abstractions.Push

data class GenderPush(
    override val text: String,
    override val gender: Gender
) : Push(text = text, type = PushType.GenderPush),
    HasGenderParam
