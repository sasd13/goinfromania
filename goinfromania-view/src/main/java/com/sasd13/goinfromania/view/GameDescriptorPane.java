package com.sasd13.goinfromania.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.controller.descriptor.EnumGameDescriptorAction;
import com.sasd13.goinfromania.controller.descriptor.GameDescriptorController;
import com.sasd13.goinfromania.controller.descriptor.IDescriptorView;
import com.sasd13.goinfromania.util.ViewConstants;

public class GameDescriptorPane extends JPanel implements IDescriptorView {

	private static final long serialVersionUID = 3666540380529189296L;

	private static class ViewHolder {
		private JLabel labelLevel, labelScore, labelPigLife, labelPigEnergy, labelDateCreation, labelDateLastUpdate;
		private JButton buttonContinue, buttonDelete;
	}

	private ViewHolder formDescription;
	private GameDescriptorController gameDescriptorController;

	public GameDescriptorPane(FrameView frameView) {
		super(new BorderLayout());

		buildView(frameView);
	}

	private void buildView(FrameView frameView) {
		buildLabelProgress();
		buildPanelDescription();
		buildPanelButtons(frameView);
		setButtonsEnabled(false);
	}

	private void buildLabelProgress() {
		add(new JLabel("Progression", SwingConstants.CENTER), BorderLayout.NORTH);
	}

	private void buildPanelDescription() {
		JPanel panelDescription = new JPanel(new GridLayout(6, 2));

		addLabelsToPanelDescription(panelDescription);
		add(panelDescription, BorderLayout.CENTER);
	}

	private void addLabelsToPanelDescription(JPanel panelDescription) {
		formDescription = new ViewHolder();
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, getFont().getSize());

		addLabelLevel(panelDescription, font);
		addLabelScore(panelDescription, font);
		addLabelPigLife(panelDescription, font);
		addLabelPigEnergy(panelDescription, font);
		addLabelDateCreation(panelDescription, font);
		addLabelDateLastUpdate(panelDescription, font);
	}

	private void addLabelLevel(JPanel panelDescription, Font font) {
		formDescription.labelLevel = new JLabel();
		formDescription.labelLevel.setFont(font);
		panelDescription.add(new JLabel("Niveau"));
		panelDescription.add(formDescription.labelLevel);
	}

	private void addLabelScore(JPanel panelDescription, Font font) {
		formDescription.labelScore = new JLabel();
		formDescription.labelScore.setFont(font);
		panelDescription.add(new JLabel("Score"));
		panelDescription.add(formDescription.labelScore);
	}

	private void addLabelPigLife(JPanel panelDescription, Font font) {
		formDescription.labelPigLife = new JLabel();
		formDescription.labelPigLife.setFont(font);
		panelDescription.add(new JLabel("Vie"));
		panelDescription.add(formDescription.labelPigLife);
	}

	private void addLabelPigEnergy(JPanel panelDescription, Font font) {
		formDescription.labelPigEnergy = new JLabel();
		formDescription.labelPigEnergy.setFont(font);
		panelDescription.add(new JLabel("Energie"));
		panelDescription.add(formDescription.labelPigEnergy);
	}

	private void addLabelDateCreation(JPanel panelDescription, Font font) {
		formDescription.labelDateCreation = new JLabel();
		formDescription.labelDateCreation.setFont(font);
		panelDescription.add(new JLabel("Date creation"));
		panelDescription.add(formDescription.labelDateCreation);
	}

	private void addLabelDateLastUpdate(JPanel panelDescription, Font font) {
		formDescription.labelDateLastUpdate = new JLabel();
		formDescription.labelDateLastUpdate.setFont(font);
		panelDescription.add(new JLabel("Date modification :"));
		panelDescription.add(formDescription.labelDateLastUpdate);
	}

	private void buildPanelButtons(FrameView frameView) {
		JPanel panelButtons = new JPanel();

		addButtonsToPanelButton(panelButtons, frameView);
		add(panelButtons, BorderLayout.SOUTH);
	}

	private void addButtonsToPanelButton(JPanel panelButtons, FrameView frameView) {
		Dimension dimension = new Dimension(ViewConstants.BUTTON_WIDTH, ViewConstants.BUTTON_HEIGHT);
		gameDescriptorController = new GameDescriptorController(frameView, this);

		addButtonContinue(panelButtons, dimension, gameDescriptorController);
		addButtonDelete(panelButtons, dimension, gameDescriptorController);
	}

	private void addButtonContinue(JPanel panelButtons, Dimension dimension, GameDescriptorController gameDescriptorController) {
		formDescription.buttonContinue = new JButton("Continue");

		formDescription.buttonContinue.setPreferredSize(dimension);
		formDescription.buttonContinue.setFocusable(false);
		formDescription.buttonContinue.setActionCommand(EnumGameDescriptorAction.CONTINUE.getCode());
		formDescription.buttonContinue.addActionListener(gameDescriptorController);
		panelButtons.add(formDescription.buttonContinue);
	}

	private void addButtonDelete(JPanel panelButtons, Dimension dimension, GameDescriptorController gameDescriptorController) {
		formDescription.buttonDelete = new JButton("Delete");

		formDescription.buttonDelete.setPreferredSize(dimension);
		formDescription.buttonDelete.setFocusable(false);
		formDescription.buttonDelete.setActionCommand(EnumGameDescriptorAction.DELETE.getCode());
		formDescription.buttonDelete.addActionListener(gameDescriptorController);
		panelButtons.add(formDescription.buttonDelete);
	}

	private void setButtonsEnabled(boolean enabled) {
		formDescription.buttonContinue.setEnabled(enabled);
		formDescription.buttonDelete.setEnabled(enabled);
	}

	@Override
	public boolean askDelete() {
		int selected = JOptionPane.showConfirmDialog(null, "Supprimer la partie?", "Suppression", JOptionPane.YES_NO_OPTION);

		return selected == JOptionPane.YES_OPTION;
	}

	@Override
	public void clear() {
		clearLabels();
		setButtonsEnabled(false);
	}

	private void clearLabels() {
		formDescription.labelLevel.setText("");
		formDescription.labelScore.setText("");
		formDescription.labelPigLife.setText("");
		formDescription.labelPigEnergy.setText("");
		formDescription.labelDateCreation.setText("");
		formDescription.labelDateLastUpdate.setText("");
	}

	public void setGame(Game game) {
		gameDescriptorController.setGame(game);

		setLabels(game);
		setButtonsEnabled(true);
	}

	private void setLabels(Game game) {
		formDescription.labelLevel.setText(String.valueOf(game.getLevel()));
		formDescription.labelScore.setText(String.valueOf(game.getScore()));
		formDescription.labelDateCreation.setText(String.valueOf(game.getDateLastUpdate()));
		formDescription.labelDateLastUpdate.setText(String.valueOf(game.getDateLastUpdate()));
		formDescription.labelPigLife.setText(String.valueOf(game.getArena().getPig().getLife()));
		formDescription.labelPigEnergy.setText(String.valueOf(game.getArena().getPig().getEnergy()));
	}
}
