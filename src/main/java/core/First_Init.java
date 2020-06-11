package core;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class First_Init {
    private static User InitUser;
    private static boolean isInitialize=false;
    private static String memberRoleID;
    private static String messageChannelID;
    private static String banRoleID;
    private static LanguagesAdapter languagesAdapter;
    private static boolean start=false;

    public void stopInitialization(MessageReceivedEvent event){
        this.isInitialize=false;
        this.memberRoleID=null;
        this.messageChannelID=null;
        if (InitUser!=null)
            event.getChannel().sendMessage(event.getAuthor().getName()+languagesAdapter.getFirstInit(11)).queue();
        else event.getChannel().sendMessage(languagesAdapter.getFirstInit(12));
    }
    public String getMemberRule() {
        return memberRoleID;
    }

    public String getMessageChannel() {
        return messageChannelID;
    }

    public boolean isInitialized() {
        return isInitialize;
    }

    public boolean isStart(){return start;}

    public static void Initialize(MessageReceivedEvent event){
        start=true;
        languagesAdapter=new LanguagesAdapter();
        if (InitUser!=null&&event.getAuthor()!=InitUser){
            return;
        }
         if (InitUser==null){
            System.out.println(InitUser);
            InitUser=event.getAuthor();
                event.getChannel().sendMessage("Ok "+InitUser.getName()+languagesAdapter.getFirstInit(0)).queue();
        }

       else if(messageChannelID==null){
                try {
                    System.out.println(event.getGuild().getTextChannelById(event.getMessage().getContentRaw()).getName());
                    messageChannelID = event.getMessage().getContentRaw();
                    event.getChannel().sendMessage(languagesAdapter.getFirstInit(14)).queue();
                } catch (Exception e) {
                    event.getChannel().sendMessage(languagesAdapter.getFirstInit(4)).queue();
                }
        }

        else if (memberRoleID==null) {
            try {
                System.out.println(event.getGuild().getRoleById(event.getMessage().getContentRaw()).getName());
                memberRoleID = event.getMessage().getContentRaw();
                event.getChannel().sendMessage(languagesAdapter.getFirstInit(3)).queue();
            }
            catch (Exception ex){
                event.getChannel().sendMessage(languagesAdapter.getFirstInit(9)).queue();
            }
        }
        else if(banRoleID==null){
            try {
                System.out.println(event.getGuild().getRoleById(event.getMessage().getContentRaw()).getName());
                banRoleID = event.getMessage().getContentRaw();
                isInitialize = true;
                event.getChannel().sendMessage(languagesAdapter.getFirstInit(5)
                        +InitUser.getName()+languagesAdapter.getFirstInit(6)
                        +event.getGuild().getRoleById(memberRoleID).getName()+languagesAdapter.getFirstInit(7)
                        +event.getGuild().getRoleById(banRoleID).getName()+languagesAdapter.getFirstInit(13)
                        +event.getGuild().getTextChannelById(messageChannelID).getName()+languagesAdapter.getFirstInit(8)).queue();
            }
            catch (Exception ex){

            }
         }
    }
}
