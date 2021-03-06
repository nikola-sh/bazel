// Copyright 2019 The Bazel Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.devtools.build.android.desugar.nest;

import org.objectweb.asm.Opcodes;

/** Shared constants of Nest-accessed desugar. */
class NestDesugarConstants {

  static final int MIN_VERSION = Opcodes.V1_8;
  static final String CONSTRUCTOR_NAME = "<init>";
  static final String NEST_COMPANION_CLASS_SIMPLE_NAME = "NestCC";
  static final int NEST_COMPANION_CLASS_ACCESS_CODE =
      Opcodes.ACC_SYNTHETIC | Opcodes.ACC_ABSTRACT | Opcodes.ACC_STATIC;

  private NestDesugarConstants() {}
}
