package filters

import pushes.abstractions.HasTechParam
import pushes.abstractions.Push

class FilterByTech(
    private val os_version: Int
) : Filter {

    override fun isNotMatched(push: Push): Boolean {
        if (push is HasTechParam) {
            return os_version > push.os_version
        }
        return false
    }
}