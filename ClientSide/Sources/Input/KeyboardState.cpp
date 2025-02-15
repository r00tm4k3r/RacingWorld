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

#include "KeyboardState.hpp"

Input::KeyboardState::KeyboardState()
{
#ifdef _DEBUG
    if ( !mIsPressedKeyW.is_lock_free() ||
         !mIsPressedKeyS.is_lock_free() ||
         !mIsPressedKeyA.is_lock_free() ||
         !mIisPressedKeyD.is_lock_free() )
        LOG_WARNING("Operations with 'bool' are not lock free on current platform.");
#endif // _DEBUG
}

void Input::KeyboardState::pressKeyW() noexcept
{
    mIsPressedKeyW.store(true);
}

void Input::KeyboardState::releaseKeyW() noexcept
{
    mIsPressedKeyW.store(false);
}

void Input::KeyboardState::pressKeyS() noexcept
{
    mIsPressedKeyS.store(true);
}

void Input::KeyboardState::releaseKeyS() noexcept
{
    mIsPressedKeyS.store(false);
}

void Input::KeyboardState::pressKeyA() noexcept
{
    mIsPressedKeyA.store(true);
}

void Input::KeyboardState::releaseKeyA() noexcept
{
    mIsPressedKeyA.store(false);
}

void Input::KeyboardState::pressKeyD() noexcept
{
    mIisPressedKeyD.store(true);
}

void Input::KeyboardState::releaseKeyD() noexcept
{
    mIisPressedKeyD.store(false);
}

bool Input::KeyboardState::isPressedKeyW() const noexcept
{
    return mIsPressedKeyW.load();
}

bool Input::KeyboardState::isPressedKeyS() const noexcept
{
    return mIsPressedKeyS.load();
}

bool Input::KeyboardState::isPressedKeyA() const noexcept
{
    return mIsPressedKeyA.load();
}

bool Input::KeyboardState::isPressedKeyD() const noexcept
{
    return mIisPressedKeyD.load();
}
