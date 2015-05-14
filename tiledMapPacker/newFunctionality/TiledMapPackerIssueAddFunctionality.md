Adds/Changes the following
  - Searches for maps in nested folders, regardless of depth
  - Creates an individual atlas for each map (uses the map name sans extension)
  - Fixes the problem of not locating tilesets with ../ in the map
      Note: This has only been fixed with the new functionality (no args)
      The old method of combining tilesets into one atlas still has this
      problem.
  - Old functionality can be called with the option "--combine-tilesets"
  - Adds two classes to test the options and renders the processed maps

Changes usage to:
  Usage: INPUTDIR [OUTPUTDIR] [--include-unused] [--combine-tilesets] [-v]

Default behavior now strips unused tiles and creates an atlas for each map.

Adds a new usage prompt that lists/hints at issues:

Usage: INPUTDIR [OUTPUTDIR] [--include-unused] [--combine-tilesets] [-v]
Processes a directory of Tiled .tmx maps. Unable to process XML encoded tmx
maps. Problems processing or loading tilesets with different tile size from
those specified in the map.

  --include-unused           creates a tileset with every tile, not just
                             the used tiles. This can take a long time.
  --combine-tilesets         instead of creating a tileset for each map,
                             this combines the tilesets into some kind
                             of monster tileset. Has problems with tileset
                             location. Has problems with nested folders.
                             Not recommended.
  -v                         outputs which tiles are stripped and included

Example:

Running TiledMapPacker on "./in ./out"
with an "in" directory with the following structure:

  in/overworld.tmx
  in/dawn/Examples/Blank.tmx
  in/dawn/Examples/Dungeon.tmx
  in/dawn/Examples/Logo.tmx
  in/dawn/Examples/Mine.tmx
  in/dawn/Examples/Town.tmx
  in/dawn/Examples/Underworld.tmx
  in/world1Maps/dungeon1.tmx
  in/world1Maps/dungeon2.tmx
  in/world2Maps/town1.tmx
  in/world2Maps/town2.tmx

would have the following structure in the "out" directory:

  out/Blank.tmx
  out/dungeon1.tmx
  out/dungeon2.tmx
  out/Dungeon.tmx
  out/Logo.tmx
  out/Mine.tmx
  out/overworld.tmx
  out/town1.tmx
  out/town2.tmx
  out/Town.tmx
  out/Underworld.tmx

  out/tileset/Blank.atlas
  out/tileset/dungeon1.atlas
  out/tileset/dungeon1.png
  out/tileset/dungeon2.atlas
  out/tileset/dungeon2.png
  out/tileset/Dungeon.atlas
  out/tileset/Dungeon.png
  out/tileset/Logo.atlas
  out/tileset/Logo.png
  out/tileset/Mine.atlas
  out/tileset/Mine.png
  out/tileset/overworld.atlas
  out/tileset/overworld.png
  out/tileset/town1.atlas
  out/tileset/town2.atlas
  out/tileset/town2.png
  out/tileset/Town.atlas
  out/tileset/Town.png
  out/tileset/Underworld.atlas
  out/tileset/Underworld.png

(Note: maps without a tileset .png were completely empty maps)

TL;DR

Changes TiledMapPacker to create one texture atlas per map, adds two classes to
test that I haven't messed things up more than they were.. I think.
  modified:   CHANGES
  modified:   extensions/gdx-tools/src/com/badlogic/gdx/tiledmappacker/TiledMapPacker.java
  new file:   extensions/gdx-tools/src/com/badlogic/gdx/tiledmappacker/TiledMapPackerTest.java
  new file:   extensions/gdx-tools/src/com/badlogic/gdx/tiledmappacker/TiledMapPackerTestRender.java
