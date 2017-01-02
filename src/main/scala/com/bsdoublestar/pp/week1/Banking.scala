package com.bsdoublestar.pp.week1

/**
  * Created by d041254 on 1/2/17.
  */
object Banking {
  def atomicTransferThread(a: Account, b: Account, transferAmount: Int) = {
    val t = new Thread {
      override def run() = {
        for (i <- 0 until transferAmount) a.transfer(b,1)
      }
    }
    t.start()
    t
  }
}
