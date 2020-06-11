package commands;

import core.LanguagesAdapter;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import texts.texts;

public class ShowCommands {
    private static LanguagesAdapter LA;
    private texts texts;
    {
        LA = new LanguagesAdapter();
        texts = new texts();
    }
    public void Show(MessageReceivedEvent event){
            event.getChannel().sendMessage(LA.getCommands()).queue();
    }
}
