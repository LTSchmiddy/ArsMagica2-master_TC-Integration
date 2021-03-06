package am2.preloader;

import am2.LogHelper;
import com.google.common.eventbus.EventBus;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;


public class AM2PreloaderContainer extends DummyModContainer implements IFMLLoadingPlugin{

	// private final String[] asmTransformers = new String[]{"am2.preloader.AccessTransformers", "am2.preloader.BytecodeTransformers"};
	private final String[] asmTransformers = new String[]{"am2.preloader.BytecodeTransformers"};
	private final ModMetadata md = new ModMetadata();

	public static boolean foundThaumcraft = false;
	private static boolean foundOptiFine = false;
	private static boolean confirmedOptiFine = false;
	public static boolean foundDragonAPI = false;
	
	public static boolean isDevEnvironment = false;

	public AM2PreloaderContainer(){
		LogHelper.info("Core initializing...stand back!  I'm going to try MAGIC!");

		md.autogenerated = true;
		md.credits = "Mithion, AlgorithmX2, Sunstrike";
		md.modId = getModId();
		md.version = getVersion();
		md.name = getName();
		md.authorList = Arrays.asList("Mithion", "AlgorithmX2", "Sunstrike");
	}

	@Override
	public String getModId(){
		return "AM2-Preloader";
	}

	@Override
	public String getName(){
		return "AMCore";
	}

	@Override
	public String getVersion(){
		return "0.0.3";
	}

	@Override
	public String getDisplayVersion(){
		return getVersion();
	}

	@Override
	public ModMetadata getMetadata(){
		return md;
	}

	@Override
	public boolean registerBus(EventBus bus, LoadController controller){
		bus.register(this);
		return true;
	}

	@Override
	public String[] getASMTransformerClass(){
		return asmTransformers;
	}

	@Override
	public String getModContainerClass(){
		return "am2.preloader.AM2PreloaderContainer";
	}

	@Override
	public String getSetupClass(){
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data){
		// if (((String)data.get("coremodList")).contains("DragonAPIASMHandler")){
			// LogHelper.info("Core: Located DragonAPI in list of coremods");
			// foundDragonAPI = true;
		// }

		// This is very crude check for mods presence using filename.
		// Some mods may refer to others in their name, so we'll to confirm those assumption with class presence check.
		File loc = (File)data.get("mcLocation");

		LogHelper.trace("MC located at: " + loc.getAbsolutePath());
		isDevEnvironment = !(Boolean)data.get("runtimeDeobfuscationEnabled");

		File mcFolder = new File(loc.getAbsolutePath() + File.separatorChar + "mods");
		File mcVersionFolder = new File(mcFolder.getAbsolutePath() + File.separatorChar + "1.7.10");
		ArrayList<File> subfiles = new ArrayList<>();
		if (mcFolder.listFiles() != null){
			subfiles = new ArrayList<>(Arrays.asList(mcFolder.listFiles()));
			if (mcVersionFolder.listFiles() != null){
				subfiles.addAll(Arrays.asList(mcVersionFolder.listFiles()));
			}
		}
		for (File file : subfiles){
			String name = file.getName();
			if (name != null) {
				name = name.toLowerCase();
				if (name.endsWith(".jar") || name.endsWith(".zip")){
					if (name.contains("thaumcraft")){
						LogHelper.info("Core: Located Thaumcraft in " + file.getName());
						foundThaumcraft = true;
					}else if (name.contains("optifine")){
						LogHelper.info("Core: Located OptiFine in " + file.getName() + ". We'll to confirm that...");
						foundOptiFine = true;
					}else if (name.contains("dragonapi")){
						LogHelper.info("Core: Located DragonAPI in " + file.getName());
						foundDragonAPI = true;
					}
				}
			}
		}
	}

	@Override
	public String getAccessTransformerClass(){
		return null;
	}

	public static boolean isOptiFinePresent(){
		if (!confirmedOptiFine && foundOptiFine){
			// Check presence of OptiFine core classes
			try{
				Class.forName("optifine.OptiFineForgeTweaker");
			}
			catch (ClassNotFoundException exception1){
				try{
					Class.forName("optifine.OptiFineTweaker");
				}
				catch (ClassNotFoundException exception2){
					foundOptiFine = false;
				}
			}
			if (foundOptiFine){
				LogHelper.info("Core: OptiFine presence has been confirmed.");
			} else {
				LogHelper.info("Core: OptiFine doesn't seem to be there actually.");
			}
			confirmedOptiFine = true;
		}
		return foundOptiFine;
	}
}
