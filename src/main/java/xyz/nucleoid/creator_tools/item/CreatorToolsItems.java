package xyz.nucleoid.creator_tools.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import xyz.nucleoid.creator_tools.CreatorTools;

public final class CreatorToolsItems {
    public static final Item ADD_REGION = register("add_region", new AddRegionItem(new Item.Settings()));
    public static final Item INCLUDE_ENTITY = register("include_entity", new IncludeEntityItem(new Item.Settings()));
    public static final Item REGION_VISIBILITY_FILTER = register("region_visibility_filter", new RegionVisibilityFilterItem(new Item.Settings()));

    public static final ItemGroup ITEM_GROUP = new ItemGroup.Builder(null, -1)
        .displayName(Text.translatable("text.nucleoid_creator_tools.name"))
        .icon(ADD_REGION::getDefaultStack)
        .entries((context, entries) -> {
            entries.add(ADD_REGION);
            entries.add(INCLUDE_ENTITY);
            entries.add(REGION_VISIBILITY_FILTER);
        })
        .build();

    private static Item register(String path, Item item) {
        return Registry.register(Registries.ITEM, CreatorTools.identifier(path), item);
    }
}
