# Week 6

## Banker's algorithm

## Maximum claim graph

### Using tables

### Algorithm
1. Assume current state is safe
2. Consider a new request by process `i`
   * `req[i,j]` : number of resoureces of type `j` requested by process `i`
3. New state is obtained as follows:
   1. `av[j]` = `av[j]` - `req[i,j]`
   2. `alloc[i,j]` = `alloc[i,j]` + `req[i,j]`
   3. `claim[i,j]` = `claim[i,j]` - `req[i,j]`
4. Check if new state is safe
   * Find sequence of processes to finish
