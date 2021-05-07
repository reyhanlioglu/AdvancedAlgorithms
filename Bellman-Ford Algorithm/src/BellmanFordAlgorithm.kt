import java.lang.Exception

/*
 * MIT License
 *
 * Copyright (c) 2021 Emre Reyhanlioglu
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

class BellmanFordAlgorithm(
    private var edgeList: List<Edge>,
    private var vertexList: List<Vertex>
) {
    private var sourceVertex: Vertex? = null

    fun calculateShortestPaths(sourceVertex: Vertex) {
        sourceVertex.distance = 0.0
        this.sourceVertex = sourceVertex

        for (vertex in vertexList) {
            for(edge in edgeList) {

                if(edge.startVertex.distance == Double.MAX_VALUE) {
                    continue
                }

                val newDistance = edge.startVertex.distance + edge.weight

                if(newDistance < edge.targetVertex.distance) {
                    edge.targetVertex.distance = newDistance
                    edge.targetVertex.previousVertex = edge.startVertex
                }
            }
        }

        for(edge in edgeList) {
            if(edge.startVertex.distance != Double.MAX_VALUE) {
                if(hasCycle(edge)) {
                    println("Cycle detected!")
                }
            }
        }
    }

    fun shortestPathTo(targetVertex: Vertex): String {
        if(sourceVertex == null){
            throw Exception("Shortest path did not calculated yet! Call calculateShortestPaths method before using this.")
        }

        if(targetVertex.distance == Double.MAX_VALUE) {
            println("There is not any path from starting vertex to the target vertex")
        }

        var currentVertex: Vertex? = targetVertex
        val path: MutableList<Vertex> = ArrayList()

        while (currentVertex?.previousVertex != null) {
            path.add(currentVertex)
            currentVertex = currentVertex.previousVertex
        }

        path.add(sourceVertex!!)
        path.reverse()

        return path.toString() +
                "\nMin distance from ${path.first().name} to ${path.last().name} is " +
                path.last().distance.toString()
    }

    private fun hasCycle(edge: Edge): Boolean {
        return edge.targetVertex.distance > edge.startVertex.distance + edge.weight
    }
}