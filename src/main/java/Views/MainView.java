package Views;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MainView extends JFrame {

    private JTextField txt_Uno;
    private JTextField txt_Dos;

    public MainView() {
        super();
        Inicializar();
        // Datos de la ventana
        setSize(400, 200);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void Inicializar() {

        // Inicialisacion de componenetes
        txt_Uno = new JTextField();
        txt_Uno.setSize(200, 20);
        txt_Uno.setLocation(20, 20);
        // txt_Uno.setBackground(Color.BLUE);
        // txt_Uno.setForeground(Color.WHITE);
        txt_Uno.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txt_Uno.getDocument().addDocumentListener(DocListener(txt_Uno));

        txt_Dos = new JTextField();
        txt_Dos.setSize(200, 20);
        txt_Dos.setLocation(20, 60);
        // txt_Dos.setBackground(Color.BLUE);
        // txt_Dos.setForeground(Color.WHITE);
        txt_Dos.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txt_Dos.getDocument().addDocumentListener(DocListener(txt_Dos));

        // Agregar controles al contenedor
        add(txt_Uno);
        add(txt_Dos);
    }

    public DocumentListener DocListener(JTextField txt) {
        return new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                warn(txt);
            }

            public void removeUpdate(DocumentEvent e) {
                warn(txt);
            }

            public void insertUpdate(DocumentEvent e) {
                warn(txt);
            }

        };
    }

    public void warn(JTextField txt) {
        txt.setBorder(BorderFactory.createLineBorder(txt.getText().isEmpty() ? Color.RED : Color.BLACK));
    }

}
