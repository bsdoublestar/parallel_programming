package com.bsdoublestar.pp.week1

/**
  * Created by d041254 on 12/31/16.
  */
object ThreadsWithIds {

  private def startThread(f: Long) = {
    val t = new Thread {
      override def run() {
        val uids = for (i <- 0 until 30) yield f()
        println(uids)
      }
    }
    t.start()
    t
  }

  def startNThreads = {
    startThread(IdGenerator.getUniqueId); startThread(IdGenerator.getUniqueId); startThread(IdGenerator.getUniqueId)
//   leads to non-overlapping Ids for this small test:  for (i <- 0 until n) startThread(IdGenerator.getUniqueId)
  }


  def startNSyncedThreads = {
    startThread(IdGenerator.getSynchronizedUniqueId); startThread(IdGenerator.getSynchronizedUniqueId); startThread(IdGenerator.getSynchronizedUniqueId)
    //   leads to non-overlapping Ids for this small test:  for (i <- 0 until n) startThread(IdGenerator.getUniqueId)
  }
}
