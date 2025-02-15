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

package ru.servers.gameserver.ecs.components;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Health implements Component, Cloneable {

    private int hp;

    public final int MIN_COUNT_HEALTH = 0;
    public final int MAX_COUNT_HEALTH = 100;

    public Health(int countHealth){
        if (countHealth > MAX_COUNT_HEALTH) {
            hp = MAX_COUNT_HEALTH;
        }
        if (countHealth < MIN_COUNT_HEALTH) {
            hp = MIN_COUNT_HEALTH;
        }
    }

    public void setHP(int newCountHealth) {
        if (newCountHealth > MAX_COUNT_HEALTH) {
            hp = MAX_COUNT_HEALTH;
        }
        if (newCountHealth < MIN_COUNT_HEALTH) {
            hp = MIN_COUNT_HEALTH;
        }
    }

    public int getHP() {
        return hp;
    }

    @Override
    public Health clone() {
        try {
            return (Health)super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

}
