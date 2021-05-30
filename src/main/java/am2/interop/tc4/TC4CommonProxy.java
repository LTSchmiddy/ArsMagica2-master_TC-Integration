package am2.interop.tc4;

import am2.LogHelper;
import am2.blocks.BlocksCommonProxy;
import am2.entities.EntityManager;
import am2.items.ItemsCommonProxy;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

import am2.interop.tc4.items.TC4ItemsCommonProxy;
import am2.interop.tc4.recipes.TC4RecipesProxy;

import am2.interop.tc4.research.TC4ResearchCategoryWizardry;

public class TC4CommonProxy {

	public static TC4ItemsCommonProxy items;
	
	public static TC4ResearchCategoryWizardry research;
	
	public TC4RecipesProxy recipes;
	
	public void initialize () {
		items = new TC4ItemsCommonProxy ();
		items.InstantiateItems();
		items.RegisterItems();
		
		research = new TC4ResearchCategoryWizardry();
		research.initialize();
		
		recipes = new TC4RecipesProxy();
		recipes.InitAllRecipes();
		
	}
	
}
