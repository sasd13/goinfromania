package goinfromania.view.dialog;

import goinfromania.controller.GameResultController;
import goinfromania.game.Game;
import goinfromania.view.DimensionConstants;
import goinfromania.view.frame.GameView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameDialogResult extends GameDialog {

	private JLabel labelResult, labelScore;
	
	public GameDialogResult(GameView gameView) {
		super(gameView);
	}
	
	@Override
	protected void prepareDialog() {
		super.prepareDialog();
		
		Dimension dimension = new Dimension(DimensionConstants.ROUND_POPUP_WIDTH, DimensionConstants.ROUND_POPUP_HEIGHT);
		
		setSize(dimension);
		setContentPane(new JLayeredPane());
		
		Font font = new Font(Font.SANS_SERIF, Font.BOLD | Font.ITALIC, 96);
		
		createLayerResult(dimension, font);
		createLayerScore(dimension);
	}

	private void createLayerResult(Dimension dimension, Font font) {
		JPanel panelResult = makeNewPanel(dimension);
		
		createLabelOfLayerResult(font, panelResult);
		
		getContentPane().add(panelResult, JLayeredPane.DEFAULT_LAYER);
	}

	private void createLabelOfLayerResult(Font font, JPanel panelResult) {
		this.labelResult = new JLabel("", SwingConstants.HORIZONTAL);
		this.labelResult.setFont(font);
		this.labelResult.setForeground(Color.PINK);
		
		panelResult.add(this.labelResult, BorderLayout.CENTER);
	}
	
	private JPanel makeNewPanel(Dimension dimension) {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, dimension.width, dimension.height);
		
		return panel;
	}

	private void createLayerScore(Dimension dimension) {
		JPanel panelScore = makeNewPanel(dimension);
		panelScore.add(new JLabel("Score"), BorderLayout.NORTH);
		
		createLabelOfLayerScore(panelScore);
		createButtonsOfLayerScore(panelScore);
		
		getContentPane().add(panelScore, JLayeredPane.DEFAULT_LAYER);
	}

	private void createLabelOfLayerScore(JPanel panelScore) {
		this.labelScore = new JLabel("", SwingConstants.HORIZONTAL);
		
		panelScore.add(this.labelScore, BorderLayout.CENTER);
	}

	private void createButtonsOfLayerScore(JPanel panelScore) {
		JPanel panelButtons = new JPanel();
		
		JButton[] buttons = {
				new JButton("Rejouer"),
				new JButton("Terminer")
		};
		
		Dimension dimensionButton = new Dimension(DimensionConstants.BUTTON_WIDTH, DimensionConstants.BUTTON_HEIGHT);
		String command = null;
		
		int indice = -1;
		for (JButton button : buttons) {
			indice++;
			
			switch (indice) {
				case 0:
					command = "REPLAY";
					break;
				case 1:
					command = "END";
					break;
			}
			
			button.setPreferredSize(dimensionButton);
			button.setFocusable(false);
			button.setActionCommand(command);
			button.addActionListener(new GameResultController());
			
			panelButtons.add(button);
		}
		
		panelScore.add(panelButtons, BorderLayout.SOUTH);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Game game = (Game) observable;
		
		switch (game.getResult()) {
			case WIN:
				this.labelResult.setText("Gagn�!!!");
				break;
			case LOOSE:
				this.labelResult.setText("Perdu...");
				break;
		}
		this.labelScore.setText(String.valueOf(game.getScore()));
		
		super.update(observable, arg);
	}
}
