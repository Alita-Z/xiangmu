package com.example.hardcoredemo.common.cache;

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

public class Cache {


    private LoadingCache<String/**domainKey**/, ImportDomainConfig /**config**/> importDomainConfigLoadingCache = Caffeine.newBuilder()
            .maximumSize(700)
            .expireAfterAccess(2L, TimeUnit.MINUTES)
            .build(new CacheLoader<String, ImportDomainConfig>() {
                @Override
                public ImportDomainConfig load(String key) throws Exception {
                    return new ImportDomainConfig();
                }
            });


    public static void main(String[] args) {
        LoadingCache<String/**domainKey**/, ImportDomainConfig /**config**/> importDomainConfigLoadingCache = Caffeine.newBuilder()
                .maximumSize(700)
                .expireAfterAccess(2L, TimeUnit.MINUTES)
                .build(new CacheLoader<String, ImportDomainConfig>() {
                    @Override
                    public ImportDomainConfig load(String key) throws Exception {
                        return new ImportDomainConfig();
                    }
                });
         importDomainConfigLoadingCache.get("domainKey");

    }
}
