package filters

import pushes.abstractions.Push

interface Filter {
    fun isMatched(push: Push): Boolean
}