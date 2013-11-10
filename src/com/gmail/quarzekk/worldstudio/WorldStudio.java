package com.gmail.quarzekk.worldstudio;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.gmail.quarzekk.worldstudio.core.config.mesh.block.BlockMeshFile;
import com.gmail.quarzekk.worldstudio.core.config.mesh.block.BlockMeshParser;
import com.gmail.quarzekk.worldstudio.ui.UserInterface;
import com.gmail.quarzekk.worldstudio.ui.render.Camera;
import com.gmail.quarzekk.worldstudio.ui.render.mesh.block.BlockMesh;
import com.gmail.quarzekk.worldstudio.ui.render.mesh.block.BlockMeshIndex;
import com.gmail.quarzekk.worldstudio.ui.render.texture.Texture;
import com.gmail.quarzekk.worldstudio.world.Block;
import com.gmail.quarzekk.worldstudio.world.Chunk;
import com.gmail.quarzekk.worldstudio.world.World;

public class WorldStudio {
	
	public static WorldStudio instance;
	
	private UserInterface userInterface;
	
	public WorldStudio() {
		this.userInterface = new UserInterface();
	}
	
	public void start() {
		this.userInterface.startDisplay();
		
		Camera camera = new Camera();
		
		World world = new World();
		
		Chunk chunk = new Chunk(0, 0);
		chunk.setBlockAt(0, 0, 0, new Block(1, 0));
		chunk.setBlockAt(1, 1, 1, new Block(1, 0));
		chunk.setBlockAt(2, 2, 2, new Block(1, 0));
		
		world.loadChunk(chunk);
		
		this.userInterface.getWorldRenderer().setCamera(camera);
		this.userInterface.getWorldRenderer().setWorld(world);
		
		BlockMeshFile meshFile = new BlockMeshFile(new File("res/desktop/mesh/block_1_0_stone.msh"));
		BlockMeshParser meshParser = new BlockMeshParser(meshFile);
		
		Texture texture = null;
		
		try {
			texture = Texture.fromBufferedImage(ImageIO.read(new File("res/desktop/texture/block/stone.png")));
			meshParser.parse();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BlockMeshIndex.mapBlockInfoToMesh(1, 0, BlockMesh.fromBlockMeshFile(meshFile));
		
		camera.setPosition(0.0D, 0.0D, 12.0D);
		camera.setRotationalVelocity(-8.0D, 180.0D, 0.0D);
	}
	
	public void exit(int status) {
		if (status > 0) {
			System.err.println("Minecraft World Studio is exiting with errors.");
		}
		
		System.exit(status);
	}
	
	public static void main(String[] args) {
		WorldStudio.instance = new WorldStudio();
		WorldStudio.instance.start();
	}
	
}
