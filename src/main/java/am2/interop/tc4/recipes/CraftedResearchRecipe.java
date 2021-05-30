package am2.interop.tc4.recipes;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.nbt.NBTTagCompound;
import thaumcraft.api.ItemApi;



public class CraftedResearchRecipe extends ShapelessRecipes {

	public CraftedResearchRecipe(ItemStack item, List pIngredients) {
		super(item, pIngredients);
		
	}
	
	public static CraftedResearchRecipe createRecipe(ItemStack researchItem, String researchToUnlock) {

		
//		ItemStack scribingToolsItem = new ItemStack(ItemApi.getItem("ItemInkwell", 0).getItem(), 1, -1);
		
//		Object[] ingredients = new Object[] {
////			scribingToolsItem,
//			researchItem,
//			new ItemStack(Items.paper)
//
//					
//		};
		
		ArrayList<ItemStack> ingredientsList = new ArrayList<ItemStack>();
//		ItemStack paperStack = new ItemStack(Items.paper);
		ItemStack bookStack = new ItemStack(Items.book);
		ItemStack scribingToolsStack = ItemApi.getItem("itemInkwell", 64);
		
		ingredientsList.add(researchItem);
//		ingredientsList.add(paperStack);
		ingredientsList.add(bookStack);
		ingredientsList.add(scribingToolsStack);
		
//		System.out.println("**** DEFINING CRAFTED RESEARCH *********************************************************");
//		if (researchItem != null) {
//			System.out.println("researchItem = " + researchItem.getDisplayName());
//		} else {
//			System.out.println("researchItem = null");
//		}
//		
//		if (paperStack != null) {
//			System.out.println("paperStack = " + paperStack.getDisplayName());
//		} else {
//			System.out.println("paperStack = null");
//		}


		ItemStack discoveryItem = ItemApi.getItem("itemResearchNotes", 64);
		NBTTagCompound discoveryTags = new NBTTagCompound();
		
		discoveryTags.setByte("complete", (byte) 1);
		discoveryTags.setString("key", researchToUnlock);
		
		discoveryItem.setTagCompound(discoveryTags);
		
	
//		return new CraftedResearchRecipe(discoveryItem, Arrays.asList(ingredients));
		return new CraftedResearchRecipe(discoveryItem, ingredientsList);
	}
	
	@Override
    public ItemStack getCraftingResult(final InventoryCrafting inventorycrafting) { 
    	
    	
    	return this.getRecipeOutput().copy();
    }

}
