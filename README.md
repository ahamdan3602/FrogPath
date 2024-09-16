<!DOCTYPE html>
<body>
    <div class="container">
        <h1>Frog Pathfinding Simulation</h1>
        <p>This project is a Java-based simulation that models a frog's journey through a hexagonal grid. The frog, named Freddy, must navigate around obstacles and strategically choose the best path based on the environment's grid structure. This simulation implements an efficient pathfinding system using an <code>ArrayUniquePriorityQueue</code> to determine Freddy's movement priorities based on food, lily pads, and potential threats such as alligators.</p>
        <h2>Key Features</h2>
        <ul>
            <li><strong>ArrayUniquePriorityQueue</strong>: Implements a priority queue data structure using arrays, supporting element insertion, removal, and duplication checks based on priority.</li>
            <li><strong>Pathfinding Algorithm</strong>: Freddy moves strategically using a pathfinding algorithm that calculates cell priorities, taking into account food cells, lily pad cells, and dangerous obstacles.</li>
            <li><strong>Priority Calculation</strong>: Determines priorities based on the type of grid cells and their properties, such as food cells (containing flies), lily pads, and reeds.</li>
            <li><strong>Obstacle Avoidance</strong>: Freddy avoids alligator cells, ensuring his safety as he progresses through the grid.</li>
            <li><strong>Simulation</strong>: Simulates Freddy's movements and interactions within the grid, tracking his journey towards the destination.</li>
        </ul>
        <h2>Getting Started</h2>
        <h3>Prerequisites</h3>
        <p>Ensure you have a Java environment set up on your machine.</p>
        <h3>Installation</h3>
        <ol>
            <li>Clone the repository:</li>
            <pre><code>git clone https://github.com/ahamdan3602/FrogPath.git
cd FrogPath</code></pre>
            <li>Compile the Java files:</li>
            <pre><code>javac ArrayUniquePriorityQueue.java FrogPath.java</code></pre>
        </ol>
        <h2>Running the Simulation</h2>
        <p>To run the simulation, execute the <code>FrogPath</code> class with the filename of the grid configuration:</p>
        <pre><code>java FrogPath &lt;grid_filename&gt;</code></pre>
        <p>Replace <code>&lt;grid_filename&gt;</code> with the name of the configuration file representing the grid environment.</p>
        <h3>Visualization Example</h3>
        <img src = 'https://github.com/user-attachments/assets/a2313b2b-dcaf-4cc9-89e7-ce9e7a021eca'/>
        <h2>How It Works</h2>
        <ol>
            <li><strong>Grid Parsing</strong>: The grid configuration file is parsed to create a hexagonal grid environment containing cells such as food, lily pads, and alligators.</li>
            <li><strong>Priority-Based Movement</strong>: Freddy’s movements are based on the <code>ArrayUniquePriorityQueue</code>, which assigns priorities to neighboring cells depending on their type and properties.</li>
            <li><strong>Interactive Simulation</strong>: The simulation tracks Freddy’s path as he avoids obstacles and navigates towards his destination.</li>
        </ol>
    </div>
</body>
</html>
