package com.bsdoublestar.pp.week1

/**
  * Created by d041254 on 1/2/17.
  */
class Account(private var amount: Int = 0) {
  val uid = IdGenerator.getSynchronizedUniqueId()
  def transfer(that: Account, transferAmount: Int) =
    this.synchronized {
      that.synchronized {
        this.amount -= transferAmount
        that.amount += transferAmount
      }
    }
  override def toString = "Balance: " + amount
}
