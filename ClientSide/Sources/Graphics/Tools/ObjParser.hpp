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

#include "../Components/Mesh.hpp"
#include "../../Utils/FileSystem.hpp"
#include "../../EventSystem/EventManager.hpp"
#include "../../Utils/DataStructures/Vector.hpp"
#include "../../Memory/Allocators/LinearAllocator.hpp"

namespace Graphics { namespace Tools {

    class ObjParser 
    {
    public:
        explicit ObjParser(Memory::Allocators::LinearAllocator& meshAllocator) noexcept
            : mMeshAllocator(meshAllocator), mStringsAllocator(1000) {}
        Components::Mesh parse(const char* objFileName) noexcept;
    private:
        void parseVertices(char* line, Vector<Math::Vector3f>& vertices) noexcept;
        void parseTextureCoordinates(const char* line, Vector<Math::Vector2f>& textureCoordinates) noexcept;
        void parseNormals(const char* line, Vector<Math::Vector3f>& normals) noexcept;
        void parseFaceElementIndexes(const char* line, Vector<Math::Vector3i>& faceElementIndexes) noexcept;
        Components::Mesh createMesh(const Vector<Math::Vector3f>& vertices, const Vector<Math::Vector2f>& textureCoordinates,
            const Vector<Math::Vector3f>& normals, const Vector<Math::Vector3i>& faceElementIndexes) noexcept;
    private:
        Memory::Allocators::LinearAllocator& mMeshAllocator;
        Memory::Allocators::LinearAllocator mStringsAllocator;
    };

} }
