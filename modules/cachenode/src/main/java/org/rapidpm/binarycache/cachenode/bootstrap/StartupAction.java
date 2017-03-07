package org.rapidpm.binarycache.cachenode.bootstrap;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.rapidpm.ddi.DI;
import org.rapidpm.microservice.Main;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.CompleteConfiguration;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;
import java.util.Optional;

import static org.rapidpm.binarycache.cachenode.api.CacheService.BINARY_CACHE_NAME;

/**
 * Copyright (C) 2017 RapidPM - Sven Ruppert
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Created by Sven Ruppert - RapidPM - Team on 12.02.17.
 */
public class StartupAction implements Main.MainStartupAction {
  @Override
  public void execute(final Optional<String[]> optional) {
    DI.clearReflectionModel();
    DI.activatePackages("org.rapidpm");

    // config stuff done here
    final HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();


    // Retrieve the CachingProvider which is automatically backed by
    // the chosen Hazelcast member or client provider
    final CachingProvider cachingProvider = Caching.getCachingProvider();
    // Create a CacheManager
    final CacheManager cacheManager = cachingProvider.getCacheManager();
    // Create a simple but typesafe configuration for the cache
    final CompleteConfiguration<String, String> config = new MutableConfiguration<String, String>()
        .setTypes(String.class, String.class);
    // Create and get the cache
    final Cache<String, String> cache = cacheManager.createCache(BINARY_CACHE_NAME, config);
    cacheManager.enableStatistics(BINARY_CACHE_NAME, true);
    cacheManager.enableManagement(BINARY_CACHE_NAME, true);
  }
}
