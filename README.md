<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Frog Pathfinding Simulation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            background-color: #f4f4f4;
            color: #333;
            padding: 20px;
        }
        h1 {
            color: #2c3e50;
        }
        h2 {
            color: #2980b9;
        }
        pre {
            background-color: #ecf0f1;
            padding: 10px;
            border-left: 4px solid #2980b9;
            overflow-x: auto;
        }
        code {
            background-color: #eaeaea;
            padding: 2px 4px;
            border-radius: 3px;
        }
        .container {
            max-width: 900px;
            margin: 0 auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
    </style>
</head>
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
cd frog-pathfinding-simulation</code></pre>
            <li>Compile the Java files:</li>
            <pre><code>javac ArrayUniquePriorityQueue.java FrogPath.java</code></pre>
        </ol>
        <h2>Running the Simulation</h2>
        <p>To run the simulation, execute the <code>FrogPath</code> class with the filename of the grid configuration:</p>
        <pre><code>java FrogPath &lt;grid_filename&gt;</code></pre>
        <p>Replace <code>&lt;grid_filename&gt;</code> with the name of the configuration file representing the grid environment.</p>
        <h3>Example</h3>
        <p>A sample grid configuration file, <code>example_grid.txt</code>, is provided in the repository. You can run the simulation using this file as follows:</p>
        <pre><code>java FrogPath example_grid.txt</code></pre>
        <h2>Project Structure</h2>
        <ul>
            <li><code>ArrayUniquePriorityQueue.java</code>: Implements the priority queue using an array, ensuring uniqueness and managing priorities.</li>
            <li><code>FrogPath.java</code>: Contains the simulation logic for Freddy’s movements, interactions with the environment, and pathfinding algorithm.</li>
            <li><code>example_grid.txt</code>: A sample grid configuration file that you can use to test the simulation.</li>
        </ul>
        <h2>How It Works</h2>
        <ol>
            <li><strong>Grid Parsing</strong>: The grid configuration file is parsed to create a hexagonal grid environment containing cells such as food, lily pads, and alligators.</li>
            <li><strong>Priority-Based Movement</strong>: Freddy’s movements are based on the <code>ArrayUniquePriorityQueue</code>, which assigns priorities to neighboring cells depending on their type and properties.</li>
            <li><strong>Interactive Simulation</strong>: The simulation tracks Freddy’s path as he avoids obstacles and navigates towards his destination.</li>
        </ol>
    </div>
</body>
</html>
