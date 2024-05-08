/**
 * This is an Exercise tracker using JavaFx.
 * TThe user will have to login order to input data into the tracker; the user can log out as needed and make the tracker field uneditable
 * Once it is inputted, it will be displayed in the Exercise Summary
 * The user can also save the file to the computer and exit it
 * 
 */

package application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Exercise Tracker Class extends Jframe for the GUI
 */
public class ExerciseTracker extends JFrame {
    private List<Exercise> exerciseList;
    private JTextField txtName, txtDate, txtDuration, txtComment, txtDistance;
    private JComboBox<String> cmbType;
    private JButton btnAddExercise;
    private JTextArea txtAreaSummary;
    private LoginFrame loginFrame;

    private boolean isLoggedIn = false;

    /**
     * Exercise Tracker method
     */
    public ExerciseTracker() {
        exerciseList = new ArrayList<>();
        loginFrame = LoginFrame.V(this);

        //Sets title in Border
        setTitle("Exercise Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Add Menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // File Menu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem loginMenuItem = new JMenuItem("Login");
        JMenuItem logoutMenuItem = new JMenuItem("Logout");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        fileMenu.add(loginMenuItem);
        fileMenu.add(logoutMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(exitMenuItem);

        // Help Menu
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);

        JMenuItem aboutMenuItem = new JMenuItem("About");
        helpMenu.add(aboutMenuItem);

        // Action listener for login menu item
        loginMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        //Action listener for logout menu item
        logoutMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });

        //Action listener for save Menu item
        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveSummaryToFile();
            }
        });

        //Action Listener for exit menu item
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the application
            }
        });

        aboutMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAboutMessage();
            }
        });

     // Left Panel
        JPanel panelForm = new JPanel(new GridLayout(7, 2, 5, 5));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        cmbType = new JComboBox<>(new String[]{"Run/Walk", "Weightlifting", "Rock Climbing"});
        panelForm.add(new JLabel("Type:"));
        panelForm.add(cmbType);

        panelForm.add(new JLabel("Name:"));
        txtName = new JTextField();
        txtName.setEditable(false); // Initially not editable
        panelForm.add(txtName);

        panelForm.add(new JLabel("Date:"));
        txtDate = new JTextField();
        txtDate.setEditable(false);// Initially not editable
        panelForm.add(txtDate);

        panelForm.add(new JLabel("Duration:"));
        txtDuration = new JTextField();
        txtDuration.setEditable(false);// Initially not editable
        panelForm.add(txtDuration);

        panelForm.add(new JLabel("Distance:")); // Added distance field
        txtDistance = new JTextField();
        txtDistance.setEditable(false);// Initially not editable
        panelForm.add(txtDistance);

        panelForm.add(new JLabel("Add Comment:"));
        txtComment = new JTextField();
        panelForm.add(txtComment);

        JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnAddExercise = new JButton("Add Exercise");
        panelButtons.add(btnAddExercise);

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(panelForm, BorderLayout.NORTH);
        leftPanel.add(panelButtons, BorderLayout.CENTER);

        // Right Panel
        txtAreaSummary = new JTextArea();
        txtAreaSummary.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtAreaSummary);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(new JLabel("Exercise Summary", SwingConstants.CENTER), BorderLayout.NORTH);
        rightPanel.add(scrollPane, BorderLayout.CENTER);

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

        // Bottom Panel
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add Exercise Panel
        JPanel addExercisePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        addExercisePanel.add(btnAddExercise);
        
        //Add exercise to exercise button
        btnAddExercise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addExercise();
            }
        });
        bottomPanel.add(addExercisePanel, BorderLayout.CENTER); // Add the addExercise panel to the center

        add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * Login
     */
    private void login() {
        loginFrame.setVisible(true);
    }

    /**
     * Logout
     */
    private void logout() {
        isLoggedIn = false;
        setFieldsEditable(false);
    }

    /**
     * Save summary to file
     */
    private void saveSummaryToFile() {
        if (!exerciseList.isEmpty()) {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showSaveDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
                    for (Exercise exercise : exerciseList) {
                        writer.println(exercise.toSummaryString());
                    }
                    writer.flush();
                    JOptionPane.showMessageDialog(this, "Summary saved to: " + file.getAbsolutePath(), "Save Successful", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error saving summary to file!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No exercises to save!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * About Message
     */
    private void showAboutMessage() {
        JOptionPane.showMessageDialog(this, "Exercise Tracker: Assignment 9", "About", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Add exercise, if not logged in, error message shows
     */
    
    private void addExercise() {
    	 if (!isLoggedIn) {
    	        JOptionPane.showMessageDialog(this, "Please log in before adding exercises.", "Login Required", JOptionPane.WARNING_MESSAGE);
    	        return;
    	    }

    	 	// Variables
    	    String name = txtName.getText();
    	    String dateString = txtDate.getText();
    	    double duration;
    	    double distance;
    	    String comment = txtComment.getText();
    	    String type = (String) cmbType.getSelectedItem();

    	    // Validate duration and distance
    	    try {
    	        duration = Double.parseDouble(txtDuration.getText());
    	        distance = Double.parseDouble(txtDistance.getText());
    	    } catch (NumberFormatException e) {
    	        JOptionPane.showMessageDialog(this, "Please enter valid numeric values for duration and distance.", "Input Error", JOptionPane.ERROR_MESSAGE);
    	        return;
    	    }

    	    // Parse date string into a Date object
    	    Date date;
    	    try {
    	        date = new SimpleDateFormat("MM/dd/yyyy").parse(dateString);
    	    } catch (ParseException e) {
    	        JOptionPane.showMessageDialog(this, "Please enter a valid date in the format MM/dd/yyyy.", "Input Error", JOptionPane.ERROR_MESSAGE);
    	        return;
    	    }

    	    // Create exercise based on selected type
    	    Exercise exercise;
    	    switch (type) {
    	        case "Run/Walk":
    	            exercise = new RunWalk(name, date, duration, comment, distance);
    	            break;
    	        case "Weightlifting":
    	            exercise = new WeightLifting(name, date, duration, comment, distance);
    	            break;
    	        case "Rock Climbing":
    	        	double wallHeight = (int) distance; // distance represents wall height
    	            int repetitions = (int) duration; //  duration represents repetitions
    	            exercise = new RockClimbing(name, date, duration, comment, wallHeight, repetitions);
    	            break;
    	        default:
    	            exercise = null;
    	            break;
    	    }

    	    if (exercise != null) {
    	        exerciseList.add(exercise);
    	        updateSummary();
    	        clearFields();
    	    }
    	}

    /**
     * Updates Summary
     */
    private void updateSummary() {
    	 txtAreaSummary.setText("");
    	    for (Exercise exercise : exerciseList) {
    	        txtAreaSummary.append(exercise.toSummaryString() + "\n");
    	    }
    }

    /**
     * Clear Fields
     */
    private void clearFields() {
    	txtName.setText("");
        txtDate.setText("");
        txtDuration.setText("");
        txtDistance.setText("");
        txtComment.setText("");    }

    /**
     * Sets Fields to be Editable
     * @param editable
     */
    private void setFieldsEditable(boolean editable) {
        txtName.setEditable(editable);
        txtDate.setEditable(editable);
        txtDuration.setEditable(editable);
        txtDistance.setEditable(editable);
        txtComment.setEditable(editable);
    }

    /**
     * Enable Fields
     */
    public void enableAll() {
        isLoggedIn = true;
        setFieldsEditable(true);
    }

    /**
     * Runs Exercise Tracker
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ExerciseTracker().setVisible(true);
            }
        });
    }
}


     