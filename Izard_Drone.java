package Izard_Drone;
import java.util.Scanner;

/**
 * Author: Dawn Izard
 * Date: Jan 12, 2020
 * Program Name: Izard_Drone
 * Purpose: Simulation using button, drone movement in x,y,z location
 */

public class Izard_Drone {

	static int xpos = 0; 				//variable for x coordinate
  	static int ypos = 0;				//variable for y coordinate
  	static int zpos = 0;				//variable for z coordinate
  	static String xorientation = "";	//variable for East/West orientation
  	static String yorientation = "";	//variable for North/South orientation
  
  	
    public static void main(String[] args) {
            while (true)
            display();			//calls display method
    }
    
        
    public static void display() {
    	Scanner input = new Scanner(System.in);
    	
    	//displays menu
        System.out.println("Which direction would you like to move the drone?");
        System.out.println(
                "1 - Move Up\n" +
                "2 - Move Down\n" +
                "3 - Move Forward\n" +
                "4 - Move Backward\n" +
                "5 - Turn Left\n" +
                "6 - Turn Right\n" +
                "7 - Display Position\n" +
                "8 - Exit Navigation\n " 
        );
        
        //gets input value
        int selection = input.nextInt();
        input.nextLine();
       
        //sets orientation
        if(xpos > 0){
        	xorientation = "West";
        } else if(xpos < 0) {
        	xorientation = "East";
        } else if(ypos > 0){
        	yorientation = "North";
        } else if(ypos < 0) {
        	yorientation = "South";
        } else {
        	yorientation = "";
        	xorientation = "";
        }
                
        //sets coordinates and displays which direction was chosen
        switch(selection) {
            case 1:
                zpos = zpos +1;
                System.out.println("You have moved up");
                break;
            case 2:
                zpos = zpos - 1;
                System.out.println("You have moved down");
                break;
            case 3:
                ypos = ypos + 1;
                System.out.println("You have moved forward");
                break;
            case 4:
                ypos = ypos - 1;
                System.out.println("You have moved backward");
                break;
            case 5:
                xpos = xpos +1;
                System.out.println("You have moved left");
                break;
            case 6:
                xpos = xpos - 1;
                System.out.println("You have moved right");
                break;
            case 7:
                
            	System.out.println("Student Drone [x_pos=" +xpos +
                        ", y_pos=" + ypos +", z_pos=" +zpos +
                        ", orientation= " + yorientation + xorientation + "]");
                break;
            case 8:
                System.out.println("Exited");
            	exit();
                break;
            default:
                System.out.println("Invalid selection.");
                break;
        }
        
        
    }

    	//exits navigation
	   private static void exit() {
        System.exit(1);
    }
    
    
}
