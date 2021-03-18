package multiteam.arcadia.setup.world.dimensions;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.Blockreader;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.WorldGenRegion;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;


public class CloudRealmChunkGenerator extends ChunkGenerator {

    public static final Codec<CloudRealmChunkGenerator> CODEC = RegistryLookupCodec.getLookUpCodec(Registry.BIOME_KEY).xmap(CloudRealmChunkGenerator::new, CloudRealmChunkGenerator::getBiomeRegistry).codec();

    public CloudRealmChunkGenerator(Registry<Biome> registry){
        super(new ModBiomeProvider(registry), new DimensionStructuresSettings(false));
    }

    public Registry<Biome> getBiomeRegistry(){
        return ((ModBiomeProvider)biomeProvider).getBiomeRegistry();
    }

    @Override
    public void generateSurface(WorldGenRegion region, IChunk chunk){
        BlockState bedrock = Blocks.BEDROCK.getDefaultState();
        BlockState stone = Blocks.STONE.getDefaultState();
        ChunkPos chunkPos = chunk.getPos();

        BlockPos.Mutable pos = new BlockPos.Mutable();

        int x;
        int z;

        /*for (x = 0; x < 16; x++) {
            for (z = 0; z < 16; z++) {
                chunk.setBlockState(pos.setPos(x, 0, z), bedrock, false);
            }
        } WE DONT NEED BEDROCK IN HERE*/

        for (x = 0; x < 16; x++) {
            for (z = 0; z < 16; z++) {
                int realx = chunkPos.x * 16 + x;
                int realz = chunkPos.z * 16 + z;
                int height = (int) (65 + Math.sin(realx / 20.0f)*10 + Math.cos(realz / 20.0f)*10);
                for (int y = 1 ; y < height ; y++) {
                    chunk.setBlockState(pos.setPos(x, y, z), stone, false);
                }
            }
        }

    }

    @Override
    protected Codec<? extends ChunkGenerator> func_230347_a_(){
        return CODEC;
    }

    @Override
    public ChunkGenerator func_230349_a_(long seed){
        return new CloudRealmChunkGenerator(getBiomeRegistry());
    }

    @Override
    public void func_230352_b_(IWorld world, StructureManager structureManager, IChunk chunk){

    }

    @Override
    public int getHeight(int x, int z, Heightmap.Type heightmapType) {
        return 0;
    }

    @Override
    public IBlockReader func_230348_a_(int p_230348_1_, int p_230348_2_) {
        return new Blockreader(new BlockState[0]);
    }

}
