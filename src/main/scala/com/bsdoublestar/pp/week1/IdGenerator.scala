package com.bsdoublestar.pp.week1

/**
  * Created by d041254 on 12/31/16.
  */
object IdGenerator {
  private val syncField = new AnyRef {}
  private var uid       = 0L
  private var syncedUid = 0L

  def getUniqueId: Long = {
    uid += 1
    uid
  }

  def getSynchronizedUniqueId: Long =
    syncField.synchronized {
      syncedUid += 1
      syncedUid
    }

}
