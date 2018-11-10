/*
 * Copyright 2018 Vladimir Balun
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.servers.authorizationServer.network;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import ru.servers.authorizationServer.network.protocol.AuthorizationRequest;

@Log4j
@Component
public class AuthorizationHandler implements NetworkHandler {

    @Override
    public boolean handleRequest(AuthorizationRequest request) {
        return true;
    }

}
