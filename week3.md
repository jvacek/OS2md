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

## Examples of both in use

~~~ java
public void m1() {
    monLock.lock();
    try {
        while (!(x > 0)) {
            xPos.await();
        }
        // ......
    }
    finally {
        monLock.unlock();
    }
}
~~~