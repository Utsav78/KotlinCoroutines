import kotlinx.coroutines.*

fun main() = runBlocking{
    println("Main program starts : ${Thread.currentThread().name}")

    /*val time = measureTimeMillis {
        val msgOne : Deferred<String> = async {getMessageOne()
        }
        val msgTwo: Deferred<String> = async { getMessageTwo()
        }
        println("The real message is ${msgOne.await()+msgTwo.await()}")

    }

     */
    //println("The time taken is $time")

    val msgOne : Deferred<String> = async(start = CoroutineStart.LAZY) {getMessageOne()}
    val msgTwo : Deferred<String> = async(start = CoroutineStart.LAZY) {getMessageTwo()}
    println(msgOne.await()+msgTwo.await())

    println("Main program ends : ${Thread.currentThread().name}")

}
suspend fun getMessageOne() : String {
    delay(1000L)
    println("After working on getMessageOne")
    return "Hello"
}
suspend fun getMessageTwo() : String {
    delay(1000L)
    println("After working on getMessageTwo")
    return "World!"
}