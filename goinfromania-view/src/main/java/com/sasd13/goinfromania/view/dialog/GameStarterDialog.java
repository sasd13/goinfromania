package com.sasd13.goinfromania.view.dialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.sasd13.goinfromania.controller.IDialogView;
import com.sasd13.goinfromania.util.ViewConstants;

public class GameStarterDialog extends JDialog implements IDialogView, ActionListener {

	private static final long serialVersionUID = -1378266883448515264L;
	
	private JLayeredPane layeredPane;
	private JPanel panelReady, panelGo;

	private int count;
	private Timer timer;

	public GameStarterDialog() {
		super();

		timer = new Timer(0, this);

		buildView();
	}

	private void buildView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setUndecorated(true);
		setSize(new Dimension(ViewConstants.ROUND_POPUP_WIDTH, ViewConstants.ROUND_POPUP_HEIGHT));
		setBackground(Color.BLACK);
		buildLayers();
	}

	private void buildLayers() {
		layeredPane = new JLayeredPane();
		Font font = new Font(Font.SANS_SERIF, Font.BOLD | Font.ITALIC, 96);

		setContentPane(layeredPane);
		buildLayerReady(font);
		buildLayerGo(font);
	}

	private void buildLayerReady(Font font) {
		panelReady = new JPanel();

		panelReady.setBackground(Color.BLACK);
		panelReady.setBounds(0, 0, ViewConstants.ROUND_POPUP_WIDTH, ViewConstants.ROUND_POPUP_HEIGHT);
		addLabelReady(font);
		layeredPane.add(panelReady, JLayeredPane.DEFAULT_LAYER);
	}

	private void addLabelReady(Font font) {
		JLabel labelReady = new JLabel("Ready !");

		labelReady.setFont(font);
		labelReady.setForeground(Color.PINK);
		panelReady.add(labelReady);
	}

	private void buildLayerGo(Font font) {
		panelGo = new JPanel();

		panelGo.setBackground(Color.BLACK);
		panelGo.setBounds(0, 0, ViewConstants.ROUND_POPUP_WIDTH, ViewConstants.ROUND_POPUP_HEIGHT);
		addLabelGo(font);
		layeredPane.add(panelGo, JLayeredPane.DEFAULT_LAYER);
	}

	private void addLabelGo(Font font) {
		JLabel labelGo = new JLabel("Go !");

		labelGo.setFont(font);
		labelGo.setForeground(Color.PINK);
		panelGo.add(labelGo);
	}

	public void startTimer() {
		count = -1;
		timer.setDelay(1200);
		timer.restart();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		count++;

		if (count == 0) {
			hideReadyAndGo();
		} else if (count == 1) {
			displayReady();
		} else if (count == 2) {
			displayGo();
		} else {
			timer.stop();
			dispose();
		}
	}

	private void hideReadyAndGo() {
		panelReady.setVisible(false);
		panelGo.setVisible(false);
	}

	private void displayReady() {
		panelReady.setVisible(true);
		layeredPane.moveToFront(panelReady);
		panelGo.setVisible(false);
	}

	private void displayGo() {
		panelGo.setVisible(true);
		layeredPane.moveToFront(panelGo);
		panelReady.setVisible(false);
	}
}
