package com.n3wt0n.Pixahl;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Pixahl extends StateBasedGame {

	public static final int MAINMENUSTATE = 0;
	public static final int GAMEPLAYSTATE = 1;

	public Pixahl() {
		super("Generic 2D Platformer");
	}

	public void initStatesList(GameContainer gameContainer)
			throws SlickException {

		gameContainer.setTargetFrameRate(60);
//		gameContainer.setVSync(true);

		 this.addState(new MainMenuState(MAINMENUSTATE));
		// this.addState(new GameplayState(GAMEPLAYSTATE));
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Pixahl());
		app.setDisplayMode(480, 640, false);
		app.setShowFPS(true);
		app.start();
	}
}