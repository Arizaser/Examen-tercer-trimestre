package exMayo2019ManuelArizaSerrano.ejercicio2;

/**
 * 
 * @author MANUEL ARIZA SERRANO
 *
 */

public class Fecha {
  int d;
  int m;
  int a;

  final static int[] DIAS_MES = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

  /**
   * @param d
   * @param m
   * @param a
   */
  public Fecha(int d, int m, int a) {
    super();
    setD(d);
    setM(m);
    setA(a);
  }

  public int getD() {
    return d;
  }

  private void setD(int d) {
    String dia = Integer.toString(d).trim();
    if (dia.length() < 2) {
      dia = "0" + dia;
    }
    this.d = Integer.parseInt(dia);
  }

  public int getM() {
    return m;
  }

  private void setM(int m) {
    String mes = Integer.toString(m).trim();
    if (mes.length() < 2) {
      mes = "0" + mes;
    }
    this.m = Integer.parseInt(mes);
  }

  public int getA() {
    return a;
  }

  private void setA(int a) {
    String anyo = Integer.toString(a).trim();
    if (anyo.length() < 2) {
      anyo = "0" + anyo;
    }
    this.a = Integer.parseInt(anyo);
  }

  public void suma1DiaFecha() {
    int diasmes = DIAS_MES[m - 1];
    // ¿febrero y año bisisesto?
    if (m == 2 && a % 4 == 0 && (a % 100 != 0 || a % 400 == 0)) {
      diasmes++;
    }
    d++;
    if (d > diasmes) {
      d = 1;
      m++;
      if (m == 13) {
        m = 1;
        a++;
      }
    }
  }

  public void resta1DiaFecha() {
    d--;
    if (d==0) { // mes anterior
      m--;
      if (m==0) { // año anterior
        m=12;
        a--;
      } 
      d = DIAS_MES[m-1];
      // ¿febrero y año bisisesto?
      if (m==2 && a%4==0 && (a%100!=0 || a%400==0)) {
        d++;
      }
    }
  }
  public int diasHastaFechaDeHoy() {
    int cont = 0;
  
    while (true) {
      suma1DiaFecha();
      cont++;
      if (getD()==24 && getM()==05 && getA()==2019) {
        break;
      }
    }
    return cont;
  }

  @Override
  public String toString() {
    return d + "/" + m + "/" + a;
  }

}
