# Week 2

## Monitor

A class responsible for synchronization

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

