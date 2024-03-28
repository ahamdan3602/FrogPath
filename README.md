Frog Pathfinding Simulation
This project is a Java-based simulation of a frog navigating through a hexagonal grid environment, avoiding obstacles and reaching its destination. It includes two main classes: ArrayUniquePriorityQueue and FrogPath.

ArrayUniquePriorityQueue
The ArrayUniquePriorityQueue class implements a priority queue data structure using arrays. It supports adding elements with priorities, checking for duplicates, peeking at the element with the smallest priority, and removing elements with the smallest priority.

FrogPath
The FrogPath class simulates the movement of a frog named Freddy on a hexagonal grid. It utilizes the ArrayUniquePriorityQueue to prioritize the frog's movement based on cell priorities such as food cells, lily pad cells, and reeds cells. The frog must navigate through the grid, avoiding obstacles like alligators, while aiming to reach a specific destination cell.

Key Features:
Pathfinding Algorithm: Implements a pathfinding algorithm to determine the best neighboring cell for the frog to move to, considering cell priorities and obstacles.
Priority Calculation: Calculates the priority of each cell based on its type and properties, such as the number of flies in food cells.
Obstacle Avoidance: Checks for nearby alligator cells to avoid potential threats to the frog's safety.
Simulation: Simulates the frog's movement through the grid, tracking its path and interactions with different types of cells.
Usage
To run the simulation:

Compile the Java files (ArrayUniquePriorityQueue.java and FrogPath.java).
Execute the FrogPath class with the filename of the grid configuration as an argument.
bash
Copy code
javac ArrayUniquePriorityQueue.java FrogPath.java
java FrogPath <grid_filename>
Replace <grid_filename> with the filename containing the grid configuration.

Example
An example grid configuration file (example_grid.txt) is provided in the repository. To run the simulation with this configuration:

bash
Copy code
java FrogPath example_grid.txt
