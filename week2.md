# Week 2

## Use of `if` versus `while`


Use a `while` if your thread should go back to sleep in case it got woken up and the condition is not yet true because the call was for a different thread.

Only use an `if` when you've got only one thread that would invoke it.

## Monitor

A class responsible for synchronization. Allows multiple threads to enter the critical section.

Features:

* Contains all shared private variables
* **DOES NOT** contain the dataset itself
* Methods:
  * One public method for every sync event
  * All methods are synced
  * Methods contain `wait`/`notify`/`notifyAll` calls
* Instantiation
  * Usually singleton
  * Object is shared by all threads

Only `enter` and `exit` functions are synchronised, not necessarily the functions which do the editing and enter the critical section.

A note about interrupting threads: update waiting variable inside the `enter` methods. <!-- What does this mean ???? TODO slide 16 in OS2_week2 -->

## Reader-writer examples

Store the number of Readers and writers in a `private int` in the Monitor, and manipulate number in the `enter...` and `exit...` functions.

These enter and exit functions needs to handle the `wait` status.


General reader structure:

~~~ java
while(true) { 
  RW.enterReader(); 
  // read dataset (CS) 
  RW.exitReader(); 
}
~~~

General writer structure:

~~~ java
while(true) { 
  RW.enterWriter(); 
  // update dataset (CS) 
  RW.exitWriter(); 
}
~~~

### Reader part of `Monitor`
~~~ java
public synchronized void enterReader()  throws InterruptedException { 
  while (writersActive > 0) {  
    wait();  
  } 
  readersActive++; 
} 

public synchronized void exitReader() { 
  readersActive--; 
  notifyAll();
  // Should be notifyAll as you should try wake up writers first if any exist possibly
}
~~~


### Writer part of monitor


~~~ java
public synchronized void enterWriter()  throws InterruptedException { 
  while (writersActive > 0 || readersActive > 0) 
  { 
    wait(); 
  } 
  writersActive++; 
}

// exitWriter() similar to exitReader()
// A simple notify should work, should not matter what you wake up
~~~

Or if writers need precedence before readers...

~~~ java
public synchronized void enterWriter()  throws InterruptedException { 
  while((writersActive != 0) || (writersWaiting > 0)){ 
    readersWaiting++; 
    wait(); 
    readersWaiting--; 
  }
}

// exitWriter() similar to exitReader()
~~~

