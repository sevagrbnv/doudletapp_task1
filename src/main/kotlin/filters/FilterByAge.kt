package filters

import pushes.abstractions.HasAgeParam
import pushes.abstractions.Push

class FilterByAge(
    private val age: Int
): Filter {
    override fun isNotMatched(push: Push): Boolean {
        if (push is HasAgeParam) {
            return push.age > age
        }
        return false
    }
}