package Code;
import com.birdbraintechnologies.HummingbirdRobot;

import java.util.ArrayList;
import java.util.Scanner;
public class SpiderRobot extends HummingbirdRobot{

    public void stalk() throws InterruptedException{
        Scanner s = new Scanner(System.in);
        int trigger = 100;
        System.out.println("How many people do you want to spook?");
        Scanner x = new Scanner(System.in);
        String[] names = new String[s.nextInt()];
        for(int i = 0; i < names.length; i++){
            System.out.println("Who is getting spooked?");
            names[i] = x.nextLine();
        }
        
        int counter = 0;
        setFullColorLED(1, 255, 0, 0);
        setFullColorLED(2, 255, 0, 0);
        byte[] sound = PlaySound.fileToByte("H:\\APCSA\\HummingEclipse\\HummingEclipse\\src\\Code\\spidersound_6bdyVEPL.wav");
        for(int i = 0; i < names.length; i++){
            setFullColorLED(1, 255, 0, 0);
            setFullColorLED(2, 255, 0, 0);
            counter = 0;
            while (counter < 60000){
                trigger = getSensorValue(1);
                if(trigger < 50){
                    System.out.println("TRIGGER!");
                    setFullColorLED(1, 0, 0, 255);
                    setFullColorLED(2, 0, 0, 255);           
                    playClip(sound);
                    Thread.sleep(2000);
                    System.out.println(nameGame(names[i]));
                    speak(nameGame(names[i]));
                    Thread.sleep(5000);
                    break;
                }
                else{
                    Thread.sleep(1000);                   
                    counter += 1000;
                }
            }
        }
        Thread.sleep(1000);
        playClip(PlaySound.fileToByte("H:\\APCSA\\HummingEclipse\\HummingEclipse\\src\\Code\\spiderDeath.wav"));
        Thread.sleep(1000);
    }

    public String nameGame(String name) throws InterruptedException{
        String sub;
        if(name.length() > 1)
            sub = name.substring(1);
        else
            sub = name;
        return name + " " + name + " bo B" + sub + " bannana fana fo f" + sub + " fee fi mo M" + sub + ", " + name;

    }
}