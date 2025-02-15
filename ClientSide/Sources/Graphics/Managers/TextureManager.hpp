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

#pragma once

#include "../OpenGL.hpp"
#include "../Tools/BmpReader.hpp"
#include "../Components/Texture2D.hpp"
#include "../../Utils/Configuration.hpp"
#include "../../Utils/StringOperations.hpp"

namespace Graphics { namespace Managers {

    enum ETextureType
    {
        FONT_TEXTURE,
        COUNT_TEXTURE_TYPES // Used for setting size of textures array 
    };

    class TextureManager
    {
    public:
        GLvoid initializeTextures() noexcept;
        const Components::Texture2D& getTexture(ETextureType meshType) noexcept;
    private:
        Components::Texture2D createTexture(Memory::Allocators::LinearAllocator& allocator, const char* textureName) const noexcept;
    private:
        Components::Texture2D mTextures[COUNT_TEXTURE_TYPES];
    };

} }
