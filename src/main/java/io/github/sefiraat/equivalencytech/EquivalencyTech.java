package io.github.sefiraat.equivalencytech;

import co.aikar.commands.PaperCommandManager;
import io.github.sefiraat.equivalencytech.commands.Commands;
import io.github.sefiraat.equivalencytech.configuration.ConfigMain;
import io.github.sefiraat.equivalencytech.item.EQItems;
import io.github.sefiraat.equivalencytech.listeners.ManagerEvents;
import io.github.sefiraat.equivalencytech.misc.ManagerSupportedPlugins;
import io.github.sefiraat.equivalencytech.recipes.EmcDefinitions;
import io.github.sefiraat.equivalencytech.recipes.Recipes;
import io.github.sefiraat.equivalencytech.runnables.ManagerRunnables;
//import io.github.thebusybiscuit.slimefun4.libraries.dough.updater.GitHubBuildsUpdater;
//import org.bstats.bukkit.Metrics;
//import org.bstats.charts.SimplePie;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;

import java.io.File;

public class EquivalencyTech extends JavaPlugin {

    private static EquivalencyTech instance;
    private PaperCommandManager commandManager;

    private ConfigMain configMainClass;
    private EmcDefinitions emcDefinitions;
    private EQItems eqItems;
    private Recipes recipes;
    private ManagerEvents managerEvents;
    private ManagerRunnables managerRunnables;
    private ManagerSupportedPlugins managerSupportedPlugins;

    private boolean isUnitTest = false;

    public PaperCommandManager getCommandManager() {
        return commandManager;
    }

    public static EquivalencyTech getInstance() {
        return instance;
    }

    public ConfigMain getConfigMainClass() {
        return configMainClass;
    }

    public EmcDefinitions getEmcDefinitions() {
        return emcDefinitions;
    }

    public EQItems getEqItems() {
        return eqItems;
    }

    public Recipes getRecipes() {
        return recipes;
    }

    public ManagerEvents getManagerEvents() {
        return managerEvents;
    }

    public ManagerRunnables getManagerRunnables() {
        return managerRunnables;
    }

    public ManagerSupportedPlugins getManagerSupportedPlugins() {
        return managerSupportedPlugins;
    }

    public EquivalencyTech() {
        super();
    }

    protected EquivalencyTech(JavaPluginLoader loader, PluginDescriptionFile description, File dataFolder, File file) {
        super(loader, description, dataFolder, file);
        isUnitTest = true;
    }

    @Override
    public void onEnable() {

        getLogger().info("########################################");
        getLogger().info(" EquivalencyTech - Created by Sefiraat  ");
        getLogger().info("########################################");

        instance = this;

        /*if (this.getConfig().getBoolean("auto-update") && this.getDescription().getVersion().startsWith("DEV")) {
            new GitHubBuildsUpdater(this, this.getFile(), "Sefiraat/EquivalencyTech/master").start();
        }*/

        configMainClass = new ConfigMain(this);
        eqItems = new EQItems(this);
        managerSupportedPlugins = new ManagerSupportedPlugins(this);
        emcDefinitions = new EmcDefinitions(this);
        recipes = new Recipes(this);
        managerEvents = new ManagerEvents(this);
        managerRunnables = new ManagerRunnables(this);

        registerCommands();

        /*if (!isUnitTest) {
            int pluginId = 11527;
            Metrics metrics = new Metrics(this, pluginId);
            metrics.addCustomChart(new SimplePie("slimefun", () -> String.valueOf(getManagerSupportedPlugins().isInstalledSlimefun())));
            metrics.addCustomChart(new SimplePie("emc2", () -> String.valueOf(getManagerSupportedPlugins().isInstalledEMC2())));
        }*/

    }

    @Override
    public void onDisable() {
        saveConfig();
        configMainClass.saveAdditionalConfigs();
    }

    private void registerCommands() {
        commandManager = new PaperCommandManager(this);
        commandManager.registerCommand(new Commands(this));
    }






}
