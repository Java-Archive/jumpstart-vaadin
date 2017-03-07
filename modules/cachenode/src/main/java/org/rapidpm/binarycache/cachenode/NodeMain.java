package org.rapidpm.binarycache.cachenode;

import org.rapidpm.binarycache.cachenode.api.CacheService;
import org.rapidpm.ddi.DI;

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
 * Created by Sven Ruppert - RapidPM - Team on 11.02.17.
 */
public class NodeMain {

  public static void main(String[] args) {
    DI.activatePackages("org.rapidpm");
    final CacheService cacheService = DI.activateDI(CacheService.class);
    System.out.println("service = " + cacheService);

//    RouteOverview.enableRouteOverview("/debug/routeoverview/");
//
//    get("/hello", (req, res) -> "Hello World");
//
//
//    final Route route = (Request req, Response res) -> {
//      Spark.stop();
//      return "Shutting down";
//    };
//    get("/stop", route)
//    ;
  }


}
