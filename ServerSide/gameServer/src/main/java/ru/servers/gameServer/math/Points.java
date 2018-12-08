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

package ru.servers.gameServer.math;

public class Points {

    public static double getLengthBetweenTwoPoints(Point2 point, Point2 anotherPoint){
        double absDifferenceX = point.getX() - anotherPoint.getX();
        double absDifferenceY = point.getY() - anotherPoint.getY();
        return Math.sqrt(absDifferenceX*absDifferenceX + absDifferenceY*absDifferenceY);
    }

    public static double getLengthBetweenTwoPoints(Point3 point, Point3 anotherPoint){
        double absDifferenceX = point.getX() - anotherPoint.getX();
        double absDifferenceY = point.getY() - anotherPoint.getY();
        double absDifferenceZ = point.getZ() - anotherPoint.getZ();
        return Math.sqrt(absDifferenceX*absDifferenceX +
                         absDifferenceY*absDifferenceY +
                         absDifferenceZ*absDifferenceZ);
    }

}