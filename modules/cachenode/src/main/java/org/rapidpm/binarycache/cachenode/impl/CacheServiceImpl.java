package org.rapidpm.binarycache.cachenode.impl;

import org.rapidpm.binarycache.cachenode.api.CacheService;
import org.rapidpm.binarycache.cachenode.api.CacheStatusInformation;
import org.rapidpm.binarycache.cachenode.api.RequestStatus;

import javax.cache.Cache;
import javax.cache.Caching;
import java.util.Optional;

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
public class CacheServiceImpl implements CacheService {

  private final Cache<String, String> cache = Caching.getCache(BINARY_CACHE_NAME, String.class, String.class);

  @Override
  public RequestStatus addCacheElement(final String elementKey, final String binaryElement) {
    cache.put(elementKey, binaryElement);
    return RequestStatus.OK;
  }

  @Override
  public CacheStatusInformation cacheStatusInfo() {
    return null;
  }

  @Override
  public RequestStatus deleteCacheElement(final String elementKey) {
    return cache.remove(elementKey) ? RequestStatus.OK : RequestStatus.ERROR;
  }

  @Override
  public Optional<String> getCachedElement(final String elementKey) {
    return cache.containsKey(elementKey) ? Optional.ofNullable(cache.get(elementKey)) : Optional.empty();
  }


//  private void postconstruct() {
//    // Alternatively to request an already existing cache
//
//    // Put a value into the cache
//    cache.put("world", "Hello World");
//    // Retrieve the value again from the cache
//    String value = cache.get("world"); // Print the value ’Hello World’
//    System.out.println(value);
//  }


}
