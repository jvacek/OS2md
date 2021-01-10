# Week 1

## Thread pools

Something to manage a lot of threads with that run until you shut them down

~~~ java

public class ThreadPoolExample {
    public static void main(String[] args) {
        // create the thread pool
        ExecutorService pool = Executors.newCachedThreadPool();
        // run each task using a thread in the pool
        for (int i = 0; i < 5; i++) {
            pool.execute(new MyTask());
        }
        // shut down the pool
        pool.shutdown(); // or shutdownNow();
    }
}

~~~

* Single thread executor - pool of size 1 \
  `ExecutorService pool = Executors.newSingleThreadExecutor();`
* Fixed thread executor - pool of fixed size \
  `ExecutorService pool = Executors.newFixedThreadPool(size);`
* Cached thread pool - creates new threads when necessary; deletes unused threads after 60 sec \
  `ExecutorService pool = Executors.newCachedThreadPool();`
* Scheduled thread pool – fixed size pool for scheduled or repeated execution (after certain delay) \
  `ScheduledExecutorService pool = Executors.newScheduledThreadPool(size);`
* Single scheduled thread pool – pool of size 1 for scheduled or repeated execution \
`ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();`

## Synchronisers

Tools to start and stop threads based on conditions
Implemented examples [here](https://github.com/volkodavs/java-concurrency.git)

Summary:

* **CyclicBarrier**:
  * Used to synchronize one group of similar threads
  * They all wait for each other
* **CountDownLatch**:
  * There are 2 groups of threads
  * One group that is waiting for another group 
  * The threads in the waiting group call cd.await()
  * The other threads call cd.countdown()
  * Each group can also consist of one single thread



### Cyclic barrier

Ensures that a the amount of threads specified are all waiting and when the last needed one arrives, resumes all the threads that were waiting at once.

![apng](images/cyclicbarrier.gif)

#### Example implementation

Create a cyclic barrier in your main-ish class outside of your runnable
~~~ java
`CyclicBarrier cb = new CyclicBarrier(4);`
~~~

And then insie of your runnable, make sure to store the `cb` and then add the `cb.await()` wherever you need to wit for the `n`th or in this instance 4th thread.
~~~ java
class WorkerRunnable implements Runnable {
    CyclicBarrier cb;
    
    WorkerRunnable(CyclicBarrier cb) {
        doneSignal = cb;
    }
    
    public void run() {
        doWork();
        cb.await; // <- This is where it's gonna get stuck until the 5th one starts waiting
    }
}
~~~

### Countdown Latch

Has a counter, and when 0 is reached all threads that were waiting are woken up

![apng](images/countdownlatch.gif)

* you have a thread pool
* N tasks for that pool
* main thread must wait until all N tasks are finished

#### Example implementation
Implement the countdown in your runnable
~~~ java
class WorkerRunnable implements Runnable {
    CountDownLatch doneSignal;
    
    WorkerRunnable(CountDownLatch d) {
        doneSignal = d;
    }
    
    public void run() {
        doWork();
        doneSignal.countDown(); // <- the important bit here
    }
}
~~~

Elsewhere in your code, usually the "main-ish" class

~~~ java
CountDownLatch doneSignal = new CountDownLatch(N);
ExecutorService e = //One of the Threadpools

for (int i = 0; i < N; i++) {
    e.execute(new WorkerRunnable(doneSignal));
}
~~~

And in the place where you need 
~~~ java
// This goes wherever you need something to wait.
try {
    doneSignal.await();
    // Do whatever you had to wait for
}
catch (InterruptedException ex) {
  // handle exceptions
}

~~~
