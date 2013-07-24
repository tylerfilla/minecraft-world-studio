package com.gmail.quarzekk.worldstudio.ui.render.mesh.block;

import java.util.HashMap;

public class BlockMeshIndex {
	
	private static final HashMap<BlockInfo, BlockMesh> blockInfoToMeshMap = new HashMap<BlockInfo, BlockMesh>();
	
	public static void mapBlockInfoToMesh(int blockId, int blockMetadata, BlockMesh mesh) {
		blockInfoToMeshMap.put(new BlockInfo(blockId, blockMetadata), mesh);
	}
	
	public static BlockMesh getMeshForBlockInfo(int blockId, int blockMetadata) {
		BlockInfo blockInfo = new BlockInfo(blockId, blockMetadata);
		
		for (BlockInfo info : blockInfoToMeshMap.keySet()) {
			if (info.equals(blockInfo)) {
				return blockInfoToMeshMap.get(info);
			}
		}
		
		return null;
	}
	
	private static class BlockInfo {
		
		private int blockId;
		
		private int blockMetadata;
		
		public BlockInfo(int blockId, int blockMetadata) {
			this.blockId = blockId;
			this.blockMetadata = blockMetadata;
		}
		
		public int getBlockId() {
			return this.blockId;
		}
		
		public int getBlockMetadata() {
			return this.blockMetadata;
		}
		
		@Override
		public boolean equals(Object object) {
			if (object instanceof BlockInfo) {
				BlockInfo blockInfo = (BlockInfo) object;
				return blockInfo.getBlockId() == this.blockId && blockInfo.getBlockMetadata() == this.blockMetadata;
			}
			
			return false;
		}
		
	}
	
}
