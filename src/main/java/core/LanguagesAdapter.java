package core;

import texts.texts;

public class LanguagesAdapter {
    private texts texts;
    {
        texts=new texts();
    }

    public String getFirstInit(int index){
        if(Bot.languages.equals(Languages.ENGLISH)){
            return texts.firstInitEng[index];
        }
        if(Bot.languages.equals(Languages.RUSSIAN)){
            return texts.firstInitRus[index];
        }
        return null;
    }
    public String getCommands(){
        if(Bot.languages.equals(Languages.ENGLISH)){
            return texts.allCommandsEng;
        }
        if(Bot.languages.equals(Languages.RUSSIAN)){
            return texts.allCommandsRus;
        }
        return null;
    }
}
