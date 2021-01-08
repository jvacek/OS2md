# Week 3

## Reentrant lock

~~~ java
monLock.lock(); 
try  {

    // Critical Section 

} finally  {

    monLock.unlock();

}

~~~

## Condition

This is basically like `wait()` , `notify()` and `notifyAll()` but in a class, and without `synchronized`

Used when a thread has a requirement before continuing

If the condition is not satisfied, the condition will wait until it is satisfied through an `await()`

When the condition is satisfied, something else will call `signal()` or `signalAll()`

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
