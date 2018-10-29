package Q3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class Trees {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame    F    =    new    JFrame();
                F.setTitle("Swing JTree");
                F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JPanel    P    =    new    JPanel(new BorderLayout());

                DefaultMutableTreeNode    root    =    new    DefaultMutableTreeNode("Root");

                DefaultMutableTreeNode    fruit    =    new    DefaultMutableTreeNode("Fruits");
                root.add(fruit);

                fruit.add(new    DefaultMutableTreeNode("Oranges"));
                fruit.add(new    DefaultMutableTreeNode("Bananas"));
                fruit.add(new    DefaultMutableTreeNode("Apples"));

                DefaultMutableTreeNode    vegetables    =    new    DefaultMutableTreeNode("Vegetables");
                root.add(vegetables);

                vegetables.add(new    DefaultMutableTreeNode("Carrot"));
                vegetables.add(new    DefaultMutableTreeNode("Tomato"));
                vegetables.add(new    DefaultMutableTreeNode("Salad"));



                JTree    T    =    new    JTree(root);
                JLabel    L    =    new JLabel("-");
                L.setHorizontalAlignment(JLabel.CENTER);
                P.add(T, BorderLayout.WEST);
                P.add(L, BorderLayout.CENTER);

                T.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(T.getSelectionPath() != null){
                            L.setText(T.getSelectionPath().toString());
                        }

                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });

                // ADD LISTENER TO DISPLAY THE PATH ON PANEL

                F.getContentPane().add(P);

                JPanel    Panel2    =    new    JPanel(new GridLayout(1,2));
                final JTextField    A    =    new    JTextField();
                JButton        B    =    new    JButton("add as child");
                B.addActionListener(new ActionListener()
                {

                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        // ADD CODE HERE
                        DefaultMutableTreeNode new_tree = new DefaultMutableTreeNode(A.getText());
                        if(T.getLastSelectedPathComponent() == fruit){
                            //System.out.print("Root was last selected.");
                            fruit.add(new_tree);

                        }else if(T.getLastSelectedPathComponent() == vegetables){
                            vegetables.add(new_tree);
                        }
                        A.setText("");

                        // NEEDED FOR REFRESH
                        DefaultTreeModel model = (DefaultTreeModel) T.getModel();
                        model.reload();

                        T.repaint();
                    }
                });


                Panel2.add(A);
                Panel2.add(B);
                F.getContentPane().add(Panel2,BorderLayout.SOUTH);


                F.setSize(400,400);
                F.setVisible(true);
            }
        });
    }
}
