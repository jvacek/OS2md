# Week 3

## Reentrant lock

Denotes a critical section

An alternative to what you'd achieve when you use `synchronized` blocks.

~~~ java
monLock.lock(); 
try  {

    // Critical Section 

} finally  {

    monLock.unlock();

}
~~~

* How many ReentrantLocks do you need?
    * In general, equal to the number of objects to which you synchronize.
                e.g. Synchronized methods only -> synchronize on this -> 1 lock


## Condition

This is basically like `wait()` , `notify()` and `notifyAll()` but in a class, and without `synchronized`

Used when a thread has a requirement before continuing

If the condition is not satisfied, the condition will wait until it is satisfied through an `await()`

When the condition is satisfied, something else will call `signal()` or `signalAll()`

* How many Conditions do you need?
  * Depends on what the threads are waiting for nr. of different, non mutually exclusive, boolean expressions for the wait


## Monitor

A class that handles all of the synchronization issues

<!-- TODO what exactly does this do -->

## Examples of both in use

~~~ java
// Some place else...
Lock monLock = new ReentrantLock();
Condition xPos = monLock.newCondition()

public void m1() {

    monLock.lock();
    try {
        while (!(x > 0)) {
            xPos.await();
        }
        // ......
    } finally {
        monLock.unlock();
    }

}

public void m2() {
    monLock.lock()
    try {

        // ...... 
        if (x > 0) {
            xPos.signal();
        }

    } finally {

        monLock.unlock();

    }
}

~~~
