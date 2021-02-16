package de.wuzlwuz.griefergames.chat;

import net.labymod.ingamechat.tools.filter.Filters;
import net.labymod.main.LabyMod;

import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mention extends Chat {
    private Pattern msgUserGlobalChatRegex = Pattern.compile("^(?:\\[.+\\] )?([A-Za-z\\-]+\\+?) \\u2503 ((\\u007E)?\\!?\\w{1,16})\\s\\u00BB");

    @Override
    public String getName() {
        return "mentions";
    }


    @Override
    public boolean doActionReceiveMessage(String formatted, String unformatted) {
        if(!getSettings().isHighlightMentions()) return false;

        if(unformatted.trim().length() > 0 && unformatted.toLowerCase().contains(LabyMod.getInstance().getPlayerName().toLowerCase())) {
            Matcher matcher = msgUserGlobalChatRegex.matcher(unformatted);
            return matcher.find() && !matcher.group(2).equalsIgnoreCase(LabyMod.getInstance().getPlayerName());
        }
        return false;
    }

    @Override
    public boolean receiveMessage(String formatted, String unformatted) {
        short r = (short) getSettings().getMentionsColor().getRed();
        short g = (short) getSettings().getMentionsColor().getGreen();
        short b = (short) getSettings().getMentionsColor().getBlue();
        Filters.Filter filter = new Filters.Filter("GrieferGames Addon Mention", new String[] {unformatted}, new String[0],
                false, "", true, r, g, b, false, false, false, "Global");

        LabyMod.getInstance().getChatToolManager().getFilters().add(filter);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                LabyMod.getInstance().getChatToolManager().getFilters().remove(filter);
            }
        }, 2000);
        return false;
    }
}
