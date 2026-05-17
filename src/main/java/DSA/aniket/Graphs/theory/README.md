# Graph Terminologies Reference Guide

A graph is a fundamental data structure in computer science and mathematics used to model relationships between
different objects. This guide provides a breakdown of the essential terminologies used when working with graphs, grouped
by category.

---

## 1. The Core Components

* **Graph:** A collection of nodes connected by links. It is mathematically represented as $G = (V, E)$, where $V$ is a
  set of vertices and $E$ is a set of edges.
* **Vertex (or Node):** The fundamental unit of a graph. It represents an entity, such as a person in a social network
  or a city on a map.
* **Edge (or Arc, Link):** The line that connects two vertices, representing a relationship or pathway between them.

## 2. Edge Characteristics

* **Directed Graph (Digraph):** A graph where edges have a specific direction (represented by arrows). You can only
  travel from one vertex to another in the direction of the arrow.
* **Undirected Graph:** A graph where edges have no direction. The relationship is mutual, meaning you can travel back
  and forth between connected vertices.
* **Weighted Graph:** A graph where edges have a value or "weight" assigned to them. This weight often represents cost,
  distance, or time.
* **Unweighted Graph:** A graph where edges have no assigned values; all edges are considered equal.

## 3. Relationships and Connections

* **Adjacent Vertices (Neighbors):** Two vertices are adjacent if they are directly connected by a single edge.
* **Degree:** The total number of edges connected to a specific vertex.
    * **In-degree:** In a directed graph, the number of edges coming *into* a vertex.
    * **Out-degree:** In a directed graph, the number of edges going *out* of a vertex.
* **Self-loop:** An edge that connects a vertex to itself.
* **Parallel Edges (Multiple Edges):** Two or more edges that connect the exact same pair of vertices in the same
  direction. (A graph with parallel edges or self-loops is often called a **Multigraph**).

## 4. Movement and Structure

* **Path:** A sequence of alternating vertices and edges that takes you from a starting vertex to an ending vertex
  without revisiting any vertex or edge.
* **Cycle:** A path that starts and ends at the exact same vertex, forming a closed loop.
* **Acyclic Graph:** A graph that contains absolutely no cycles.
    * *Note: A Directed Acyclic Graph is commonly referred to as a **DAG**.*
* **Connected Graph:** An undirected graph where there is at least one path between every single pair of vertices. (No
  vertices or clusters are isolated).
* **Disconnected Graph:** A graph where it is impossible to reach some vertices from others because there is no
  connecting path.
* **Strongly Connected:** A term used for *directed* graphs. It means there is a directed path from *any* vertex to
  *every other* vertex.
* **Subgraph:** A smaller graph formed by taking a subset of vertices and edges from a larger parent graph.

----