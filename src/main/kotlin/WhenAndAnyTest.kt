class WhenAndAnyTest {

    fun execute() {
        val obj = getStuff(1);
        println(obj)
        val objA = getStuff("2");
        println(objA)
        val objC = getStuff("3");
        val casted = objC as? Int;
        println(casted);

    }

    private fun getStuff(value: Any): Any {
        return when (value) {
            1 -> 99
            "2" -> "Hello"
            "3" -> true
            "4" -> 16.1
            else -> false
        }
    }
}