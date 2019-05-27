package exMayo2019ManuelArizaSerrano.ejercicio2;

/**
 * 2.- Escribe un programa que usando la interfaz gráfica de Java permita al usuario introducir una fecha en
 * formato dd/mm/aaaa y que tenga los siguientes botones:
 * • Validar fecha: muestra un mensaje diciendo si la fecha es o no válida.
 * • Día posterior: Modifica la fecha sumándole un día. Debe validar la fecha antes de hacer la
 * operación.
 * • Día anterior: Modifica la fecha restándole un día. Debe validar la fecha antes de hacer la
 * operación.
 * • Días hasta hoy: Muestra el número de días que hay entre la fecha introducida y la fecha de hoy.
 * Debe validar la fecha antes de hacer la operación.
 * • Terminar.
 * La fecha debe ser manejada mediante un objeto de una clase que o bien construyáis con sus métodos
 * correspondientes o de las que ya existen en la API de Java.
 * 
 * @author MANUEL ARIZA SERRANO
 * 
 * 
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio2 extends JFrame {

  private JPanel contentPane;
  private JTextField fechaIntroducida;
  private JTextField diaPosterior;
  private JTextField diaAnterior;
  private JTextField diasHastaHoy;
  final static int[] DIAS_MES = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
  private JTextField fechaValida;
  private JButton salir;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Ejercicio2 frame = new Ejercicio2();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  public static boolean esFechaValida(String f) {
    // comprobar que es un formato dd/mm/aaaa
    if (f.length() != 10 || !Character.isDigit(f.charAt(0)) || !Character.isDigit(f.charAt(1))
        || !Character.isDigit(f.charAt(3)) || !Character.isDigit(f.charAt(4)) || !Character.isDigit(f.charAt(6))
        || !Character.isDigit(f.charAt(7)) || !Character.isDigit(f.charAt(8)) || !Character.isDigit(f.charAt(9))
        || f.charAt(2) != '/' || f.charAt(5) != '/') {
      return false;
    }
    // comprobar si mes es correcto
    int mes = Integer.parseInt(f.substring(3, 5));
    if (mes < 1 || mes > 12) {
      return false;
    }
    // comprobar si día es correcto
    int dia = Integer.parseInt(f.substring(0, 2));
    int anyo = Integer.parseInt(f.substring(6));
    int diasmes = DIAS_MES[mes - 1]; // restamos 1 al mes para que esté entre 0 y 11
    // ¿febrero y año bisisesto?
    if (mes == 2 && anyo % 4 == 0 && (anyo % 100 != 0 || anyo % 400 == 0)) {
      diasmes++;
    }
    return (dia > 0 && dia <= diasmes);
  }

  /**
   * Create the frame.
   */
  public Ejercicio2() {

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 622, 403);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JLabel lblFechaIntroducida = new JLabel("FECHA INTRODUCIDA(DD/MM/AAAA)");
    lblFechaIntroducida.setBounds(41, 27, 224, 31);
    contentPane.add(lblFechaIntroducida);

    fechaIntroducida = new JTextField();
    fechaIntroducida.setBounds(277, 31, 167, 22);
    contentPane.add(fechaIntroducida);
    fechaIntroducida.setColumns(10);

    JButton validarFecha = new JButton("VALIDAR FECHA");
    validarFecha.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (esFechaValida(fechaIntroducida.getText())) {
          fechaValida.setText("La fecha es válida");
        } else if (!esFechaValida(fechaIntroducida.getText())) {
          fechaValida.setText("La fecha no es válida");
        }
      }
    });
    validarFecha.setBounds(41, 95, 142, 25);
    contentPane.add(validarFecha);

    JButton btnDiaPosterior = new JButton("DIA POSTERIOR");
    btnDiaPosterior.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Fecha f = new Fecha(Integer.parseInt(fechaIntroducida.getText().substring(0, 2)),
            Integer.parseInt(fechaIntroducida.getText().substring(3, 5)),
            Integer.parseInt(fechaIntroducida.getText().substring(6)));
        f.suma1DiaFecha();
        diaPosterior.setText(f.toString());
      }
    });
    btnDiaPosterior.setBounds(41, 155, 142, 25);
    contentPane.add(btnDiaPosterior);

    JButton btnDiaAnterior = new JButton("DIA ANTERIOR");
    btnDiaAnterior.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Fecha f = new Fecha(Integer.parseInt(fechaIntroducida.getText().substring(0, 2)),
            Integer.parseInt(fechaIntroducida.getText().substring(3, 5)),
            Integer.parseInt(fechaIntroducida.getText().substring(6)));
        f.resta1DiaFecha();
        diaAnterior.setText(f.toString());
      }
    });
    btnDiaAnterior.setBounds(41, 215, 142, 25);
    contentPane.add(btnDiaAnterior);

    JButton btnDiasHastaHoy = new JButton("DIAS HASTA HOY");
    btnDiasHastaHoy.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Fecha f = new Fecha(Integer.parseInt(fechaIntroducida.getText().substring(0, 2)),
            Integer.parseInt(fechaIntroducida.getText().substring(3, 5)),
            Integer.parseInt(fechaIntroducida.getText().substring(6)));

        diasHastaHoy.setText(Integer.toString(f.diasHastaFechaDeHoy()));
      }

    });
    btnDiasHastaHoy.setBounds(41, 275, 142, 25);
    contentPane.add(btnDiasHastaHoy);

    diaPosterior = new JTextField();
    diaPosterior.setColumns(10);
    diaPosterior.setBounds(277, 156, 167, 22);
    contentPane.add(diaPosterior);

    diaAnterior = new JTextField();
    diaAnterior.setColumns(10);
    diaAnterior.setBounds(277, 216, 167, 22);
    contentPane.add(diaAnterior);

    diasHastaHoy = new JTextField();
    diasHastaHoy.setColumns(10);
    diasHastaHoy.setBounds(277, 276, 167, 22);
    contentPane.add(diasHastaHoy);

    fechaValida = new JTextField();
    fechaValida.setColumns(10);
    fechaValida.setBounds(277, 96, 167, 22);
    contentPane.add(fechaValida);

    salir = new JButton("SALIR");
    salir.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });
    salir.setBounds(231, 318, 97, 25);
    contentPane.add(salir);
  }
}
