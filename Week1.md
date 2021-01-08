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

- Single thread executor - pool of size 1\
`ExecutorService pool = Executors.newSingleThreadExecutor();`
- Fixed thread executor - pool of fixed size\
`ExecutorService pool = Executors.newFixedThreadPool(size);`
- Cached thread pool - creates new threads when necessary; deletes unused threads after 60 sec\
`ExecutorService pool = Executors.newCachedThreadPool();`
- Scheduled thread pool – fixed size pool for scheduled or repeated execution (after certain delay)\
`ScheduledExecutorService pool = Executors.newScheduledThreadPool(size);`
- Single scheduled thread pool – pool of size 1 for scheduled or repeated execution\
`ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();`
## Synchronisers
Tools to start and stop threads based on conditions
Implemented examples [here](https://github.com/volkodavs/java-concurrency.git)

Summary:
- **CyclicBarrier**:
  - Used to synchronize one group of similar threads
  - They all wait for each other
- **CountDownLatch**:
  - There are 2 groups of threads
  - One group that is waiting for another group 
  - The threads in the waiting group call cd.await()
  - The other threads call cd.countdown()
  - Each group can also consist of one single thread



### Cyclic barrier
![gif](https://user-images.githubusercontent.com/4140597/31797681-81f57ca0-b527-11e7-83b6-5933e7627fed.gif)
- Let a number of threads wait for each other\
`CyclicBarrier cb = new CyclicBarrier(5);`
- Suppose we have 5 threads that do the following:\
~~~
... // do a certain calculation cb.await(); ... // wrapping up
~~~
- The first 4 threads will be blocked in `cb.await()`
- As soon as the 5th arrives, all 5 continue
### Countdown Latch
Has a counter, and when 0 is reached all threads that were waiting are woken up
- you have a thread pool
- N tasks for that pool
- main thread must wait until all N tasks are finished

~~~ java
class WorkerRunnable implements Runnable {
    CountDownLatch doneSignal;
    WorkerRunnable(CountDownLatch d) {
        doneSignal = d;
    }
    public void run() {
        doWork();
        doneSignal.countDown();
    }
}

CountDownLatch doneSignal = new CountDownLatch(N);
ExecutorService e = //...
    for (int i = 0; i < N; i++) {
        e.execute(new WorkerRunnable(doneSignal));
    }

try {
    doneSignal.await();
} catch (InterruptedException ex) {}
~~~
