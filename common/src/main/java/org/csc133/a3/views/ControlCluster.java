package org.csc133.a3.views;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.layouts.BorderLayout;

import org.csc133.a3.GameWorld;
import org.csc133.a3.commands.*;

public class ControlCluster extends Container{
     private GameWorld gw;
     private Container container_left;
     private Container container_right;
     private Container container_center;
     private Button accelButton;
     private Button brake;
     private Button right;
     private Button left;
     private Button drink;
     private Button fight;
     private Button exit;


     public ControlCluster(GameWorld world){
         this.gw = world;
		 container_center = new Container(new BorderLayout());
		 container_left = new Container();
		 container_right = new Container();

         this.setLayout(new BorderLayout());
		 //this.getStyle().setBgColor(ColorUtil.GRAY);
		 this.getStyle().setBgTransparency(255);

         accelButton = this.ButtonMaker("Accel", new Accelerate(gw));
         brake = this.ButtonMaker("Brake", new Brake(gw));
         exit = this.ButtonMaker("Exit", new exit(gw));
         left = this.ButtonMaker("Left", new TurnLeftCommand(gw));
         right = this.ButtonMaker("Right", new TurnRightCommand(gw));
         fight = this.ButtonMaker("Fight", new Fight(gw));
         drink = this.ButtonMaker("Drink", new Drink(gw));

         container_center.add(BorderLayout.CENTER, exit);
		 container_left.add(left);
		 container_left.add(right);
		 container_left.add(fight);
		 container_right.add(drink);
		 container_right.add(brake);
		 container_right.add(accelButton);

		 this.add(BorderLayout.CENTER, container_center);
		 this.add(BorderLayout.WEST, container_left);
         this.add(BorderLayout.EAST, container_right);
     }

     private Button ButtonMaker(String str, Command command){
         Button button = new Button(str);
         button.setCommand(command);
         return button;
     }
}
