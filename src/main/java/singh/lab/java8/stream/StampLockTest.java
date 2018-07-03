package singh.lab.java8.stream;

import java.util.concurrent.locks.StampedLock;

public class StampLockTest {

	public static void main(String[] args) {
		StampedLock lock = new StampedLock();
		
		System.out.println(lock.readLock());
		System.out.println(lock.readLock());
		//lock.unlockRead(new Long(257));
		//lock.unlockRead(new Long(258));
		
		lock.tryUnlockRead();
		lock.tryUnlockRead();
		
		System.out.println(lock.writeLock());
		lock.unlockWrite(new Long(384));
		System.out.println(lock.readLock());
		System.out.println(lock.readLock());

	}

}
