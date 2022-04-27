package org.csc133.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import org.csc133.a3.GameWorld;

public class Brake extends Command implements ActionListener {

	private final GameWorld gw;
	public Brake(GameWorld gw){
		super("Brake");
		this.gw = gw;
	}

	public void actionPerformed( ActionEvent e){
		gw.Brake();
	}
}
