package pushes.abstractions

import PushType

abstract class Push(open val text: String, val type: PushType)