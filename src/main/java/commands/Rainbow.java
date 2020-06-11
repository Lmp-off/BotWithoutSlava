package commands;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class Rainbow extends Thread{
    MessageReceivedEvent event;
    private int current=0;
    Rainbow(MessageReceivedEvent event){
        this.event=event;
    }
    @Override
    public void run(){
      while (true){
            Role role= event.getGuild().getRoleById("714931370383900682");
            role.getManager().setColor(getColor()).queue();
            try {
                Thread.sleep(450);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //TODO:make timer (do this f public but with timer & cool down & mark the main color to return this)(ограничить время мракобесия)
    public Color getColor() {
        if(current== 0) {
            current++;
            return Color.BLUE;
        }
        else if(current== 1) {
            current++;
            return Color.CYAN;
        }
        else if(current== 2) {
            current++;
            return Color.GREEN;
        }
        else if(current== 3) {
            current++;
            return Color.MAGENTA;
        }
        else if(current== 4) {
            current++;
            return Color.ORANGE;
        }
        else if(current== 5) {
            current++;
            return Color.PINK;
        }
        else if(current== 6) {
            current++;
            return Color.RED;
        }
        else if(current== 7) {
            current= 0;
            return Color.YELLOW;
        }
        return Color.YELLOW;
    }

}
