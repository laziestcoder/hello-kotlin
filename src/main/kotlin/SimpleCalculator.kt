fun main(vararg args: String) {
    println("Please enter an arithmetic problem. i.e 1 + 1")
    var input = readLine()
    while (input != null && input.isNotBlank()) {
        val values = input.split(" ")
        if (values.size < 3) {
            println("Invalid input. Expected: value operator value. Received: $input")
        } else {
            val operator = values[1]
            val lhs = values[0].toDoubleOrNull() ?: throw IllegalArgumentException("Invalid value: $values[0]")
            val rhs = values[2].toDoubleOrNull() ?: throw IllegalArgumentException("Invalid value: $values[2]")

            val result = when (operator) {
                "+" -> lhs + rhs
                "-" -> lhs - rhs
                "*" -> lhs * rhs
                "/" -> lhs / rhs
                else -> throw IllegalArgumentException("Invalid operator: $operator")
            }
            println(result)
        }

        input = readLine()
    }
    println("Thank you. Good Bye!")
}