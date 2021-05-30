package am2.interop.tc4.recipes;

import java.lang.reflect.Proxy;
import java.util.ArrayList;

import am2.AMCore;
import am2.LogHelper;
import am2.blocks.BlocksCommonProxy;
import am2.entities.EntityManager;
import am2.items.ItemsCommonProxy;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.api.ItemApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

import am2.interop.tc4.items.TC4ItemsCommonProxy;

public class TC4RecipesProxy {
	
	public void InitAllRecipes() {
		
		GameRegistry.addRecipe(CraftedResearchRecipe.createRecipe(new ItemStack(ItemsCommonProxy.arcaneCompendium, 1), "tw_Intro2"));
	}
	
	public void DefineReseachRecipe(Item researchItem, String researchToUnlock, String researchPage) {
		
//		GameRegistry.addRecipe(CraftedResearchRecipe.createRecipe(new ItemStack(AMCore.proxy.items.arcaneCompendium, 1), "tw_Intro2"));

	}
	
	public void AddRecipePageToResearch(ResearchItem researchItem, IRecipe recipeItem) {
		ResearchPage[] pages = new ResearchPage[researchItem.getPages().length + 1];
		
		for (int i = 0; i < researchItem.getPages().length; i++) {
			pages[i] = researchItem.getPages()[i];
		}
		pages[pages.length - 1] = new ResearchPage(recipeItem);
		
		researchItem.setPages(pages);
		
	}

}
