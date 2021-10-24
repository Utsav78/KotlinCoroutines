import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main() = runBlocking {

    /*thread {
        println("Fake works starts :${Thread.currentThread().name}")
        Thread.sleep(1000)
        println("Fake works finished :${Thread.currentThread().name}")
    }

     */
    /*runBlocking {


       /* GlobalScope.launch {
            println("Fake works starts :${Thread.currentThread().name}")
            //delay(1000)
            println("Fake works finished :${Thread.currentThread().name}")
        }

        */
       /* val job : Job = launch {
            println("Fake works starts :${Thread.currentThread().name}")
            //delay(1000)
            println("Fake works finished :${Thread.currentThread().name}")
        }

        //delay(2000)
        job.join() //join function will wait for the coroutine to finish its execution
        println("Main threads starts :${Thread.currentThread().name}")
        println("Outside GlobalScope")

        */

        val job : Deferred<String> = async {
            println("Fake works starts :${Thread.currentThread().name}")
            //delay(1000)
            println("Fake works finished :${Thread.currentThread().name}")
            "I am an Android Engineer"
        }

        //delay(2000)
        //job.join() //join function will wait for the coroutine to finish its execution
        val str : String = job.await()
        println("Main threads starts :${Thread.currentThread().name}")
        println("Outside GlobalScope")
    }
    println("Outside runBlocking ")

     */

        println("Main program starts : ${Thread.currentThread().name}")

        val job: Job = launch {
            try {
                for (i in 0..500) {
                    print("$i.")
                    delay(5)

                }

            }catch (ex: CancellationException){
                println("Exception caught safely")
            }finally {
                withContext(NonCancellable) {
                    delay(2000)
                    println("Close resources in finally")
                }
            }

        }
    delay(200)
    job.cancel()
    job.join()




}

