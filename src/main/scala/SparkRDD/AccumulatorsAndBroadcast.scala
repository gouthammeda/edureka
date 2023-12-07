package SparkRDD
import utilities.sparkconfig.sc
/* Created by gouthamkumarreddymeda on 4/17/23 */
object AccumulatorsAndBroadcast {
  def main(args: Array[String]) {

    //RDD Partition and Achieving parallelism
    //shared variables
    //with broadcast variables are shipped to all executors and cached for future reference.
    val broadcastVar = sc.broadcast(Array(1, 2, 3))
    broadcastVar.value.foreach(println)

    //Accumulators: used for aggregating information across executors like number of records
    // are corrupted or calls made to a library api
    val accum = sc.longAccumulator("My Accumulator")
    sc.parallelize(Array(1, 2, 3, 4)).foreach(x => accum.add(x))
    println(accum.value)
  }
}