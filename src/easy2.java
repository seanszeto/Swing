import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class easy2 implements ActionListener {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JMenuBar mb;
    private JMenu file, edit, help;
    private JMenuItem cut, copy, paste, selectAll;
    private int WIDTH=800;
    private int HEIGHT=700;


    public easy2() {
        prepareGUI();
    }

    public static void main(String[] args) {
        easy2 easy2 = new easy2();
        easy2.showEventDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java  Examples");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new GridLayout(3, 1));


        cut = new JMenuItem("cut");
        copy = new JMenuItem("copy");
        paste = new JMenuItem("paste");
        selectAll = new JMenuItem("selectAll");
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);

        mb = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        mb.add(file);
        mb.add(edit);
        mb.add(help);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        mainFrame.setVisible(true);
    }

    private void showEventDemo() {
        headerLabel.setText("Control in action: Button");

        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");

        button1.setActionCommand("1");
        button2.setActionCommand("2");
        button3.setActionCommand("3");
        button3.setActionCommand("4");
        button3.setActionCommand("5");


        button1.addActionListener(new easy2.ButtonClickListener());
        button2.addActionListener(new easy2.ButtonClickListener());
        button3.addActionListener(new easy2.ButtonClickListener());
        button4.addActionListener(new easy2.ButtonClickListener());
        button5.addActionListener(new easy2.ButtonClickListener());



        controlPanel.add(button1, BorderLayout.NORTH);
        controlPanel.add(button2, BorderLayout.WEST);
        controlPanel.add(button3, BorderLayout.CENTER);
        controlPanel.add(button4, BorderLayout.EAST);
        controlPanel.add(button5, BorderLayout.SOUTH);

        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == cut)
//            ta.cut();
//        if (e.getSource() == paste)
//            ta.paste();
//        if (e.getSource() == copy)
//            ta.copy();
//        if (e.getSource() == selectAll)
//            ta.selectAll();
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("1")) {
                statusLabel.setText("Ok Button clicked.");
            } else if (command.equals("2")) {
                statusLabel.setText("Submit Button clicked.");
            } else {
                statusLabel.setText("Cancel Button clicked.");
            }
        }
    }

}
