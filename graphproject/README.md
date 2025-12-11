CSE 464 – Course Project Part 3
Refactoring Directed Graph Search Using Template & Strategy Patterns

Author: Abdalla Osman
Semester: Fall 2025
Instructor: Dr. Robert Atkinson

1. Overview

In this part of the project, the original search algorithms (BFS, DFS, Random Walk) were refactored to use:

-Template Method Pattern
-Strategy Pattern

This refactor improves modularity, removes duplicated logic, supports flexibility in choosing search algorithms at runtime, and prepares the system for future extension (e.g., Dijkstra, A*, bidirectional search).

The new architecture separates:

Graph parsing

Graph management

Search algorithm selection

Search execution

This results in a clean, extensible, object-oriented design.

2. Template Method Pattern

The Template Method Pattern provides a generalized workflow for graph searches.

We created:

SearchTemplate (abstract)
    ├── BFSSearch
    └── DFSSearch

Features of SearchTemplate

Defines the skeleton of a search:

initialize()

getNextNode()

isFinished()

expand()

buildPath()

Removes duplicate logic previously found in BFS and DFS.

Allows all search algorithms to follow the same high-level flow.

Benefits

BFS and DFS share a consistent structure.

New search algorithms can be added with minimal work.

Code is cleaner, reusable, and aligned with object-oriented practices.

3. Strategy Pattern

To support dynamic selection of search algorithms at runtime, we added:

SearchStrategy (interface)
    ├── BFSStrategy
    ├── DFSStrategy
    └── RandomWalkStrategy


With:

Algorithm enum { BFS, DFS, RANDOM }


And GraphManager now exposes:

public Path runSearch(String src, String dst, Algorithm algo)

Benefits

Main program no longer directly calls BFS/DFS/Random Walk.

Strategies are hot-swappable.

Adding new algorithms requires no changes to Main or GraphManager.

Keeps the system open for extension, closed for modification.

4. Updated Architecture
New Key Classes
Class	Role
SearchTemplate	Abstract base class defining search workflow
BFSSearch	Concrete BFS using Template Method
DFSSearch	Concrete DFS using Template Method
SearchStrategy	Strategy interface for runtime algorithm selection
BFSStrategy	Adapter for BFSSearch
DFSStrategy	Adapter for DFSSearch
RandomWalkStrategy	Adapter for Random Walk
GraphManager	Selects strategies via runSearch()
Algorithm	Enum for BFS, DFS, RANDOM
Main	Demonstrates usage of Strategy + Template Patterns
5. Example Usage
Run BFS
Path bfs = gm.runSearch("a", "h", Algorithm.BFS);

Run DFS
Path dfs = gm.runSearch("a", "h", Algorithm.DFS);

Run Random Walk
Path walk = gm.runSearch("a", "h", Algorithm.RANDOM);

6. Example Output
BFS
BFS Path: a -> e -> f -> h

DFS
DFS Path: a -> b -> c -> d -> a -> e -> g -> h


(Output may vary based on edge order.)

Random Walk (5 runs)
Random Attempt 1: a -> e -> f -> h
Random Attempt 2: a -> e -> g -> h
Random Attempt 3: a -> e -> f -> h
Random Attempt 4: a -> b -> c -> d
Random Attempt 5: a -> e -> g -> h

7. Refactor Commit History (Required)

Paste your actual GitHub commit URLs under each section.

Commit 1 – Introduced Template Method Base
Refactor: Introduced SearchTemplate abstract class to unify search algorithm structure.
Commit URL: bfc36c63e0f8840e1f3b2ae5d93e0dceb92f7986

Commit 2 – Implemented BFSSearch & DFSSearch
Refactor: Implemented BFSSearch and DFSSearch as concrete subclasses of SearchTemplate.
Commit URL: 87e45f1be2e64178c3a4d4a3c15d84a5b9284984

Commit 3 – Added Strategy Pattern
Refactor: Added Strategy Pattern including BFS, DFS, and RandomWalk strategies.
Commit URL: 08976ed1c4ee658b7afdc739f0b6582ebaeb20c8

Commit 4 – Added runSearch() to GraphManager
Enhancement: Added strategy-based runSearch() dispatcher to GraphManager.
Commit URL: 6190af45259d34e675958e6e8a45eb4dddf2bf9c

Commit 5 – Updated Main.java
Refactor: Updated Main.java to use Strategy + Template patterns.
Commit URL: 37017b339eaac05d1f9505a8953a4045624f9312

8. How to Run the Project
Compile
mvn clean compile

Run
mvn exec:java -Dexec.mainClass="edu.asu.cse464.graphproject.Main"

Run Tests
mvn -q test

9. Conclusion

This refactoring significantly improved the modularity and extensibility of the project. The Template Method Pattern standardized search algorithm structure, while the Strategy Pattern enabled dynamic selection of BFS, DFS, and Random Walk.

The system now follows software engineering best practices and is aligned with the design principles taught in CSE 464.
