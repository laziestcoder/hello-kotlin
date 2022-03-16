class LambdaExample {
    fun execute() {
        println(lengthOfGivenValueOne("My Customize Class Example for Lambda"))
        lengthOfGivenValueTwo("Some String", 244)
        lineLogger {
            println("My Name")
            println("My Your Name")
            println("Etc")
        }

    }

    /** NOTE: LAMBDA DO NOT SUPPORT OVERLOADING **/

    var lengthOfGivenValueOne: (String) -> Int = { givenString: String ->
        println("Given Value: $givenString")
        givenString.length
    }

    /**
        var lengthOfGivenValueOne: (String, Int) -> Int = { givenString: String, givenInt: Int ->
            println("Given Value: $givenString")
            println("Given Int: $givenInt")
            givenString.length
        }
    */

    var lengthOfGivenValueTwo: (String, Int) -> Unit = { givenString: String, givenInt: Int ->
        println("Given Value: $givenString")
        println("Given Int: $givenInt")
        println(givenString.length)
        val message = if (givenInt % 2 == 0) "even" else "odd"
        println("Given Int: $message")
    }

    private fun lineLogger(block: () -> Unit){
        println("################")
        block()
        println("################")
    }

}