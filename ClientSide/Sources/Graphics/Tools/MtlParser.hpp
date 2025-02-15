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

#include "../Components/Material.hpp"
#include "../../Utils/DataStructures/Vector.hpp"
#include "../../Memory/Allocators/LinearAllocator.hpp"

namespace Graphics { namespace Tools {

    // DOD design
    struct Materials 
    {
        Vector<const char*> name;
        Vector<Components::Material> material;
    };

    class MtlParser
    {
    public:
        explicit MtlParser() noexcept
            : mStringsAllocator(30) {}
        void parseMaterials(const char* mtlFileName, Materials& materials);
    private:
        Memory::Allocators::LinearAllocator mStringsAllocator;
    };

} }