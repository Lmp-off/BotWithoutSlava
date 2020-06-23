package commands;


import core.Bot;
import core.First_Init;
import mute.MuteMain;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import core.Languages;

public class CommandControl {
    private MessageReceivedEvent event;
    private String message;
    private MuteMain mm;
    {
        mm=new MuteMain();
    }
    public CommandControl(MessageReceivedEvent event){
        this.event=event;
        this.message=event.getMessage().getContentRaw();
        controller();
    }
    //это мэйн для всех команд. проверять тут
    private void controller(){
        if  (message.trim().equals("&start"))  First_Init.Initialize(event);
        if  (message.trim().equals("&rus")) Bot.languages=Languages.RUSSIAN;
        if  (message.trim().equals("&eng")) Bot.languages= Languages.ENGLISH;
        if  (message.trim().equals("&f"))new ShowCommands().Show(event);
        if  (message.trim().equals("&rainbow")) new Rainbow(event).start();

    }
}
