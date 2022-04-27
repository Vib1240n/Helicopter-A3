package org.csc133.a3.views;

import com.codename1.ui.Container;

import com.codename1.ui.Label;
import com.codename1.ui.layouts.GridLayout;
import org.csc133.a3.GameWorld;

public class GlassCockpit extends Container {
     private GameWorld gw;

	 Label Speed_label;
	 Label Fires_label;
	 Label heading_label;
	 Label fuel_label;
	 Label firesize_label;
	 Label loss_label;
	 Label damage_label;

     public GlassCockpit(GameWorld world){
         this.gw = world;

		 Speed_label = new Label("0");
		 firesize_label = new Label("0");
		 heading_label = new Label("0");
		 fuel_label = new Label("0");
		 Fires_label = new Label("0");
		 loss_label = new Label("0");
		 damage_label = new Label("0");

		 this.setLayout(new GridLayout(2, 7));
		 this.getAllStyles().setBgTransparency(255);
		 this.add("HEADING");
		 this.add("SPEED");
		 this.add("FUEL");
		 this.add("FIRES");
		 this.add("FIRE SIZE");
		 this.add("DAMAGE");
		 this.add("LOSS");
		 this.add(heading_label);
		 this.add(Speed_label);
		 this.add(fuel_label);
		 this.add(Fires_label);
		 this.add(firesize_label);
		 this.add(damage_label);
		 this.add(loss_label);

     }

	 public void update(){
		 heading_label.setText(gw.getHeading());
		 Speed_label.setText(gw.getSpeed());
		 firesize_label.setText(gw.getFireSize());
		 Fires_label.setText(gw.TotalFires());
		 fuel_label.setText(gw.getFuel());
		 damage_label.setText(gw.getDamage());
	}
}
