package exMayo2019ManuelArizaSerrano.ejercicio1;

/**
 * 1. Escribe un programa que usando la interfaz gráfica de Java escoja un fichero del sistema de archivos y
 * lo almacene en otro de manera que se sustituyan todas las ocurrencias de los siguientes caracteres
 * (mayúscula o minúscula) del fichero original por sus correspondientes números:
 * A 4
 * B 8
 * E 3
 * I 1
 * O 0
 * S 5
 * T 7
 * Componentes gráficos:
 * • Etiquetas.
 * • Fichero origen y destino.
 * • Botón para ejecutar la acción.
 * • Caja de texto con el contenido del fichero destino no editable.
 * 
 * @author MANUEL ARIZA SERRANO
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class Ejercicio1 extends JFrame {

  private JPanel contentPane;
  File fichero;
  File ficheroOrigen;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Ejercicio1 frame = new Ejercicio1();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public Ejercicio1() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 628, 388);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JTextArea textoResultado = new JTextArea();
    textoResultado.setBounds(38, 123, 526, 205);
    contentPane.add(textoResultado);

    JScrollPane scrollPane = new JScrollPane(textoResultado, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrollPane.setBounds(38, 123, 526, 205);
    contentPane.add(scrollPane);

    JLabel lblFicheroOrigen1 = new JLabel("FICHERO ORIGEN");
    lblFicheroOrigen1.setBounds(38, 13, 142, 25);
    contentPane.add(lblFicheroOrigen1);

    JButton btnNewButton_1 = new JButton("FICHERO");
    btnNewButton_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(contentPane);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
          fichero = fileChooser.getSelectedFile();

        }
      }
    });
    btnNewButton_1.setBounds(192, 13, 97, 25);
    contentPane.add(btnNewButton_1);

    JLabel lblFicheroDestino_1 = new JLabel("FICHERO DESTINO");
    lblFicheroDestino_1.setBounds(38, 58, 142, 25);
    contentPane.add(lblFicheroDestino_1);

    JButton btnDestino = new JButton("DESTINO");
    btnDestino.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(contentPane);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
          ficheroOrigen = fileChooser.getSelectedFile();

        }
      }
    });
    btnDestino.setBounds(192, 58, 97, 25);
    contentPane.add(btnDestino);

    JButton btnNewButton = new JButton("OK");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        try {
          BufferedReader br1 = new BufferedReader(new FileReader(fichero));
          BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroOrigen));
          BufferedReader br2 = new BufferedReader(new FileReader(ficheroOrigen));

          String linea1 = "";
          while (linea1 != null) {
              bw.write(linea1.toUpperCase().replace('A', '4').replace('B', '8').replace('E', '3').replace('I', '1')
                  .replace('O', '0').replace('S', '5').replace('T', '7') + "\n");
            linea1 = br1.readLine();
          }
          bw.close();
          br1.close();
          String contenidoFichero = "";
          linea1 = "";
          while (linea1 != null) {
            linea1 = br2.readLine();
            if (linea1 != null) {
              contenidoFichero += linea1 + "\n";
            }
          }
          textoResultado.append(contenidoFichero);
          br2.close();
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "ERROR");
        }
      }
    });
    btnNewButton.setBounds(442, 34, 122, 56);
    contentPane.add(btnNewButton);

  }
}
