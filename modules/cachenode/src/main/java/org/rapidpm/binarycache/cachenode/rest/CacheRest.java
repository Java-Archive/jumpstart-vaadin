package org.rapidpm.binarycache.cachenode.rest;

import org.rapidpm.binarycache.cachenode.api.CacheService;
import org.rapidpm.binarycache.cachenode.api.CacheStatusInformation;
import org.rapidpm.binarycache.cachenode.api.RequestStatus;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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

@Path("/cache")
public class CacheRest {

  @Inject CacheService cacheService;

  @GET()
  @Produces("text/plain")
  public String get() {
    return "Hello World";
//    return new Gson().toJson(dataHolder);
  }


  public RequestStatus addCacheElement(final String elementKey, final String binaryElement) {
    return cacheService.addCacheElement(elementKey, binaryElement);
  }

  public CacheStatusInformation cacheStatusInfo() {
    return cacheService.cacheStatusInfo();
  }

  public RequestStatus deleteCacheElement(final String elementKey) {
    return cacheService.deleteCacheElement(elementKey);
  }
}
