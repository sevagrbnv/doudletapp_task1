package filters

import pushes.abstractions.Push

class BaseFilter: Filter {

    private val filterList by lazy { mutableListOf<Filter>() }

    fun addFilter(filter: Filter) {
        filterList.add(filter)
    }

    override fun isMatched(push: Push): Boolean {
        for (filter in filterList) {
            if (!filter.isMatched(push)) return false
        }
        return true
    }
}