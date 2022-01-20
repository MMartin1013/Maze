package maze;

import java.util.ArrayList;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class Gui {
    private MazeGenerator gen;
    private Integer[] boundsOptions = {5,6,7,8,9,10};
    private JFrame window;
    private JPanel mainPanel;
    private JPanel infoPanel;
    private JPanel mazePanel;
    private JPanel buttonPanel;
    private JButton exitButton;
    private ActionHandler handler;
    private JButton createMazeButton;
    private JButton clearButton;
    private JComboBox changeBoundsButton;
    private JLabel holderLabel;
    private JLabel changeBoundsLabel;
    private JLabel directionsLabel;

    public Gui(){
        gen = new MazeGenerator();
        handler = new ActionHandler();
        window = new JFrame();
        mainPanel = new JPanel();
        infoPanel = new JPanel();
        mazePanel = new JPanel();
        buttonPanel = new JPanel();
        directionsLabel = new JLabel("This Program Generates Mazes from bounds 5x5 to 10x10");
        holderLabel = new JLabel("Click create maze to create a new maze!");
        changeBoundsLabel = new JLabel("Bounds:");
        createMazeButton = new JButton("Create Maze");
        exitButton = new JButton("Exit");
        clearButton = new JButton("Clear Maze");
        changeBoundsButton = new JComboBox(boundsOptions);

        mainPanel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        infoPanel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        infoPanel.setLayout(new FlowLayout());
        
        mazePanel.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
        mazePanel.setLayout(new GridLayout(gen.getBounds(),gen.getBounds()));
        mazePanel.setBackground(Color.WHITE);
        
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        buttonPanel.setLayout(new FlowLayout());
        
        infoPanel.add(directionsLabel);
        
        mazePanel.add(holderLabel);

        clearButton.addActionListener(handler);
        changeBoundsButton.addActionListener(handler);
        exitButton.addActionListener(handler);
        createMazeButton.addActionListener(handler);
        buttonPanel.add(changeBoundsLabel);
        buttonPanel.add(changeBoundsButton);
        buttonPanel.add(createMazeButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        mainPanel.add(infoPanel);
        mainPanel.add(mazePanel);
        mainPanel.add(buttonPanel);
        
    
        window.add(mainPanel, BorderLayout.CENTER);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Maze");
        window.pack();
        window.setSize(465,780);
        window.setResizable(false);
        window.setVisible(true);
    }

    private class ActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == exitButton) {
                window.dispose();
            }else if(e.getSource() == createMazeButton) {
                handleCreateMaze();
            }else if(e.getSource() == changeBoundsButton) {
                gen.changeBounds((Integer)changeBoundsButton.getSelectedItem());
                mazePanel.setLayout(new GridLayout(gen.getBounds(),gen.getBounds()));
            }else if(e.getSource() == clearButton) {
                mazePanel.removeAll();
                mazePanel.add(holderLabel);
                window.setVisible(true);
            }
        }

        private void handleCreateMaze() {
            mazePanel.removeAll();
            gen.generateMaze();
            Vertex[][] matrix = gen.getGraph().getAdjMatrix();
            
            
            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[i].length; j++) {
                    JLabel label = new JLabel(" ");
                    ArrayList<Edge> edges = matrix[i][j].getEdges();
                    
                    int top = (i == 0) ? 1 : 0;
                    int right = 1;
                    int left = (j == 0) ? 1 : 0;
                    int bottom = 1;
                    
                    for(Edge edge : edges){
                        if(edge.getSource().getId() + 1 == edge.getDestination().getId()) {
                            right = 0;
                        }else if(edge.getSource().getId() + matrix.length == edge.getDestination().getId()) {
                            bottom = 0;
                        }
                    }
                    
                    label.setBorder(BorderFactory.createMatteBorder(top, left, bottom, right, Color.BLACK));
                    mazePanel.add(label);
                }
            }
            window.setVisible(true);
        }
    }
}
