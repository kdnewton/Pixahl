package com.n3wt0n.Pixahl;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.XMLPackedSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenuState extends BasicGameState {

	protected int stateID = -1;

	protected XMLPackedSheet sheet;
	protected Image imgTitle = null, imgStart = null, imgOptions = null,
			imgQuit = null;

	protected int xTitle = 0, yTitle = 50;
	protected float sTitle = 1.0f;

	protected int xStart = 0, yStart = 250;
	protected float sStart = 1.0f;

	protected int xOptions = 0, yOptions = 350;
	protected float sOptions = 1.0f;

	protected int xQuit = 0, yQuit = 450;
	protected float sQuit = 1.0f;
	
	private float scaleStep = 0.001f;

	public MainMenuState(int stateID) {
		this.stateID = stateID;
	}

	@Override
	public int getID() {
		return stateID;
	}

	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {

		sheet = new XMLPackedSheet("shared/images/Pixahl_Menu_Pack.png",
				"shared/images/Pixahl_Menu_Pack.png.xml");
		imgTitle = sheet.getSprite("Pixahl_Menu_Title.png");
		imgStart = sheet.getSprite("Pixahl_Menu_Start.png");
		imgOptions = sheet.getSprite("Pixahl_Menu_Options.png");
		imgQuit = sheet.getSprite("Pixahl_Menu_Quit.png");

	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {

		xTitle = (gc.getWidth() / 2) - (imgTitle.getWidth() / 2);
		xStart = (gc.getWidth() / 2) - (imgStart.getWidth() / 2);
		xOptions = (gc.getWidth() / 2) - (imgOptions.getWidth() / 2);
		xQuit = (gc.getWidth() / 2) - (imgQuit.getWidth() / 2);

		imgTitle.draw(xTitle, yTitle, sTitle);
		imgStart.draw(xStart, yStart, sStart);
		imgOptions.draw(xOptions, yOptions, sOptions);
		imgQuit.draw(xQuit, yQuit, sQuit);

	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {

		boolean selTitle = false;
		boolean selStart = false;
		boolean selOptions = false;
		boolean selQuit = false;
		
		Input input = gc.getInput();

		int mouseX = input.getMouseX();
		int mouseY = input.getMouseY();
		
		/* Title */
//		if ((mouseX >= xTitle && mouseX <= xTitle + imgTitle.getWidth())
//				&& (mouseY >= yTitle && mouseY <= yTitle + imgTitle.getHeight())) {
//			selTitle = true;
//		}
//		if (selTitle) {
//			if (sTitle < 1.0f)
//				sTitle += sTitle * delta;
//
//			if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
//			}
//		} else {
//			if (sTitle > 0.8f)
//				sTitle -= sTitle * delta;
//		}
		
		/* Start */
		if ((mouseX >= xStart && mouseX <= xStart + imgStart.getWidth())
				&& (mouseY >= yStart && mouseY <= yStart + imgStart.getHeight())) {
			selStart = true;
		}
		if (selStart) {
			if (sStart < 1.25f)
				sStart += scaleStep * delta;

			if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				// sbg.enterState(Pixahl.GAMEPLAYSTATE);
			}
		} else {
			if (sStart > 1.0f)
				sStart -= scaleStep * delta;
		}
		
		/* Options */
		if ((mouseX >= xOptions && mouseX <= xOptions + imgOptions.getWidth())
				&& (mouseY >= yOptions && mouseY <= yOptions + imgOptions.getHeight())) {
			selOptions = true;
		}
		if (selOptions) {
			if (sOptions < 1.25f)
				sOptions += scaleStep * delta;

			if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
			}
		} else {
			if (sOptions > 1.0f)
				sOptions -= scaleStep * delta;
		}

		/* Quit */
		if ((mouseX >= xQuit && mouseX <= xQuit + imgQuit.getWidth())
				&& (mouseY >= yQuit && mouseY <= yQuit + imgQuit.getHeight())) {
			selQuit = true;
		}
		if (selQuit) {
			if (sQuit < 1.25f)
				sQuit += scaleStep * delta;

			if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				gc.exit();
			}
		} else {
			if (sQuit > 1.0f)
				sQuit -= scaleStep * delta;
		}

	}

}