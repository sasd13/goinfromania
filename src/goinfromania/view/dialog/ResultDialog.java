package goinfromania.view.dialog;

import goinfromania.game.Game;
import goinfromania.game.Result;
import goinfromania.view.DimensionConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ResultDialog extends GameDialog implements Observer, ActionListener {

	private JLayeredPane layeredPane;
	
	private JPanel panelResult, panelScore, panelButton;
	private JLabel labelResult, labelScore;
	private JButton buttonNew, buttonFinish;
	
	public ResultDialog() {
		super();
		
		Dimension dimension = new Dimension(DimensionConstants.ROUND_POPUP_WIDTH, DimensionConstants.ROUND_POPUP_HEIGHT);
		setSize(dimension);
		
		this.layeredPane = new JLayeredPane();
		setContentPane(this.layeredPane);
		
		this.panelResult = new JPanel(new BorderLayout());
		this.panelResult.setBackground(Color.BLACK);
		this.panelResult.setBounds(0, 0, dimension.width, dimension.height);
		this.layeredPane.add(this.panelResult, JLayeredPane.DEFAULT_LAYER);
		
		Font font = new Font(Font.SANS_SERIF, Font.BOLD | Font.ITALIC, 96);
		
		this.labelResult = new JLabel("", SwingConstants.HORIZONTAL);
		this.labelResult.setFont(font);
		this.labelResult.setForeground(Color.PINK);
		this.panelResult.add(this.labelResult, BorderLayout.CENTER);
		
		panelScore.add(new JLabel("Score : "));
		this.labelScore = new JLabel();
		panelScore.add(this.labelScore);
		
		JPanel panelButton = new JPanel();
		this.panelScore.add(panelButton, BorderLayout.SOUTH);
		
		Dimension dimensionButton = new Dimension(DimensionConstants.BUTTON_WIDTH, DimensionConstants.BUTTON_HEIGHT);
		
		this.buttonNew = new JButton("Suivant");
		this.buttonNew.setPreferredSize(dimensionButton);
		this.buttonNew.setFocusable(false);
		this.buttonNew.addActionListener(this);
		panelButton.add(this.buttonNew);
		
		this.buttonFinish = new JButton("Terminer");
		this.buttonFinish.setPreferredSize(dimensionButton);
		this.buttonFinish.setFocusable(false);
		this.buttonFinish.addActionListener(this);
		panelButton.add(this.buttonFinish);
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Game game = (Game) observable;
		
		if (game.getResult() == Result.WIN) {
			this.labelResult.setText("Gagné!!!");
			this.buttonNew.setEnabled(true);
		} else if (game.getResult() == Result.LOOSE) {
			this.labelResult.setText("Perdu...");
			this.buttonNew.setEnabled(false);
		}
		
		this.labelScore.setText(String.valueOf(game.getScore()));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton button = (JButton) arg0.getSource();
		
		dispose();
		
		//TODO
	}
}
