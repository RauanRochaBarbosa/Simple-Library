package willatendo.simplelibrary.client.event.registry;

import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;

public final class ForgeItemColorRegister implements ItemColorRegistry {
    private final RegisterColorHandlersEvent.Item event;

    public ForgeItemColorRegister(RegisterColorHandlersEvent.Item event) {
        this.event = event;
    }

    @Override
    public BlockColors getBlockColors() {
        return this.event.getBlockColors();
    }

    @Override
    public void registerItemColor(ItemColor itemColor, ItemLike... items) {
        this.event.register(itemColor, items);
    }
}