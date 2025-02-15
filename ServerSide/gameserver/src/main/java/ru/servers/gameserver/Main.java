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

package ru.servers.gameserver;

import lombok.extern.log4j.Log4j;
import ru.servers.gameserver.network.GameServer;
import ru.servers.gameserver.network.Server;

import java.io.IOException;

@Log4j
public class Main {

    static String localhost    = "127.0.0.1";
    static String RMI_HOSTNAME = "java.rmi.server.database";
    static String SERVICE_PATH = "rmi://localhost/UsersService";

    public static void main(String[] args) {
        try {
            log.info("Copyright 2018 Vladimir Balun - Game server.");
            log.info("Initialization of the gameserver server...");
            Server server = new GameServer(17017);
            server.startServer(Runtime.getRuntime().availableProcessors());
        } catch (IOException | InterruptedException  e) {
            log.fatal("Error during starting or working of the server. Cause: " + e.getMessage());
        }
    }

}
