package t7.parte1;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		String comando;

		do {
			comando = entrada.next();
			
			if (comando.equals("c")) { // criaTremException
				String strTipo = entrada.next();
				int tipo = getTipoInt(strTipo);
				String msg = entrada.nextLine();
				
				try {
					TremException e = DisparadorExcecoes.criaTremException(msg, tipo);
					System.out.println("c - " + e.getMessage() + " - " + e.getTipo());
				} catch (RuntimeException re) {
					System.out.println("c runtime - " + re.getMessage());
				}
				
			} else if (comando.equals("d")) { // disparaTremException
				String strTipo = entrada.next();
				int tipo = getTipoInt(strTipo);
				String msg = entrada.nextLine();
				
				try {
					DisparadorExcecoes.disparaTremException(msg, tipo);
					System.out.println("d - sem excecao");
				} catch (RuntimeException re) {
					System.out.println("d runtime - " + re.getMessage());
				} catch (TremException e) {
					System.out.println("d trem - " + e.getMessage() + " - " + e.getTipo());
				}
			} else if (comando.equals("e")) { // chamaDisparaTremException
				String strTipo = entrada.next();
				int tipo = getTipoInt(strTipo);
				String msg = entrada.nextLine();
				
				Exception e = DisparadorExcecoes.chamaDisparaTremException(msg, tipo);
				
				if (e instanceof RuntimeException) {
					System.out.println("e - runtime - " + e.getMessage());
				} else if (e instanceof TremException) {
					TremException te = (TremException)e;
					System.out.println("e - trem - " + te.getMessage() + " - " + te.getTipo());
				}
			}
			
		} while (!comando.equals("s"));
	
		entrada.close();	
	}

	private static int getTipoInt(String tipo) {
		if (tipo.equals("COMP"))
			return TremException.COMPOSICAO_INVALIDA;
		if (tipo.equals("CARR"))
			return TremException.CARREGAMENTO_INVALIDO;
		if (tipo.equals("OUTR"))
			return 2;
		return -1;
	}

}
