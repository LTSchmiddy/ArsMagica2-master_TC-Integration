package am2.worldgen;

import am2.AMCore;
import am2.entities.EntityDryad;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class BiomeWitchwoodForest extends BiomeGenBase{

	public static final BiomeGenBase instance = new BiomeWitchwoodForest(AMCore.config.getWitchwoodForestID()).setBiomeName("WitchwoodForest");
	private static final WitchwoodTreeHuge hugeTree = new WitchwoodTreeHuge(true);
	private static final WitchwoodTreeSmall smallTree = new WitchwoodTreeSmall(true);

	public BiomeWitchwoodForest(int par1){
		super(par1);
		this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 5, 4, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityDryad.class, 5, 4, 4));
		this.theBiomeDecorator.treesPerChunk = 10;
		this.theBiomeDecorator.grassPerChunk = 4;
		this.theBiomeDecorator.flowersPerChunk = 10;
	}

	@Override
	public int getWaterColorMultiplier(){
		return 0x0a2a72;
	}

	@Override
	public int getBiomeFoliageColor(int x, int y, int z){
		return 0xdbe6e5;
	}

	@Override
	public int getBiomeGrassColor(int x, int y, int z){
		return 0xdbe6e5;
	}

	@Override
	public int getSkyColorByTemp(float par1){
		return 0x6699ff;
	}
	
	@Override
	public WorldGenAbstractTree func_150567_a(Random p_150567_1_)
	{
	  return (WorldGenAbstractTree)(p_150567_1_.nextInt(10) == 0 ? hugeTree : smallTree);
	}
}
