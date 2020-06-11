package mute;

import net.dv8tion.jda.api.entities.Guild;

import java.util.ArrayList;
import java.util.Date;

public class MuteThread extends Thread {
    Date currDate;
    Date date;
    Guild guild;
    public MuteThread(Date date, Guild guild){
        this.date=date;
        this.guild=guild;
    }
    @Override
    public void run(){
        while (!isInterrupted()){
            if (MuteVars.muteds.size()==0){
                System.out.println("Muted List is empty");
                MuteVars.current=null;
                interrupt();
                return;
            }
            try {
                sleep(6000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread()+"-interrupted");
                interrupt();
                return;
            }
            currDate=new Date();
            for (int i = 0; i < MuteVars.muteds.size() ; i++) {
                if (currDate.after(MuteVars.muteds.get(i).getUnMuteDate())) {
                    System.out.println("Unmuted " + MuteVars.muteds.get(i).getMember().getUser().getName() + " in thread" + Thread.currentThread());
                    MuteMain.UnMute(i,guild);

                } else {
                    System.out.println("after");
                }
            }
        }
    }
}
