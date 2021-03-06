/*******************************************************************************
 * Copyright 2015 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.badlogic.gdx.tiledmappacker;

/** Processes the maps located in gdx-tests-android: "assets/data/maps/tiled-atlas-src" Creates the directory
 * "assets/data/maps/tiled-atlas-processed/deleteMe" which contains processed maps. Run TiledMapPackerTestRender to render the
 * maps and, optionally, delete the created folder on exit. */
public class TiledMapPackerTest {

	// TestTypes "NoArgs" and "BadOption" do not create/process maps.
	public enum TestType {
		NoArgs, DefaultUsage, Verbose, IncludeUnused, CombineTilesets, UnusedAndCombine, BadOption
	}

	public static void main (String[] args) throws Exception {
		String path = "../../tests/gdx-tests-android/assets/data/maps/";
		String input = path + "tiled-atlas-src";
		String output = path + "tiled-atlas-processed/deleteMe";
		String verboseOpt = "-v";
		String unused = "--include-unused";
		String combine = "--combine-tilesets";
		String badOpt = "bad";

		TestType testType = TestType.DefaultUsage;

		String[] noArgs = {};
		String[] defaultUsage = {input, output};
		String[] verbose = {input, output, verboseOpt};
		String[] includeUnused = {input, output, unused};
		String[] combineTilesets = {input, output, combine};
		String[] unusedAndCombine = {input, output, unused, combine};
		String[] badOption = {input, output, unused, verboseOpt, combine, badOpt};

		switch (testType) {
		case NoArgs:
			TiledMapPacker.main(noArgs);
			break;
		case DefaultUsage:
			TiledMapPacker.main(defaultUsage);
			break;
		case Verbose:
			TiledMapPacker.main(verbose);
			break;
		case IncludeUnused:
			TiledMapPacker.main(includeUnused);
			break;
		case CombineTilesets:
			TiledMapPacker.main(combineTilesets);
			break;
		case UnusedAndCombine:
			TiledMapPacker.main(unusedAndCombine);
			break;
		case BadOption:
			TiledMapPacker.main(badOption);
			break;
		default:
			break;
		}
	}
}
