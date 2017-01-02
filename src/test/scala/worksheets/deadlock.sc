import com.bsdoublestar.pp.week1.{Account, Banking}

val sourceAccount = new Account(15000)
val targetAccount = new Account(4000)

val transactionThread1 = Banking.atomicTransferThread(sourceAccount,targetAccount,1234)
val transactionThread2 = Banking.atomicTransferThread(targetAccount,sourceAccount,1234)

transactionThread1.join()
transactionThread2.join()

// now the coding is reached!
// locking of accounts happens in sequence of their uids
sourceAccount
targetAccount

