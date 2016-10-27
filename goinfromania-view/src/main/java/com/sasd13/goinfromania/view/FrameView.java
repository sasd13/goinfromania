package com.sasd13.goinfromania.view;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import com.sasd13.goinfromania.bean.Game;
import com.sasd13.goinfromania.bean.setting.Gamepad;
import com.sasd13.goinfromania.bean.setting.Setting;
import com.sasd13.goinfromania.controller.FrameController;
import com.sasd13.goinfromania.controller.IDialogView;
import com.sasd13.goinfromania.controller.IFrameView;
import com.sasd13.goinfromania.controller.IGameView;
import com.sasd13.goinfromania.util.GameConstants;
import com.sasd13.goinfromania.util.ViewConstants;
import com.sasd13.goinfromania.view.dialog.SettingDialog;
import com.sasd13.goinfromania.view.dialog.SettingDialogFactory;
import com.sasd13.goinfromania.view.menu.MenuBar;

public class FrameView extends JFrame implements IFrameView {

	private static final long serialVersionUID = -8274874279164299983L;
	
	private MenuBar menuBar;
	private JLayeredPane layersPane;
	private HomeView homeView;
	private GamesView gamesView;
	private GameView gameView;
	private FrameController frameController;

	public FrameView(Gamepad gamepad) {
		super(GameConstants.NAME);

		buildView(gamepad);
	}

	private void buildView(Gamepad gamepad) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		buildMenuBar(gamepad);
		buildLayersPane(gamepad);
		buildFrameController();
	}

	private void buildMenuBar(Gamepad gamepad) {
		menuBar = new MenuBar(this);

		menuBar.setGamepad(gamepad);
		setJMenuBar(menuBar);
	}

	private void buildLayersPane(Gamepad gamepad) {
		layersPane = new JLayeredPane();
		Dimension dimension = new Dimension(ViewConstants.PANEL_WIDTH, ViewConstants.PANEL_HEIGHT);

		layersPane.setPreferredSize(dimension);
		addLayerHome(dimension);
		addLayerGames(dimension);
		addLayerGame(dimension, gamepad);
		getContentPane().add(layersPane);
	}

	private void addLayerHome(Dimension dimension) {
		homeView = new HomeView();

		homeView.setBounds(0, 0, dimension.width, dimension.height);
		homeView.setVisible(false);
		layersPane.add(homeView, JLayeredPane.DEFAULT_LAYER);
	}

	private void addLayerGames(Dimension dimension) {
		gamesView = new GamesView(this);

		gamesView.setBounds(0, 0, dimension.width, dimension.height);
		gamesView.setVisible(false);
		layersPane.add(gamesView, JLayeredPane.DEFAULT_LAYER);
	}

	private void addLayerGame(Dimension dimension, Gamepad gamepad) {
		gameView = new GameView(this, gamepad);

		gameView.setBounds(0, 0, dimension.width, dimension.height);
		gameView.setVisible(false);
		layersPane.add(gameView, JLayeredPane.DEFAULT_LAYER);
	}

	private void buildFrameController() {
		frameController = new FrameController(this);

		addWindowListener(frameController);
	}

	@Override
	public void displayHome() {
		menuBar.setMenuEditEnabled(false);

		homeView.setVisible(true);
		layersPane.moveToFront(homeView);
		gameView.setVisible(false);
		gamesView.setVisible(false);
	}

	@Override
	public void displayGames(List<Game> games) {
		menuBar.setMenuEditEnabled(false);
		gamesView.setGames(games);

		gamesView.setVisible(true);
		layersPane.moveToFront(gamesView);
		homeView.setVisible(false);
		gameView.setVisible(false);
	}

	@Override
	public IGameView displayGame(Game game) {
		menuBar.setMenuEditEnabled(true);
		menuBar.setGame(game);
		frameController.setGame(game);
		gameView.displayGame(game);

		gameView.setVisible(true);
		layersPane.moveToFront(gameView);
		homeView.setVisible(false);
		gamesView.setVisible(false);

		return gameView;
	}

	@Override
	public IDialogView displaySetting(Setting setting) {
		SettingDialog settingDialog = SettingDialogFactory.make(setting.getCode(), setting, this);

		setting.addObserver(settingDialog);
		settingDialog.update(setting, null);
		settingDialog.pack();
		settingDialog.setLocationRelativeTo(this);
		settingDialog.setVisible(true);

		return settingDialog;
	}

	@Override
	public boolean askClose() {
		int selected = JOptionPane.showConfirmDialog(null, "Quitter le jeu?", "Sortie", JOptionPane.YES_NO_OPTION);

		return selected == JOptionPane.YES_OPTION;
	}
}
