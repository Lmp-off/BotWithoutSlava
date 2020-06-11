package mute;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import settings.CONSTS;
import sun.dc.pr.PRError;
import texts.texts;

import java.util.ArrayList;
import java.util.Date;

public class MuteMain {
    private static Role Banrole;
    private texts text=new texts();
    Date current;
    //TODO:if mute f will stopped, write in the main channel info about muted members(если админы выключат функцию мута то вывести список замученых в главный канал)
    //TODO:finish Check(){}.Make normal filters and test(доделать функцию и затестить)
    public void Check(MessageReceivedEvent message){
        Banrole=message.getGuild().getRoleById("717311700805877777");
        String word=message.getMessage().getContentRaw().replaceAll(" ","").toLowerCase();
        System.out.println(word);
        for (int i = 0; i < text.mat.length ; i++) {
            if(word.contains(text.mat[i])){
                System.out.println("Catch word "+text.mat[i]);
                if (MuteVars.current!=null) MuteVars.current.interrupt();
                current = new Date();
                MuteVars.muteds.add(new Muted(message.getMember(),message.getChannel(),current,new Date(current.getYear(),current.getMonth(),current.getDate(),current.getHours(),(current.getMinutes()+1))));
                message.getGuild().addRoleToMember(message.getMember(),Banrole).queue();
                MuteThread mt = new MuteThread(new Date(),message.getGuild());
                MuteVars.current=mt;
                mt.start();
            }

        }
    }
    public static void UnMute(int index, Guild guild){
        guild.removeRoleFromMember(MuteVars.muteds.get(index).getMember(),Banrole).queue();
        MuteVars.muteds.remove(index);
        System.out.println("success");
        System.out.println(MuteVars.muteds);
    }

}
