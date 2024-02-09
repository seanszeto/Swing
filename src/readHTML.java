import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.*;
import java.io.*;
import java.net.URL;
import java.util.Scanner;


    public class readHTML implements ActionListener {
        private JFrame mainFrame;
        private JLabel headerLabel;
        private JLabel statusLabel;
        private JPanel controlPanel;
        private JPanel leftPanel;
        private JPanel rightPanel;
        private JPanel topPanel;
        private JPanel bottomPanel;
        private JMenuBar mb;
        private JMenu file, edit, help;
        private JMenuItem cut, copy, paste, selectAll;
        private JTextArea searchBar;
        private JTextArea displayBar;

        private JTextArea term;

        private JScrollPane scroll;
        private JLabel resultsBar;
        private int WIDTH=800;
        private int HEIGHT=700;

        public readHTML(){
            prepareGUI();
        }

        public void readHTML() {
            try{
                System.out.println();
                URL url = new URL(searchBar.getText());
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(url.openStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    if(line.contains("www.")){
                        int start = line.indexOf("www.");
                        int end = line.indexOf("\"", start);
                        System.out.println(line.substring(start, end));
                        String term2 = line.substring(start, end);
                        if(term2.contains(term.getText())) {
                            displayBar.append(line.substring(start, end) + "\n");
                        }

//                        }else{
//                            displayBar.append(line.substring(start, end) + "\n");
//                        }
                    }
                }
                reader.close();
            }catch(Exception ex){
                System.out.println(ex);
            }
        }

        public static void main(String[] args) {
            readHTML readHTML = new readHTML();
        }



        private void prepareGUI() {
            mainFrame = new JFrame("Link searcher");
            mainFrame.setSize(WIDTH, HEIGHT);
            mainFrame.setLayout(new GridLayout(3, 1));

            controlPanel = new JPanel();
            controlPanel.setLayout(new BorderLayout());

            JPanel topPanel = new JPanel();
            topPanel.setLayout(new GridLayout(1, 2));
            JPanel rightPanel = new JPanel();
            JPanel leftPanel = new JPanel();
            JPanel bottomPanel = new JPanel();

            term = new JTextArea();
            term.setBounds(0, 5, 800, 10);

            JLabel termLabel = new JLabel("Search Term:");

            bottomPanel.add(termLabel);
            bottomPanel.add(term);



            // topPanel.add(URLLabel);
            //            topPanel.add(searchBar);


            searchBar = new JTextArea();
            searchBar.setBounds(0, 5, 800, 10);


//            mainFrame.add(searchBar);

//            controlPanel.setBounds(50, 50, -100, -100);

            displayBar = new JTextArea();
            displayBar.setEditable(false); // set textArea non-editable
            scroll = new JScrollPane(displayBar);
            scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//            displayBar.setBounds(50, 200, -50, -50);

            JButton enterButton = new JButton("Enter"){
                {
                    setSize(150, 5);
                    setMaximumSize(getSize());
                }
            };

            enterButton.setActionCommand("Enter");

            JLabel URLLabel = new JLabel("URL:");
            topPanel.add(URLLabel);
            topPanel.add(searchBar);

            enterButton.addActionListener(new ButtonClickListener());
            controlPanel.add(rightPanel, BorderLayout.CENTER);
            controlPanel.add(topPanel, BorderLayout.NORTH);
            controlPanel.add(bottomPanel, BorderLayout.SOUTH);



            rightPanel.add(enterButton);
//            controlPanel.add(rightPanel, BorderLayout.EAST);
//            controlPanel.add(leftPanel, BorderLayout.WEST);

            mainFrame.add(controlPanel);
            mainFrame.add(scroll);
            mainFrame.setVisible(true);

            mainFrame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent windowEvent) {
                    System.exit(0);
                }
            });
        }

        @Override
        public void actionPerformed(ActionEvent e) {
//            if (e.getSource() == cut)
//                searchBar.cut();
//            if (e.getSource() == paste)
//                searchBar.paste();
//            if (e.getSource() == copy)
//                searchBar.copy();
//            if (e.getSource() == selectAll)
//                searchBar.selectAll();
        }

        private class ButtonClickListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if (command.equals("Enter")) {
                    readHTML();
                }
            }
        }

    }
