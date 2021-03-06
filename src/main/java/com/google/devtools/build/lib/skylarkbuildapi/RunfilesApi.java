// Copyright 2014 The Bazel Authors. All rights reserved.
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

package com.google.devtools.build.lib.skylarkbuildapi;

import com.google.devtools.build.lib.skylarkinterface.Param;
import com.google.devtools.build.lib.skylarkinterface.SkylarkCallable;
import com.google.devtools.build.lib.skylarkinterface.SkylarkModule;
import com.google.devtools.build.lib.skylarkinterface.SkylarkModuleCategory;
import com.google.devtools.build.lib.syntax.Depset;
import com.google.devtools.build.lib.syntax.StarlarkValue;

/** An interface for a set of runfiles. */
@SkylarkModule(
    name = "runfiles",
    category = SkylarkModuleCategory.BUILTIN,
    doc =
        "A container of information regarding a set of files required at runtime execution. This"
            + " object should be passed via <a href=\"DefaultInfo.html\">DefaultInfo</a> in order"
            + " to tell the build system about the runfiles needed by the outputs produced by the"
            + " rule. See <a href=\"../rules.html#runfiles\">runfiles guide</a> for details.")
public interface RunfilesApi extends StarlarkValue {

  @SkylarkCallable(
      name = "files",
      doc = "Returns the set of runfiles as files.",
      structField = true)
  public Depset /*<? extends FileApi>*/ getArtifactsForStarlark();

  @SkylarkCallable(name = "symlinks", doc = "Returns the set of symlinks.", structField = true)
  public Depset /*<? extends SymlinkEntryApi>*/ getSymlinksForStarlark();

  @SkylarkCallable(
      name = "root_symlinks",
      doc = "Returns the set of root symlinks.",
      structField = true)
  public Depset /*<? extends SymlinkEntryApi>*/ getRootSymlinksForStarlark();

  @SkylarkCallable(
      name = "empty_filenames",
      doc = "Returns names of empty files to create.",
      structField = true)
  public Depset /*<String>*/ getEmptyFilenamesForStarlark();

  @SkylarkCallable(
    name = "merge",
    doc =
        "Returns a new runfiles object that includes all the contents of this one and the "
            + "argument.",
    parameters = {
        @Param(
            name = "other",
            positional = true,
            named = false,
            type = RunfilesApi.class,
            doc = "The runfiles object to merge into this."
        ),
    }
  )
  public RunfilesApi merge(RunfilesApi other);
}
