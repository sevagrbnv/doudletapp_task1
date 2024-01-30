import pushes.PushFactory
import pushes.abstractions.Push

fun main() {
    val system = System()
    val pushList = mutableListOf<Push>()

    repeat(6) {
        val (param, value) = readLine()?.split(" ")
            ?: throw RuntimeException("Wrong param of system")
        system.updateParam(param, value)
    }

    val numberOfPushes = readLine()?.toInt() ?: 0

    repeat(numberOfPushes) {
        val numberOfParams = readLine()?.toInt() ?: 0
        val params = mutableMapOf<String, String>()
        repeat(numberOfParams) {
            val (pushParam, pushValue) = readLine()?.split(" ")
                ?: throw RuntimeException("Wrong pushParam of system")
            params[pushParam] = pushValue
        }
        pushList.add(PushFactory.create(params))
    }

    system.filterPushes(pushList)

    if (system.filteredListOfPushes.isEmpty()) println(-1)
    system.filteredListOfPushes.forEach { push ->
        println(push.text)
    }
}