package io.github.sefiraat.equivalencytech.statics;

import io.github.sefiraat.equivalencytech.EquivalencyTech;
import io.github.sefiraat.equivalencytech.configuration.ConfigMain;
import io.github.sefiraat.equivalencytech.misc.Utils;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public final class Messages {

    public static final String PREFIX = "" + ChatColor.GRAY + "[等價技術] ";
    public static final String SUFFIX = "" + ChatColor.GRAY + "";

    public static final ChatColor THEME_WARNING = ChatColor.YELLOW;
    public static final ChatColor THEME_ERROR = ChatColor.RED;
    public static final ChatColor THEME_NOTICE = ChatColor.WHITE;
    public static final ChatColor THEME_PASSIVE = ChatColor.GRAY;
    public static final ChatColor THEME_SUCCESS = ChatColor.GREEN;
    public static final ChatColor THEME_EMC_PURPLE = ChatColor.of("#5d2999");
    public static final ChatColor THEME_ITEM_NAME_GENERAL = ChatColor.of("#cfab1d");
    public static final ChatColor THEME_PASSIVE_GRAY = ChatColor.of("#a3a3a3");
    public static final ChatColor THEME_CLICK_INSTRUCTION = ChatColor.of("#cfab1d");
    public static final ChatColor THEME_PASSIVE_CONGRATULATE = ChatColor.of("#fff41f");

    private Messages() {
        throw new IllegalStateException("Utility class");
    }

    // region Commands

    public static String msgCmdSubcommand(EquivalencyTech plugin) {
        return PREFIX + THEME_NOTICE + plugin.getConfigMainClass().getStrings().getCommandSubcommand();
    }
    public static String msgCmdEmcMustHold(EquivalencyTech plugin) {
        return PREFIX + THEME_WARNING + plugin.getConfigMainClass().getStrings().getCommandEmcMustHold();
    }
    public static String msgCmdEmcNone(EquivalencyTech plugin) {
        return PREFIX + THEME_WARNING + plugin.getConfigMainClass().getStrings().getCommandEmcNone();
    }
    public static String msgCmdEmcDisplay(Material m, Double emc) {
        return PREFIX + THEME_WARNING + Utils.materialFriendlyName(m) + " x 1 = EMC " + emc;
    }
    public static String msgCmdEmcDisplay(String s, Double emc) {
        return PREFIX + THEME_WARNING + s + " x 1 = EMC " + emc;
    }
    public static String msgCmdEmcDisplayStack(Material m, Integer amount, Double emc) {
        return PREFIX + THEME_WARNING + Utils.materialFriendlyName(m) + " x " + amount + " = EMC " + emc;
    }
    public static String msgCmdEmcDisplayStack(String s, Integer amount, Double emc) {
        return PREFIX + THEME_WARNING + s + " x " + amount + " = EMC " + emc;
    }
    public static String messageCommandSelectItem(EquivalencyTech plugin) {
        return PREFIX + THEME_NOTICE + plugin.getConfigMainClass().getStrings().getCommandSelectItem();
    }

    public static String messageCommandItemGiven(EquivalencyTech plugin, String itemName) {
        return PREFIX + THEME_NOTICE + MessageFormat.format(plugin.getConfigMainClass().getStrings().getCommandItemGiven(), itemName);
    }

    public static String messageCommandEmc(EquivalencyTech plugin, Player player) {
        return PREFIX + THEME_NOTICE + "You have " + THEME_SUCCESS + ConfigMain.getPlayerEmc(plugin, player) + THEME_NOTICE + " EMC.";
    }

    // endregion

    // region GUI

    public static String messageGuiItemLearned(EquivalencyTech plugin) {
        return PREFIX + THEME_PASSIVE_CONGRATULATE + plugin.getConfigMainClass().getStrings().getGuiItemLearned();
    }

    public static String messageGuiEmcGiven(EquivalencyTech plugin, Player player, double emcBase, double emcTotal, int itemAmt, int burnRate) {
        return PREFIX + THEME_SUCCESS + "+" + emcTotal + " EMC " + THEME_PASSIVE + "(" + emcBase + " * " + itemAmt + ")" + THEME_ERROR + " 燃燒率 = " + burnRate + "%" + THEME_NOTICE + " : [EMC : " + ConfigMain.getPlayerEmc(plugin, player) + "]";
    }

    public static String messageGuiEmcRemoved(EquivalencyTech plugin, Player player, double emcBase, double emcTotal, int itemAmt) {
        return PREFIX + THEME_ERROR + "-" + emcTotal + " EMC " + THEME_PASSIVE + "(" + emcBase + " * " + itemAmt + ") : " + THEME_NOTICE + " [EMC : " + ConfigMain.getPlayerEmc(plugin, player) + "]";
    }

    public static String messageGuiEmcNotEnough(EquivalencyTech plugin, Player player) {
        return PREFIX + THEME_ERROR + plugin.getConfigMainClass().getStrings().getGuiNotEnoughEmc() + THEME_NOTICE + " [EMC : " + ConfigMain.getPlayerEmc(plugin, player) + "]";
    }

    public static String messageGuiNoSpace(EquivalencyTech plugin) {
        return PREFIX + THEME_ERROR + plugin.getConfigMainClass().getStrings().getGeneralNoInvSpace();
    }

    public static String messageGuiItemMeta(EquivalencyTech plugin) {
        return PREFIX + THEME_ERROR + plugin.getConfigMainClass().getStrings().getGuiItemMeta();
    }

    // endregion

    // region Events

    public static String messageEventEMCChestPlace(EquivalencyTech plugin) {
        return PREFIX + THEME_ERROR + plugin.getConfigMainClass().getStrings().getEventAdjPlacement();
    }

    public static String messageEventCantOpenNotOwner(EquivalencyTech plugin) {
        return PREFIX + THEME_ERROR + plugin.getConfigMainClass().getStrings().getEventCantOpenNotOwner();
    }

    public static String messageEventItemSet(EquivalencyTech plugin) {
        return PREFIX + THEME_SUCCESS + plugin.getConfigMainClass().getStrings().getEventItemSet();
    }

    public static String messageEventItemUnset(EquivalencyTech plugin) {
        return PREFIX + THEME_SUCCESS + plugin.getConfigMainClass().getStrings().getEventItemUnset();
    }

    public static List<String> messageEMC2Installed(EquivalencyTech plugin) {
        List<String> message = new ArrayList<>();
        message.add(THEME_ERROR + "你同時安裝了 EquivalencyTech 與 EMC2.");
        message.add(THEME_NOTICE + "請注意這可能導致問題. 請查看以下網站連結來了解更多. 此消息並不意味著你需要刪除 EquivalencyTech/EMC2.");
        message.add("");
        message.add(THEME_NOTICE + "在 EquivalencyTech 的 config.yml 中關閉此訊息.");
        message.add("");
        message.add( THEME_WARNING + "https://github.com/Sefiraat/EquivalencyTech/");
        message.add(THEME_WARNING + "https://github.com/Seggan/EMC2");
        return message;
    }

    // endregion

}
