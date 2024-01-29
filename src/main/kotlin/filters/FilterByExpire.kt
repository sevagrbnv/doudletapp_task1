package filters

import pushes.abstractions.HasExpiryDateParam
import pushes.abstractions.Push

class FilterByExpire(
    private val time: Long
): Filter {

    override fun isMatched(push: Push): Boolean {
        if (push is HasExpiryDateParam) {
            return push.expiry_date >= time
        }
        return true
    }
}