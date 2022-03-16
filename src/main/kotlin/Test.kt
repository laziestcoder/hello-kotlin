class Test {

    fun execute(){
        println("Hello World!")
        var age = 32
        println(age)
        age = 33
        println(age)

        val numberTen = 10
//    numberTen = 11 // can't be assigned or modify the val variable
        println("Now my age is ${age} and it is a ${age::class.java} type class")
    }
}