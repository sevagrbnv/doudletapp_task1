import filters.*
import pushes.abstractions.Push

class System {

    private val params by lazy { SystemParams<String>() }
    val filteredListOfPushes by lazy { mutableListOf<Push>() }

    fun updateParam(key: String, value: String) {
        params.updateParam(key, value)
    }

    fun filterPushes(list: List<Push>) {

        val filter: Filter = BaseFilter().also {
            it.addFilter(FilterByAge(params.age()))
            it.addFilter(FilterByExpire(params.time()))
            it.addFilter(FilterByGender(params.gender()))
            it.addFilter(FilterByLocation(params.x_coord(), params.y_coord()))
            it.addFilter(FilterByTech(params.osVersion()))
        }

        list.forEach { push ->
            if (filter.isMatched(push))
                filteredListOfPushes.add(push)
        }
    }

    class SystemParams<T> {

        private val params: MutableMap<String, T?> = mutableMapOf(
            "time" to null,
            "age" to null,
            "gender" to null,
            "os_version" to null,
            "x_coord" to null,
            "y_coord" to null
        )

        fun updateParam(key: String, value: String) {
            params[key] = parseParam(key, value) as T
        }

        fun time() = params["time"] as Long

        fun age() = params["age"] as Int

        fun gender() = params["gender"] as Gender

        fun osVersion() = params["os_version"] as Int

        fun x_coord() = params["x_coord"] as Float

        fun y_coord() = params["y_coord"] as Float
    }

}