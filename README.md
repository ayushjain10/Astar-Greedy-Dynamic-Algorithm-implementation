# Astar-Greedy-Dynamic-Algorithm-implementation
Implementation of A star, Greedy and Dynamic Algorithms on US Road Network to get shortest path

Given Heuristic information of each city based on latitude and longitude information, find the shortest path from one city to another.

Algorithms Implemented :

  1) Astar Algorithm : It takes into account the distance from source city to the node and heuristic information. This              algorithm selects the best overall path. 
  
  2) Dynamic Algorithm : It takes into account only the distance from source city to the node. It doesn't care about the            heuristic distance.
  
  3) Greedy Algorithm : It considers only the distance from node to the destination city.
  
  
Observations : 

Astar is the most efficient algorithm and always selects the best path from source city to the destination city with minimum path cost.

Greedy seems to be optimal but doesn't give minimum path costs everytime.
