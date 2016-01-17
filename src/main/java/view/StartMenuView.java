package view;

import controller.IStartMenuViewController;
import model.abstractClassesAndInterfaces.IGameManager;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Dmitriy on 17.01.2016.
 */
public class StartMenuView extends JFrame {
    private IStartMenuViewController controller;
    private IGameManager model;
    private JPanel screen;
    private JSlider slider;
    private JCheckBox cpuCheck;
    private JCheckBox humanCheck;
    private JCheckBox automaticShipPlacingCheck;
    private JCheckBox manualShipPlacingCheck;
    public final int SCREEN_WIDTH = 600;
    public final int SCREE_HEIGHT = 300;
    public final int MIN_FIELD_SIZE_VALUE = 2;
    public final int MAX_FIELD_SIZE_VALUE = 40;
    public final int DEFAULT_FIELD_SIZE_VALUE = 10;
    public final int DEFAULT_FIELD_SIZE_STEP = 1;
    public final int SLIDER_WIDTH = 150;
    public final int SLIDER_HEIGHT = 50;


    public StartMenuView(IGameManager model, IStartMenuViewController controller) {
        this.model = model;
        this.controller = controller;
    }

    public IStartMenuViewController getController() {
        return controller;
    }

    public IGameManager getModel() {
        return model;
    }

    public void start() {
        controller.setView(this);
        initGraphics();
    }

    private void initGraphics() {
        frameInitialization();
        playerSettings();
        choiceTableInitialization();
        choiceOfFieldSizeSettings();
        buttonsSettings();
        setVisible(true);
    }


    private void frameInitialization() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - SCREEN_WIDTH) / 2, (screenSize.height - SCREE_HEIGHT) / 2);
        setSize(SCREEN_WIDTH, SCREE_HEIGHT);
        screen = new JPanel();
        screen.setLayout(new BoxLayout(screen, BoxLayout.Y_AXIS));
        screen.setAlignmentX(CENTER_ALIGNMENT);
        screen.setAlignmentY(TOP_ALIGNMENT);
        add(screen);
    }

    private void playerSettings() {
    }

    private void choiceTableInitialization() {
        JLabel header = new JLabel("Choose game type");
        JPanel gridPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gridPlacer = new GridBagConstraints();
        screen.add(header);
        screen.add(gridPanel);

        JLabel opponent = new JLabel("Opponent:");
        JLabel cpuLabel = new JLabel("CPU");
        JLabel humanLabel = new JLabel("Human(through the Internet)");
        Box cpuBox = new Box(BoxLayout.X_AXIS);
        Box humanBox = new Box(BoxLayout.X_AXIS);
        cpuCheck = new JCheckBox();
        cpuCheck.setSelected(true);
        humanCheck = new JCheckBox();
        humanCheck.setSelected(false);
        humanCheck.addActionListener((e) -> cpuCheck.setSelected(!humanCheck.isSelected()));
        cpuCheck.addActionListener((e -> humanCheck.setSelected(!cpuCheck.isSelected())));
        cpuBox.add(cpuCheck);
        cpuBox.add(cpuLabel);
        humanBox.add(humanCheck);
        humanBox.add(humanLabel);
        gridPlacer.anchor = GridBagConstraints.WEST;
        gridPlacer.gridx = 0;
        gridPlacer.gridy = 0;
        gridPanel.add(opponent, gridPlacer);
        gridPlacer.gridx = 1;
        gridPlacer.gridy = 0;
        gridPanel.add(cpuBox, gridPlacer);
        gridPlacer.gridx = 2;
        gridPlacer.gridy = 0;
        gridPanel.add(humanBox, gridPlacer);

        JLabel shipPlacing = new JLabel("Place your ships:");
        JLabel manualShipPlacingLabel = new JLabel("Manually");
        JLabel automaticShipPlacingLabel = new JLabel("Automatic");
        Box manualShipPlacingBox = new Box(BoxLayout.X_AXIS);
        Box automaticShipPlacingBox = new Box(BoxLayout.X_AXIS);
        automaticShipPlacingCheck = new JCheckBox();
        automaticShipPlacingCheck.setSelected(true);
        manualShipPlacingCheck = new JCheckBox();
        manualShipPlacingCheck.setSelected(false);
        automaticShipPlacingCheck.addActionListener((e) -> manualShipPlacingCheck.setSelected(!automaticShipPlacingCheck.isSelected()));
        manualShipPlacingCheck.addActionListener((e) -> automaticShipPlacingCheck.setSelected(!manualShipPlacingCheck.isSelected()));
        manualShipPlacingBox.add(manualShipPlacingCheck);
        manualShipPlacingBox.add(manualShipPlacingLabel);
        automaticShipPlacingBox.add(automaticShipPlacingCheck);
        automaticShipPlacingBox.add(automaticShipPlacingLabel);
        gridPlacer.gridx = 0;
        gridPlacer.gridy = 1;
        gridPanel.add(shipPlacing, gridPlacer);
        gridPlacer.gridx = 1;
        gridPlacer.gridy = 1;
        gridPanel.add(automaticShipPlacingBox, gridPlacer);
        gridPlacer.gridx = 2;
        gridPlacer.gridy = 1;
        gridPanel.add(manualShipPlacingBox, gridPlacer);
    }

    private void choiceOfFieldSizeSettings() {
        JPanel fieldSizePanel = new JPanel();
        JLabel fieldSizeLabel = new JLabel("Set the field size");
        slider = new JSlider(SwingConstants.HORIZONTAL, MIN_FIELD_SIZE_VALUE, MAX_FIELD_SIZE_VALUE, DEFAULT_FIELD_SIZE_VALUE);
        slider.setMajorTickSpacing(DEFAULT_FIELD_SIZE_STEP);
        slider.setPreferredSize(new Dimension(SLIDER_WIDTH, SLIDER_HEIGHT));
        slider.setPaintTicks(true);
        slider.setPaintTrack(true);
        slider.setSnapToTicks(true);
        JLabel currentSize = new JLabel(((Integer) slider.getValue()).toString());
        slider.addChangeListener((e) -> currentSize.setText(String.valueOf(slider.getValue())));
        fieldSizePanel.add(fieldSizeLabel);
        fieldSizePanel.add(slider);
        fieldSizePanel.add(currentSize);
        screen.add(fieldSizePanel);
    }

    private void buttonsSettings() {
        JPanel buttons = new JPanel();
        JButton startButton = new JButton("Start");
        JButton loadButton = new JButton("Load Game");
        JButton statisticButton = new JButton("Statistic");
        startButton.addActionListener((e) -> controller.startGame(humanCheck.isSelected(), manualShipPlacingCheck.isSelected(), slider.getValue()));
        buttons.setBounds(5, 5, 5, 5);
        buttons.add(startButton);
        buttons.add(loadButton);
        buttons.add(statisticButton);
        screen.add(buttons);
    }
}
