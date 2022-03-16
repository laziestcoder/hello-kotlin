class CustomGenerics {

    fun execute() {
        val resultEven = EvenList(listOf(1, 2, 3, null, 4));
        println(resultEven.evenItems())

        val resultString = EvenList(listOf("A", "B", "C"))
        resultString.print()
    }
}

class EvenList<T>(val list: List<T>) {

    fun evenItems(): List<T> {
        return list.filterIndexed { index, value -> (index % 2) == 0 && value !== null }
    }

    fun print() {
        list.forEach { element -> println(element) }
    }


}