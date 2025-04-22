import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingGUI extends JFrame {
    private SortedList sortedList = new SortedList();
    private JTextField inputField;
    private JTextArea displayArea;
    private JButton addButton;
    private JButton searchButton;

    public SwingGUI() {
        setTitle("Sorted List GUI");
        setLocationRelativeTo(null);
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(1,3));
        inputField = new JTextField();
        addButton = new JButton("Add");
        searchButton = new JButton("Search");

        topPanel.add(inputField);
        topPanel.add(addButton);
        topPanel.add(searchButton);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setupAddButton();
        setupSearchButton();
    }

    private void setupAddButton() {
        addButton.addActionListener(e -> {
            String text = inputField.getText().trim();
            if(!text.isEmpty()) {
                sortedList.add(text);
                inputField.setText("");
                updateDisplay("Added: " + text);
            }
        });
    }

    private void setupSearchButton() {
        searchButton.addActionListener(e -> {
            String text = inputField.getText().trim();
            if(!text.isEmpty()) {
                int index = sortedList.search(text);
                if(index >= 0) {
                    updateDisplay("Found '" + text + "' at index: " + index);
                } else {
                    int insertionPoint = -index - 1;
                    updateDisplay("'" + text + "' not found. Would be inserted at index: " + insertionPoint);
                }
            }
        });
    }

    private void updateDisplay(String message) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(message).append("\nCurrent List:\n");
        for(String s : sortedList.getList()) {
            stringBuilder.append(s).append("\n");
        }
        displayArea.setText(stringBuilder.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SwingGUI gui = new SwingGUI();
            gui.setVisible(true);
        });
    }
}
