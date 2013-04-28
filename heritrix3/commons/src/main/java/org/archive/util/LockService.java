package org.archive.util;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 
 * @author leon
 * 
 */
public class LockService {
	private final ConcurrentMap<String, Date> lockMap = new ConcurrentHashMap<String, Date>();

	public boolean tryLock(String key) {
		Date preLock = lockMap.putIfAbsent(key, new Date());
		return preLock == null;
	}

	public void unLock(String key) {
		lockMap.remove(key);
	}
}
