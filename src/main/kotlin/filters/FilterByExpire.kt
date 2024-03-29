package filters

import pushes.abstractions.HasExpiryDateParam
import pushes.abstractions.Push

class FilterByExpire(
    private val time: Long
): Filter {

    override fun isNotMatched(push: Push): Boolean {
        if (push is HasExpiryDateParam) {
            return push.expiry_date < time
        }
        return false
    }
}