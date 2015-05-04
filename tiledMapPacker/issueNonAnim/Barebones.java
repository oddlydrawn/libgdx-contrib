
package com.badlogic.gdx.tests.lwjgl;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.AtlasTmxMapLoader;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Barebones extends ApplicationAdapter {
	final String TMX_LOC = "data/maps/tiled/tiledPacker.tmx";
	AtlasTmxMapLoader atlasTmxMapLoader;
	InternalFileHandleResolver resolver;
	TiledMap map;
	OrthographicCamera camera;
	OrthogonalTiledMapRenderer renderer;

	public void create () {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		camera = new OrthographicCamera(w, h);
		resolver = new InternalFileHandleResolver();
		resolver.resolve(TMX_LOC);
		atlasTmxMapLoader = new AtlasTmxMapLoader(resolver);

		map = atlasTmxMapLoader.load(TMX_LOC);
		renderer = new OrthogonalTiledMapRenderer(map);
	}

	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		renderer.setView(camera);
		renderer.render();
	}

	public static void main (String[] args) throws Exception {
		new LwjglApplication(new Barebones());
	}
}
