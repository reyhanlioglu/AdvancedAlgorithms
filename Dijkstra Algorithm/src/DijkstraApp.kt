object DijkstraApp {

    @JvmStatic
    fun main(args: Array<String>) {
        val vertexA = Vertex("A")
        val vertexB = Vertex("B")
        val vertexC = Vertex("C")
        val vertexD = Vertex("D")
        val vertexE = Vertex("E")
        val vertexF = Vertex("F")
        val vertexG = Vertex("G")
        val vertexH = Vertex("H")


        vertexA.addNeighbour(Edge(5.0, vertexA, vertexB))
        vertexA.addNeighbour(Edge(8.0, vertexA, vertexH))
        vertexA.addNeighbour(Edge(9.0, vertexA, vertexE))

        vertexB.addNeighbour(Edge(15.0, vertexB, vertexD))
        vertexB.addNeighbour(Edge(12.0, vertexB, vertexC))
        vertexB.addNeighbour(Edge(4.0, vertexB, vertexH))

        vertexC.addNeighbour(Edge(3.0, vertexC, vertexD))
        vertexC.addNeighbour(Edge(11.0, vertexC, vertexG))

        vertexD.addNeighbour(Edge(9.0, vertexD, vertexG))

        vertexE.addNeighbour(Edge(4.0, vertexE, vertexF))
        vertexE.addNeighbour(Edge(20.0, vertexE, vertexG))
        vertexE.addNeighbour(Edge(5.0, vertexE, vertexH))

        vertexF.addNeighbour(Edge(1.0, vertexF, vertexC))
        vertexF.addNeighbour(Edge(13.0, vertexF, vertexG))

        vertexH.addNeighbour(Edge(7.0, vertexH, vertexC))
        vertexH.addNeighbour(Edge(6.0, vertexH, vertexF))


        val dijkstraAlgorithm = DijkstraAlgorithm()
        dijkstraAlgorithm.calculateShortestPaths(vertexA)
        println(dijkstraAlgorithm.getShortestPathTo(vertexG))
    }
}
