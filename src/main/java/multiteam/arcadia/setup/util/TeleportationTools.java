package multiteam.arcadia.setup.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

public class TeleportationTools {

    public static void teleport(ServerPlayerEntity entity, ServerWorld destination, BlockPos pos) {
        entity.changeDimension(destination, new ITeleporter() {
            @Override
            public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
                entity = repositionEntity.apply(false);
                entity.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
                return entity;
            }
        });
    }
}