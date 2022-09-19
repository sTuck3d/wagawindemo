package de.floschi.wagawindemo.family.util;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParentSummaryCacheLogger implements CacheEventListener<Object, Object> {

    Logger logger = LoggerFactory.getLogger(ParentSummaryCacheLogger.class);

    @Override
    public void onEvent(
            CacheEvent<?, ?> cacheEvent) {
        logger.debug("Cache-Event {}: Key:{}, Old:{}, New:{}",
                cacheEvent.getType(), cacheEvent.getKey(), cacheEvent.getOldValue(), cacheEvent.getNewValue());
    }
}
