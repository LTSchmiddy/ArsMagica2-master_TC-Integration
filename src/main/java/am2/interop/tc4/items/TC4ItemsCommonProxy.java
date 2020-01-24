package am2.interop.tc4.items;

import am2.AMCore;
import am2.AMCreativeTab;
import am2.LogHelper;
import am2.api.flickers.IFlickerFunctionality;
import am2.api.spell.enums.Affinity;
import am2.armor.*;
import am2.blocks.BlocksCommonProxy;
import am2.blocks.tileentities.flickers.FlickerOperatorRegistry;
import am2.enchantments.AMEnchantmentHelper;
import am2.items.ItemsCommonProxy;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.ArrayList;
import java.util.List;

public class TC4ItemsCommonProxy {
	
	public static ItemMagitechGogglesOfRevealing magitechGogglesOfRevealing;
	
	public void InstantiateItems(){ 
		magitechGogglesOfRevealing = (ItemMagitechGogglesOfRevealing)new ItemMagitechGogglesOfRevealing(ArmorHelper.getArmorRenderIndex("combo_goggles")).setUnlocalizedAndTextureName("arsmagica2:gogglesrevealing").setCreativeTab(ItemsCommonProxy.itemTab);
		
	}
	
	public void RegisterItems() {
		AMCore.proxy.items.registerItem(magitechGogglesOfRevealing, "magitechGogglesOfRevealing");
		
		
	}
	

}
