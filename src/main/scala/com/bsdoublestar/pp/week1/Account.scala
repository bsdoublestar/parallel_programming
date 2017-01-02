package com.bsdoublestar.pp.week1

/**
  * Created by d041254 on 1/2/17.
  */
class Account(private var amount: Int = 0) {

  val uid = IdGenerator.getSynchronizedUniqueId

  private def lockAndTransfer(that: Account, transferAmount: Int) =
    this.synchronized {
      that.synchronized {
        this.amount -= transferAmount
        that.amount += transferAmount
      }
    }

  def transfer(that: Account, transferAmount: Int) =
    if (this.uid < that.uid) this.lockAndTransfer(that, transferAmount)
    // need to reverse order AND reverse also transferred amount!
    else that.lockAndTransfer(this, -transferAmount)

  override def toString = "Balance: " + amount

}
