package filters

import Gender
import pushes.abstractions.HasGenderParam
import pushes.abstractions.Push

class FilterByGender(
    private val gender: Gender
): Filter {

    override fun isNotMatched(push: Push): Boolean {
        if (push is HasGenderParam) {
            return push.gender != gender
        }
        return false
    }
}