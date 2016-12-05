object Distance {
    var xStart: Int = 0
    var yStart: Int = 0
//    val DIRECTIONS: Array<String> = arrayOf("N", "E", "S", "W")

    val INPUT = arrayOf("R3", "R1", "R4", "L4", "R3", "R1", "R1", "L3", "L5", "L5", "L3", "R1", "R4", "L2", "L1", "R3", "L3", "R2", "R1", "R1", "L5", "L2", "L1", "R2", "L4", "R1", "L2", "L4", "R2", "R2", "L2", "L4", "L3", "R1", "R4", "R3", "L1", "R1", "L5", "R4", "L2", "R185", "L2", "R4", "R49", "L3", "L4", "R5", "R1", "R1", "L1", "L1", "R2", "L1", "L4", "R4", "R5", "R4", "L3", "L5", "R1", "R71", "L1", "R1", "R186", "L5", "L2", "R5", "R4", "R1", "L5", "L2", "R3", "R2", "R5", "R5", "R4", "R1", "R4", "R2", "L1", "R4", "L1", "L4", "L5", "L4", "R4", "R5", "R1", "L2", "L4", "L1", "L5", "L3", "L5", "R2", "L5", "R4", "L4", "R3", "R3", "R1", "R4", "L1", "L2", "R2", "L1", "R4", "R2", "R2", "R5", "R2", "R5", "L1", "R1", "L4", "R5", "R4", "R2", "R4", "L5", "R3", "R2", "R5", "R3", "L3", "L5", "L4", "L3", "L2", "L2", "R3", "R2", "L1", "L1", "L5", "R1", "L3", "R3", "R4", "R5", "L3", "L5", "R1", "L3", "L5", "L5", "L2", "R1", "L3", "L1", "L3", "R4", "L1", "R3", "L2", "L2", "R3", "R3", "R4", "R4", "R1", "L4", "R1", "L5")

    @JvmStatic fun main(args: Array<String>) {
        println(getDistance(getFinishLocation(xStart, yStart, 0, INPUT)))
    }

    fun getFinishLocation(x: Int, y: Int, facing: Int, input: Array<String>): Pair<Int, Int> {
        var facing: Int = facing
        var x: Int = x
        var y: Int = y

        for (coord in input) {
            val letter = coord.substring(0, 1)
            val distance = coord.substring(1, coord.length)

            if (letter.equals("R")) {
                facing++
                if (facing >= 4) facing = 0
            } else {
                facing--
                if (facing <= -1) facing = 3
            }

//            print("distance: " + distance.toInt() + " | ")
            if (facing == 0) y += distance.toInt()
            else if (facing == 1) x += distance.toInt()
            else if (facing == 2) y -= distance.toInt()
            else if (facing == 3) x -= distance.toInt()

//            println("coord: $coord | facing: $facing | xStart: $x | yStart: $y")
        }

        return Pair(x, y)
    }

    fun getDistance(xAndY: Pair<Int, Int>): Int {
        var (x, y) = xAndY

        return x.abs() + y.abs()
    }

    fun Int.abs(): Int = if (this >= 0) this else -this
}