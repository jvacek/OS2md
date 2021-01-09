# Week 5

## Deadlock

When two or more processes are waiting for each other to finish and they are forever stuck because of their co-dependency.

![A manhattan-style deadlock](images/deadlock.png)

### Conditions
You can only have a deadlock if **ALL** of the below are true

* Mutual exclusion
  * i.e. Things can't run in parallel
* Hold and wait
  * i.e. they're both keeping something and awaiting for something else to happen
* No preemption
  * i.e. There is no other decision mechanism or a 3rd party to manage this
* Circular waiting
  * They have to wait for one another

If one of these is false, then the situation **cannot** produce a deadlock.

### Prevention strategies

* Detection & recovery
  * Let processes execute uninhibited
  * e.g. terminate deadlocked processes
* Prevention
  * Change the static rules so you can't have a deadlock
* Avoidance
  * Use dynamic rules so that OS determines if it is safe to continue for example.

## Resource allocation graph

**TODO**

## Dining philosophers problem

**TODO**
