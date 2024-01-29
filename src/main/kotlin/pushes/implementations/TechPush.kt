package pushes.implementations

import pushes.abstractions.Push
import pushes.abstractions.HasTechParam

data class TechPush(
    override val text: String,
    override val os_version: Int,
) : Push(text = text, type = PushType.TechPush),
    HasTechParam
