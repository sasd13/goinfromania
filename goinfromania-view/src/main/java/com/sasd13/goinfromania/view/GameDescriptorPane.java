package com.sasd13.goinfromania.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.bean.character.Pig;
import com.sasd13.goinfromania.controller.IFrame;
import com.sasd13.goinfromania.controller.descriptor.EnumGameDescriptorActionType;
import com.sasd13.goinfromania.controller.descriptor.GameDescriptorController;
import com.sasd13.goinfromania.controller.descriptor.IDescriptor;
import com.sasd13.goinfromania.util.ViewConstants;

public class GameDescriptorPane extends JPanel implements IDescriptor {

	private static class ViewHolder {
		private JLabel labelLevel, labelScore, labelPigLife, labelPigEnergy, labelDateCreation, labelDateLastUpdate;
		private JButton buttonContinue, buttonDelete;
	}

	private ViewHolder formGame;
	private IFrame frame;
	private Game game;

	public GameDescriptorPane(IFrame frame) {
		super(new BorderLayout());

		this.frame = frame;

		createLabelProgress();
		createPanelDescription();
		createPanelButtons();
		setButtonsEnabled(false);
	}

	private void createLabelProgress() {
		add(new JLabel("Progression", SwingConstants.CENTER), BorderLayout.NORTH);
	}

	private void createPanelDescription() {
		JPanel panelGame = new JPanel(new GridLayout(6, 2));

		addLabelsToPanelGame(panelGame);
		add(panelGame, BorderLayout.CENTER);
	}

	private void addLabelsToPanelGame(JPanel panelGame) {
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, getFont().getSize());

		formGame.labelLevel = new JLabel();
		formGame.labelLevel.setFont(font);
		panelGame.add(new JLabel("Niveau"));
		panelGame.add(formGame.labelLevel);

		formGame.labelScore = new JLabel();
		formGame.labelScore.setFont(font);
		panelGame.add(new JLabel("Score"));
		panelGame.add(formGame.labelScore);

		formGame.labelPigLife = new JLabel();
		formGame.labelPigLife.setFont(font);
		panelGame.add(new JLabel("Vie"));
		panelGame.add(formGame.labelPigLife);

		formGame.labelPigEnergy = new JLabel();
		formGame.labelPigEnergy.setFont(font);
		panelGame.add(new JLabel("Energie"));
		panelGame.add(formGame.labelPigEnergy);

		formGame.labelDateCreation = new JLabel();
		formGame.labelDateCreation.setFont(font);
		panelGame.add(new JLabel("Date creation"));
		panelGame.add(formGame.labelDateCreation);

		formGame.labelDateLastUpdate = new JLabel();
		formGame.labelDateLastUpdate.setFont(font);
		panelGame.add(new JLabel("Date modification :"));
		panelGame.add(formGame.labelDateLastUpdate);
	}

	private void createPanelButtons() {
		JPanel panelButton = new JPanel();

		addButtonsToPanelButton(panelButton);
		add(panelButton, BorderLayout.SOUTH);
	}

	private void addButtonsToPanelButton(JPanel panelButton) {
		Dimension dimension = new Dimension(ViewConstants.BUTTON_WIDTH, ViewConstants.BUTTON_HEIGHT);
		GameDescriptorController gameDescriptorController = new GameDescriptorController(frame, this);

		formGame.buttonContinue = new JButton("Continue");
		formGame.buttonContinue.setPreferredSize(dimension);
		formGame.buttonContinue.setFocusable(false);
		formGame.buttonContinue.setActionCommand(EnumGameDescriptorActionType.CONTINUE.getCode());
		formGame.buttonContinue.addActionListener(gameDescriptorController);
		panelButton.add(formGame.buttonContinue);

		formGame.buttonDelete = new JButton("Delete");
		formGame.buttonDelete.setPreferredSize(dimension);
		formGame.buttonDelete.setFocusable(false);
		formGame.buttonDelete.setActionCommand(EnumGameDescriptorActionType.DELETE.getCode());
		formGame.buttonDelete.addActionListener(gameDescriptorController);
		panelButton.add(formGame.buttonDelete);
	}

	public void bind(Game game) {
		this.game = game;

		formGame.labelLevel.setText(String.valueOf(game.getLevel()));
		formGame.labelScore.setText(String.valueOf(game.getScore()));
		formGame.labelDateCreation.setText(String.valueOf(game.getDateLastUpdate()));
		formGame.labelDateLastUpdate.setText(String.valueOf(game.getDateLastUpdate()));

		Pig pig = game.getPig();
		formGame.labelPigLife.setText(String.valueOf(pig.getLife()));
		formGame.labelPigEnergy.setText(String.valueOf(pig.getEnergy()));

		setButtonsEnabled(true);
	}

	@Override
	public Game getDescriptable() {
		return game;
	}

	@Override
	public void clear() {
		clearLabels();
		setButtonsEnabled(false);
	}

	private void clearLabels() {
		formGame.labelLevel.setText("");
		formGame.labelScore.setText("");
		formGame.labelPigLife.setText("");
		formGame.labelPigEnergy.setText("");
		formGame.labelDateCreation.setText("");
		formGame.labelDateLastUpdate.setText("");
	}

	private void setButtonsEnabled(boolean enabled) {
		formGame.buttonContinue.setEnabled(enabled);
		formGame.buttonDelete.setEnabled(enabled);
	}
}
