package filters

import pushes.abstractions.HasLocationParams
import pushes.abstractions.Push
import kotlin.math.pow

class FilterByLocation(
    private val x: Float, private val y: Float
) : Filter {

    override fun isMatched(push: Push): Boolean {
        if (push is HasLocationParams) {
            return (isInCircle(push))
        }
        return true
    }

    private fun isInCircle(push: HasLocationParams): Boolean {
        val sqrDX = (push.x_coord - x).toDouble().pow(2.0)
        val sqrDY = (push.y_coord - y).toDouble().pow(2.0)
        return sqrDX + sqrDY <= push.radius.toDouble().pow(2.0)
    }
}