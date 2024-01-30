package filters

import pushes.abstractions.Push

class BaseFilter: Filter {

    private val filterList by lazy { mutableListOf<Filter>() }

    fun addFilter(filter: Filter) {
        filterList.add(filter)
    }

    override fun isNotMatched(push: Push): Boolean {
        for (filter in filterList) {
            if (filter.isNotMatched(push)) return true
        }
        return false
    }
}