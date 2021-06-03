package ps2.utils;

import static javax.swing.JOptionPane.*;

public class DialogoGui {
    
	public static void mostrar(String msg) {
		showMessageDialog(null, msg);
	}
	
    public static int lerInteiro(String msg) {
        int n = -1;
        boolean inteiro = false;
        while (!inteiro) {
            try {
                n = Integer.parseInt(showInputDialog(msg));
                inteiro = true;
            } catch(NumberFormatException ex) {
                mostrar("O valor deve ser um n�mero inteiro!");
            }
        }
        return n;
    }

    public static double lerDouble(String msg) {
        double n = 0;
        boolean valido = false;
        while (!valido) {
            try {
                n = Double.parseDouble(showInputDialog(msg));
                valido = true;
            } catch(NumberFormatException ex) {
                mostrar("O valor deve ser um n�mero: ");
            }
        }
        return n;
    }
    
    public static int menu(String ... opcoes) {
        int n = -1;
        boolean valido = false;
        while (!valido) {
            int cont = 1;
            String msg = "\nOP��ES DISPON�VEIS:\n";
            for (String opcao: opcoes) {
                msg += "(" + cont + ") " + opcao + "\n";
                cont++;
            }
            msg += "\nSelecione uma op��o: ";
            n = lerInteiro(msg);
            if (n >= 1 && n < cont) {
                valido = true;
            }
            else {
                mostrar("Op��o inv�lida!");
            }
        }
        return n;
    }
    
    public static String lerString(String msg) {
        String nome = showInputDialog(msg);
        return nome;
    }

    public static long lerInteiroLongo(String msg) {
        long n = -1;
        boolean longo = false;
        while (!longo) {
            try {
                n = Long.parseLong(showInputDialog(msg));
                longo = true;
            } catch(NumberFormatException ex) {
                mostrar("O valor deve ser um n�mero inteiro long!");
            }
        }
        return n;
    }
}