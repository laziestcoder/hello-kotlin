@file:JvmName("CustomExtensions")

typealias MyStringAlias = String

class AddMethodToExistingClass {

    fun execute() {
        val myName = "FirstName LastName"
        println(myName.myCustomMethod())
    }

}

/**
 * Extended Class Method
 */
fun String.myCustomMethod(): MyStringAlias {
    val values = this.split(" ")
    val firstPart = values[0].substring(0, 1)
    val lastPart = values[1].substring(0, 1)
    return "$firstPart and $lastPart"
}