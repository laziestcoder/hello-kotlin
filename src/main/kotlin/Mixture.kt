import java.lang.Thread.sleep
import java.util.*

class Mixture {

    fun execute() {
        precalculateUsingLazyOne()
        precalculateUsingLazyTwo()
        lateInitExample()

    }

    private fun precalculateUsingLazyOne() {
        val name: MyStringAlias by lazy {
            println("Calculation Started....")
            sleep(5000)
            "calculated Result"
        }
        println(name)
        println(name)
        println(name)
    }

    private fun precalculateUsingLazyTwo() {
        val result: Int by lazy {
            expensiveOperation()
        }
        println(result)
        println(result)
        println(result)
    }

    private fun lateInitExample() {

        lateinit var food: String

        val foodTwo = "Orange"
        food = foodTwo + "Mango"
        println(food)

    }
}

fun expensiveOperation(): Int {
    println("Calculation Started....")
    sleep(5000)
    return Random(System.currentTimeMillis()).nextInt();
}