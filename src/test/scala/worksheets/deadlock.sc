import com.bsdoublestar.pp.week1.{Account, Banking}

val sourceAccount = new Account(15000)
val targetAccount = new Account(4000)

val transactionThread1 = Banking.atomicTransferThread(sourceAccount,targetAccount,1234)
val transactionThread2 = Banking.atomicTransferThread(targetAccount,sourceAccount,1234)

transactionThread1.join()
transactionThread2.join()

// the following code is never reached!
// transactionThread1 blocks sourceAccount and tries to obtain a block on targetAccount
// transactionThread2 blocks targetAccount and tries to obtain a block on sourceAccount
// both wait until the block of the other is over...
sourceAccount
targetAccount

