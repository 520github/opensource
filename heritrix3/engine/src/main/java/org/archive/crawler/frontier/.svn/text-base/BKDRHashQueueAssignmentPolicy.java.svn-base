package org.archive.crawler.frontier;

import org.archive.modules.CrawlURI;
import org.archive.modules.net.ServerCache;
import org.springframework.beans.factory.annotation.Autowired;

public class BKDRHashQueueAssignmentPolicy extends QueueAssignmentPolicy {
    private static final int SEED = 131;

    /**
     * 
     */
    private static final long serialVersionUID = -7436858612706414070L;

    private static final int SIZE = 10;
    
    protected ServerCache serverCache;


    public ServerCache getServerCache() {
        return this.serverCache;
    }
    @Autowired
    public void setServerCache(ServerCache serverCache) {
        this.serverCache = serverCache;
    }

    private static int hash(String string) {
        int hash = 0;
        for (char c : string.toCharArray()) {
            hash = hash * SEED + c;
        }
        return hash;
    }

    @Override
    public String getClassKey(CrawlURI cauri) {
        String hopsPath = cauri.getPathFromSeed();
        
        if (cauri.isSeed() || hopsPath != null && hopsPath.length() > 0
                        && hopsPath.charAt(hopsPath.length() - 1) == 'P') {
            return "SEED";
        } else {
            return String.valueOf(hash(cauri.getUURI().toString()) % SIZE);
        }
    }

}
