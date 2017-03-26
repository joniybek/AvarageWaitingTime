# Pizza challenge solutions
This is the solutions for Minimum Avarage Waiting Time challenge.

###### It has following solutions for the same problem:

- Minimize constructed function implemented in MinFunc class
- Optimized solution

### MinFunc class
Algorithm has O(N^2) complexity

Let L and M be order time and duration of cooking, ' - denote previous iter vars then Total time passed since start is T = M + max(0, L-T') hence Total waiting time W = W' + M + max(0, T'-L), we want to minimize that

### Optimized Solution
This is one more implementation using PriorityQueues
