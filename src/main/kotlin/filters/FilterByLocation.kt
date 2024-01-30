package filters

import pushes.abstractions.HasLocationParams
import pushes.abstractions.Push
import kotlin.math.pow
import kotlin.math.sqrt

class FilterByLocation(
    private val x: Float, private val y: Float
) : Filter {

    override fun isNotMatched(push: Push): Boolean {
        if (push is HasLocationParams) {
            return (isNotInCircle(push))
        }
        return false
    }

    private fun isNotInCircle(push: HasLocationParams): Boolean {
        val xDistance = Math.abs(x - push.x_coord)
        val yDistance = Math.abs(y - push.y_coord)
        val euclideanDistance = sqrt(xDistance.pow(2) + yDistance.pow(2))
        return euclideanDistance > push.radius.toFloat()
    }
}