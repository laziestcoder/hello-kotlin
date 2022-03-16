fun main() {

    val test = Test()
    test.execute()

    val whenAndAnyTest = WhenAndAnyTest()
    whenAndAnyTest.execute()

    val customGenerics = CustomGenerics()
    customGenerics.execute()

    val addMethodToExistingClass = AddMethodToExistingClass()
    addMethodToExistingClass.execute()

    val mixture = Mixture()
    mixture.execute()

    val lambdaExample = LambdaExample()
    lambdaExample.execute()

}