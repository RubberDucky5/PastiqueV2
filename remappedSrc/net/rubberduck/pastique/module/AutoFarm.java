package net.rubberduck.pastique.module;

import net.minecraft.block.AirBlock;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.*;
import net.rubberduck.pastique.Pastique;

public class AutoFarm extends Module{
    public Identifier id = new Identifier("c", "seeds");
    public TagKey<Item> SEEDS = TagKey.of(Registry.ITEM_KEY, id);

    public int scanSize = 3;
    public int rateLimit = 2;
    public int ticker;
    public AutoFarm () {
        super("Auto Farm", "Hold seeds, break crops, profit");
    }

    @Override
    public void tick(ClientWorld cw) {
        if(mc.player == null) return;
        ItemStack i = mc.player.getMainHandStack();
        if(i.toString().endsWith("seeds") || i.isOf(Items.POTATO) || i.isOf(Items.CARROT) || i.isOf(Items.NETHER_WART)) {
            BlockPos playerPos = mc.player.getBlockPos();
            for (int x = -scanSize; x <= scanSize; x++) {
                for (int y = -scanSize; y <= scanSize; y++) {
                    for (int z = -scanSize; z <= scanSize; z++) {
                        if(ticker > 0) continue;
                        BlockPos testBlock = playerPos.add(new Vec3i(x,y,z));
                        if(cw.getBlockState(testBlock.add(0, -1, 0)).getBlock() instanceof FarmlandBlock && cw.getBlockState(testBlock).getBlock() instanceof AirBlock) {
                            BlockHitResult hit = new BlockHitResult(new Vec3d(testBlock.getX(), testBlock.getY(), testBlock.getZ()), Direction.UP, testBlock, false);
                            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND, hit);
                            ticker = rateLimit;
                        }
                    }
                }
            }
        }
        ticker --;
    }
}
