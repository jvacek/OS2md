# Week 3

## Reentrant lock
~~~ java
monLock.lock(); try  {
    // Critical Section 
} finally  {
    monLock.unlock();
}

~~~