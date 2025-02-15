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

package ru.servers.protocol.clientwithgameserver.fromserver;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import ru.servers.protocol.clientwithgameserver.common.Primitives;
import ru.servers.protocol.clientwithgameserver.NetworkPacket;
import ru.servers.protocol.clientwithgameserver.PacketType;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class WorldActionPacket extends NetworkPacket implements PacketFromServer {

    // Byte protocol:
    // [0] - protocol type
    // [1...4] - packet number
    // [5] - count players
    // for (byte i = 0; i < countPlayers; i++)
    //   [(START_POSITION_PLAYER_POSITION * i)...((START_POSITION_PLAYER_POSITION + VECTOR_SIZE) * i)] - position
    //   [(START_POSITION_PLAYER_DIRECTION * i)...((START_POSITION_PLAYER_DIRECTION + VECTOR_SIZE) * i)] - direction

    private final byte countPlayers;

    private final static byte POSITION_TOKEN = 5;
    private final static byte SIZE_TOKEN = Primitives.INT_SIZE;

    private final static byte START_POSITION_PLAYER_POSITION = 6;
    private final static byte START_POSITION_PLAYER_DIRECTION = 18;
    private final static byte VECTOR_SIZE = Primitives.FLOAT_SIZE * 4;
    private final static byte PLAYER_LOCATION_SIZE = VECTOR_SIZE * 2;

    public final static byte SIZE_PACKET_WITHOUT_PLAYERS = SIZE_NETWORK_PACKET + SIZE_TOKEN;

    public WorldActionPacket(int countPlayers) {
        super(new byte[SIZE_PACKET_WITHOUT_PLAYERS + (countPlayers * PLAYER_LOCATION_SIZE)]);
        this.countPlayers = (byte) countPlayers;
        buffer[POSITION_PACKET_TYPE] = PacketType.WORLD_ACTION_PACKET;
    }

    @Override
    public byte[] getBuffer() {
        return buffer;
    }

}
