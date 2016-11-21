import greenfoot.*;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

public class LeaderBoardScreen extends Screen {
    
    SimpleDateFormat df = new SimpleDateFormat("mm:ss");

    public LeaderBoardScreen(GameWorld world) {
        super(world);
    }

    @Override
    public void setNextScreen(IScreen screen) {
    }
    
    @Override
    public void setPreviousScreen() { 
        world.setScreen(ScreenFactory.getScreen(ScreenType.START, world));
        clearScreen();
        world.getScreen().displayScreen();
    }

    @Override
    public void displayScreen() { 
        world.setBackground(new GreenfootImage("S9.jpg"));
        List<Score> scoreList = Server.getLeaderBoard();
        int y = 200;
        int size = scoreList.size();
        for(int i = 0; i < size; i++){
            Score score = scoreList.get(i);
            int time = score.getTime();
            String timeStr = df.format(new Date(time * 1000));
            String name = score.getName();
            Text nameText = new Text(name.length() > 18 ? name.substring(0, 15) + "..." : name);
            //Text scoreText  =new Text(timeStr);
            world.addObject(nameText, 555, y + i * (i <= size / 2 ? 65 : 64));
            //world.addObject(scoreText, 700, y + i * (i <= size / 2 ? 65 : 64));
       }
        world.addObject(new PlayAgain(world), 555, 540);
    }

    @Override
    public void clearScreen() {
        world.removeObjects(world.getObjects(Actor.class));
    }

}
