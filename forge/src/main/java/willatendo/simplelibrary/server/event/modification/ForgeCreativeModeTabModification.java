package willatendo.simplelibrary.server.event.modification;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

public class ForgeCreativeModeTabModification implements CreativeModeTabModification {
    private final BuildCreativeModeTabContentsEvent event;

    public ForgeCreativeModeTabModification(BuildCreativeModeTabContentsEvent event) {
        this.event = event;
    }

    @Override
    public void add(ResourceKey<CreativeModeTab> creativeModeTab, ItemLike itemLike) {
        if (this.event.getTabKey() == creativeModeTab) {
            if (this.event.getTabKey() == CreativeModeTabs.OP_BLOCKS && this.event.hasPermissions()) {
                this.event.accept(itemLike);
            } else if (this.event.getTabKey() != CreativeModeTabs.OP_BLOCKS) {
                this.event.accept(itemLike);
            }
        }
    }
}