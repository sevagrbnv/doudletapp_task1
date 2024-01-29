package filters

import pushes.abstractions.HasTechParam
import pushes.abstractions.Push

class FilterByTech(
    private val os_version: Int
) : Filter {

    override fun isMatched(push: Push): Boolean {
        if (push is HasTechParam) {
            return push.os_version > os_version
        }
        return true
    }
}