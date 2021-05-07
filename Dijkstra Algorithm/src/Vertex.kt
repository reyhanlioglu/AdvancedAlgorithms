class Vertex(var name: String) : Comparable<Vertex> {

    var adjacencyList: MutableList<Edge> = ArrayList()
    var predecessor: Vertex? = null
    var distance = Double.MAX_VALUE

    override fun toString(): String {
        return name
    }

    override operator fun compareTo(other: Vertex): Int {
        return distance.compareTo(other.distance)
    }

    fun addNeighbour(edge: Edge) {
        adjacencyList.add(edge)
    }
}
