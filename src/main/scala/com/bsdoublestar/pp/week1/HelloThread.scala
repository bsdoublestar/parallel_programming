package com.bsdoublestar.pp.week1

/**
  * Created by d041254 on 12/31/16.
  */
class HelloThread extends Thread {
    override def run() {
      println("Hello")
      println("World!")
    }
}
