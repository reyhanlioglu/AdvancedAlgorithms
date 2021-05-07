import java.util.*

class DijkstraAlgorithm {

    fun calculateShortestPaths(sourceVertex: Vertex) {
        sourceVertex.distance = 0.0
        val priorityQueue = PriorityQueue<Vertex>()
        priorityQueue.add(sourceVertex)

        while (!priorityQueue.isEmpty()) {
            val currentVertex = priorityQueue.poll()

            for (edge in currentVertex.adjacencyList) {
                val targetVertex: Vertex = edge.targetVertex
                val newDistance: Double = currentVertex.distance + edge.weight

                if (newDistance < targetVertex.distance) {
                    priorityQueue.remove(targetVertex)
                    targetVertex.distance = newDistance
                    targetVertex.predecessor = currentVertex
                    priorityQueue.add(targetVertex)
                }
            }
        }
    }

    fun getShortestPathTo(targetVertex: Vertex): String{
        val path: MutableList<Vertex> = ArrayList()
        var vertex: Vertex? = targetVertex

        while (vertex != null) {
            path.add(vertex)
            vertex = vertex.predecessor
        }
        path.reverse()

        return path.toString() +
                "\nMin distance from ${path.first().name} to ${path.last().name} is " +
                path.last().distance.toString()
    }
}
