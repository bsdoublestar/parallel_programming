import com.bsdoublestar.pp.week1.{Account, Banking}

val a1 = new Account(15000)
val a2 = new Account(4000)

a1
a2

val transactionThread = Banking.atomicTransferThread(a1,a2,1234)

a1
a2

transactionThread.join()

