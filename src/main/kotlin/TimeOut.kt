import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

fun main() = runBlocking{

    println("Main thread starts : ${Thread.currentThread().name}")

    withTimeout(2000){
        try {
            for (i in 0..500){
                print("$i.")
                delay(5)
            }
        }catch (ex:TimeoutCancellationException){
            println("Exception caught safely")
        }finally {
            println("Resources are free now in finally block")
        }
    }

}