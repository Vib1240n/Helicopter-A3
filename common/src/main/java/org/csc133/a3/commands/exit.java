package org.csc133.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import org.csc133.a3.GameWorld;

public class exit extends Command implements ActionListener {
	private final GameWorld gw;

	public exit(GameWorld gw){
		super("Exit");
		this.gw = gw;
	}

	public void actionPerformed(ActionEvent e){
		gw.quit();
	}
}
