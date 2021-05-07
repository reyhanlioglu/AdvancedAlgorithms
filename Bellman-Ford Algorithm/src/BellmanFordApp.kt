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

object BellmanFordApp {
    @JvmStatic
    fun main(args: Array<String>) {

        val vertexList = ArrayList<Vertex>()
        val edgeList = ArrayList<Edge>()

        val vertexA = Vertex("A")
        val vertexB = Vertex("B")
        val vertexC = Vertex("C")
        val vertexD = Vertex("D")

        vertexList.add(vertexA)
        vertexList.add(vertexB)
        vertexList.add(vertexC)
        vertexList.add(vertexD)

        edgeList.add(Edge(1.0, vertexList[0], vertexList[1]))
        edgeList.add(Edge(3.0, vertexList[0], vertexList[2]))
        edgeList.add(Edge(1.0, vertexList[1], vertexList[2]))
        edgeList.add(Edge(4.0, vertexList[2], vertexList[3]))

        val bellmanFordAlgorithm = BellmanFordAlgorithm(edgeList, vertexList)
        bellmanFordAlgorithm.calculateShortestPaths(vertexList[0])
        print(bellmanFordAlgorithm.shortestPathTo(vertexList[3]))
    }
}