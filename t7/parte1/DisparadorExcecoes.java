package t7.parte1;
public class DisparadorExcecoes {
	
	public static TremException criaTremException(String msg, int tipo)  {
			TremException exception = new TremException(msg, tipo);
			return exception;
	}
	public static void disparaTremException(String msg, int tipo) throws TremException {
		throw criaTremException(msg, tipo);
	}
	
	public static Exception chamaDisparaTremException(String msg, int tipo) {
		try {
			disparaTremException(msg, tipo);
		} catch (RuntimeException r) {
			return r;
		} catch (TremException t) {
			return t;
		}
		return null;
	}
}
