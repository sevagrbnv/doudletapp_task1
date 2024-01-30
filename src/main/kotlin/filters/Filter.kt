package filters

import pushes.abstractions.Push

interface Filter {
    fun isNotMatched(push: Push): Boolean
}