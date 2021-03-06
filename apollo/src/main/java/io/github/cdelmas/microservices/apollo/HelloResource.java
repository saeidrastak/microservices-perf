/*
   Copyright 2016 Cyril Delmas

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
package io.github.cdelmas.microservices.apollo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicLong;

import com.spotify.apollo.RequestContext;
import com.spotify.apollo.Response;
import io.github.cdelmas.spike.common.Message;

public class HelloResource {

    private final AtomicLong counter = new AtomicLong(0);

    public CompletionStage<Response<Message>> hello(RequestContext routingContext) {
        return CompletableFuture.completedFuture(Response.ok().withPayload(new Message("hello world " + counter.incrementAndGet())));
    }

    public void createMessage(RequestContext requestContext) {
    }
}
