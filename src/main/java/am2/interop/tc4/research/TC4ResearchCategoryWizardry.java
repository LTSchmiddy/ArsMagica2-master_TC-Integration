package am2.interop.tc4.research;

import am2.AMCore;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.*;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class TC4ResearchCategoryWizardry {
	
	public static String categoryName = "THAUMIC_WIZARDRY";
	
	public static ResearchItem rWizardryIntro;
	public static ResearchItem rWizardryIntro_2;
	public static String rWizardryIntroTag = "tw_Intro";
	
	public void initialize() {
		ResearchCategories.registerCategory(
				categoryName,
				new ResourceLocation("arsmagica2:textures/items/arcanecompendium.png"),
				new ResourceLocation("arsmagica2:textures/guis/SkillTree_Offense.png")
		);
		
		// Creating Introductory Research:

		rWizardryIntro = new ResearchItem(
			rWizardryIntroTag,
			categoryName,
			new AspectList().add(Aspect.MAGIC, 1).add(Aspect.MAN, 1),
			0,
			0,
			0,
			new ItemStack(AMCore.proxy.items.arcaneCompendium)
			
		).setPages(
			new ResearchPage(
					"While you can accomplish many wonders using Thaumaturgy, you must rely on various pieces of arcane equipment in order to perform "
					+ "your magic. Thaumaturgy does not grant you any innate arcane power of your own. If you were to find yourself without caught "
					+ "without your equipment, you could be in considerable trouble.<BR/> "
					+ ""
					+ "There is another school of thought in the world of magic: Wizardry. Unlike thaumaturges, who use their intellect and arcane "
					+ "knowledge to accomplish their goals, wizards manipulate reality using their strength of will alone. "
					+ "And while many thaumaturges scoff at this practice for being less academic and "
			),
			new ResearchPage(
					"more brute force, you can't argue with the results.<BR/>"
					+ ""
					+ "Perhaps it would be worth your time to study a bit of wizardry. It's possible that research into the underlying mechanics of the practice "
					+ "could lead to some interesting discoveries. Or perhaps your arcane knowledge will lead you to skills and abilities that no wizard could "
					+ " perform otherwise. Or, at the very least, you won't wet yourself the next time you run into a creeper and realize you've misplaced your "
					+ "wand. Again.<BR/>"
					+ ""
					+ "If you wish to summon a tome on wizardry, simply place a book into an item frame while near a pool of liquid etherium."
			)
		
		).registerResearchItem();
		
		rWizardryIntro_2 = new ResearchItem(
				rWizardryIntroTag + "2",
				categoryName,
				new AspectList().add(Aspect.MAGIC, 1),
				0,
				3,
				0,
				new ItemStack(AMCore.proxy.items.arcaneCompendium)
				
			).setPages(
				new ResearchPage(
						"While you can accomplish many wonders using Thaumaturgy, you must rely on various pieces of arcane equipment in order to perform "
						+ "your magic. Thaumaturgy does not grant you any innate arcane power of your own. If you were to find yourself without caught "
						+ "without your equipment, you could be in considerable trouble.<BR/> "
						+ ""
						+ "There is another school of thought in the world of magic: Wizardry. Unlike thaumaturges, who use their intellect and arcane "
						+ "knowledge to accomplish their goals, wizards manipulate reality using their strength of will alone. "
						+ "And while many thaumaturges scoff at this practice for being less academic and "
				),
				new ResearchPage(
						"more brute force, you can't argue with the results.<BR/>"
						+ ""
						+ "Perhaps it would be worth your time to study a bit of wizardry. It's possible that research into the underlying mechanics of the practice "
						+ "could lead to some interesting discoveries. Or perhaps your arcane knowledge will lead you to skills and abilities that no wizard could "
						+ " perform otherwise. Or, at the very least, you won't wet yourself the next time you run into a creeper and realize you've misplaced your "
						+ "wand. Again.<BR/>"
						+ ""
						+ "If you wish to summon a tome on wizardry, simply place a book into an item frame while near a pool of liquid etherium."
				)
			
			).registerResearchItem();

		
		
	}
}
