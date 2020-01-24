package am2.interop.tc4.items;

import am2.armor.ItemMagitechGoggles;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import thaumcraft.api.IGoggles;
import thaumcraft.api.IRepairable;
import thaumcraft.api.nodes.IRevealer;

public class ItemMagitechGogglesOfRevealing extends ItemMagitechGoggles implements IGoggles, IRevealer, IRepairable {

	public ItemMagitechGogglesOfRevealing(int renderIndex) {
		super(renderIndex);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean showNodes(ItemStack itemstack, EntityLivingBase player) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean showIngamePopups(ItemStack itemstack, EntityLivingBase player) {
		// TODO Auto-generated method stub
		return true;
	}


}
