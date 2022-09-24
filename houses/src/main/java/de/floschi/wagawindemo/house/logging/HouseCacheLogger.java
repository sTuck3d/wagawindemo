package de.floschi.wagawindemo.house.logging;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HouseCacheLogger implements CacheEventListener<Object, Object> {

    Logger logger = LoggerFactory.getLogger(HouseCacheLogger.class);

    @Override
    public void onEvent(
            CacheEvent<?, ?> cacheEvent) {
        logger.debug("Cache-Event {}: Key:{}, Old:{}, New:{}",
                cacheEvent.getType(), cacheEvent.getKey(), cacheEvent.getOldValue(), cacheEvent.getNewValue());
    }
}
