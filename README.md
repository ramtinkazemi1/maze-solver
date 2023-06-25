# MAZE SOLVER

## Heap Implementation

The Heap Implementation project consists of two parts: Part 1 focuses on implementing a Heap class, and Part 2 involves implementing Dijkstra's algorithm using the priority queue structure (heap) from Part 1.

## Project Description

The goal of this project is to implement a Heap data structure and utilize it to solve problems efficiently. The Heap class provides functionalities for managing a heap structure and manipulating entries based on their priorities.

## Part 1: Heap Implementation

In Part 1, you have implemented the Heap class that supports the following operations:

- Insertion: Add a new entry with a given key and value to the heap.
- Removal: Remove and return the entry with the highest priority (root).
- Access: Return the entry with the highest priority without removing it.
- Additional methods for navigating the heap structure, swapping entries, and maintaining the heap properties.

## Part 2: Dijkstra's Algorithm using Heap

In Part 2, you have extended the concept of the previous project (PA3) by incorporating a cost attribute to each square in the maze. The goal is to minimize the cost from the start square to the finish square using Dijkstra's algorithm along with the Heap data structure. The Heap is used as a priority queue to efficiently handle entries based on their costs.

## How to Run and Test

To run the Heap Implementation project and test the functionality, follow these steps:

1. Clone or download the project repository from GitHub.

2. Navigate to the appropriate directory for the Heap implementation.

3. Compile the Java files using a Java compiler.

4. Run the necessary test files, such as HeapTest.java and TestSolver.java, to validate the functionality of the implemented Heap and Dijkstra's algorithm.

5. Analyze the test results to ensure that all tests pass successfully.

6. Customize the project as needed and incorporate it into your own applications.

## Project Structure

The project directory contains the following files:

- Heap.java: Contains the implementation of the Heap class.
- PriorityQueue.java: Defines the interface for the PriorityQueue.
- Entry.java: Represents the entries for the heap.
- HeapTest.java: Provides unit tests for the Heap implementation.
- MazeSolver.java: Implements Dijkstra's algorithm using the Heap data structure.
- TestSolver.java: Contains additional test cases for the MazeSolver.

## Contributions and Support

This project is developed and maintained by Ramtin Kazemi. Contributions, bug reports, and feature requests are welcome. Please open an issue or submit a pull request on the project repository if you encounter any problems or have suggestions for improvement.

For any questions or assistance, please contact Ramtin Kazemi at ramkazemi@yahoo.com.

Happy coding!
