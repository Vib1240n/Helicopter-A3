package org.csc133.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import org.csc133.a3.GameWorld;

public class Accelerate extends Command{
	private final GameWorld gw;

	public Accelerate(GameWorld gw){
		super("Accelerate");
		this.gw = gw;
	}

	public void actionPerformed(ActionEvent e){
		gw.adjustSpeed(1);
	}
}
