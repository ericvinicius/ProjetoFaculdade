package utilities;

import javax.swing.JOptionPane;

public class Logger {

	private static final int TAMANHO_MAXIMO_DA_TAG_DE_LOG = 15;
	private static String tagError = "[ Error ]";
	private static String tagWarn = "[ Warn  ]";
	private static String tagDebug = "[ Debug ]";
	private static String tagInfo = "[ Info  ]";

	private static StringBuilder builder;

	public Logger() {
		resetaBuilder();
	}

	public static void logError(Exception e, String myMessage) {
		Throwable t = new Throwable();
		StackTraceElement[] trace = t.getStackTrace();

		// Ultima classe, metodo e linha acessado
		String className = trace[1].getClassName();
		String methodName = trace[1].getMethodName();
		int lineNumber = trace[1].getLineNumber();

		// Penultima classe, metodo e linha acessado
		String antClassName = trace[2].getClassName();
		String antMethodName = trace[2].getMethodName();
		int antLineNumber = trace[2].getLineNumber();

		builder.append("===============" + tagError + "===============\n");
		builder.append(arrumaEspacamentoDaTag("Local") + className + "." + methodName + "." + lineNumber + "\n");
		builder.append(arrumaEspacamentoDaTag("Local Ant.") + antClassName + "." + antMethodName + "." + antLineNumber + "\n");
		builder.append(arrumaEspacamentoDaTag("Message") + e.getMessage() + "\n");
		builder.append(arrumaEspacamentoDaTag("My Message") + myMessage + "\n");
		builder.append(arrumaEspacamentoDaTag("Stack Trace"));
		log();
		e.printStackTrace();
		builder.append("========================================");
		log();
		JOptionPane.showMessageDialog(null, "Erro na Aplicação", tagError, JOptionPane.ERROR_MESSAGE);
	}

	public static void logWarn(String tag, String myMessage) {
		builder.append(tagWarn);
		log(tag, myMessage);
	}

	public static void logDebug(String tag, String myMessage) {
		builder.append(tagDebug);
		log(tag, myMessage);
	}

	public static void logInfo(String tag, String myMessage) {
		builder.append(tagInfo);
		log(tag, myMessage);

	}

	private static void resetaBuilder() {
		builder = new StringBuilder();
	}

	private static void log(String tag, String message) {
		builder.append(arrumaEspacamentoDaTag(tag));
		builder.append(message);
		log();
	}

	private static void log() {
		System.out.println(builder.toString());
		resetaBuilder();
	}

	private static String arrumaEspacamentoDaTag(String tag) {
		String espaco = " ";
		tag = espaco + tag;
		while (tag.length() < TAMANHO_MAXIMO_DA_TAG_DE_LOG) {
			tag = tag + espaco;
		}
		if (tag.length() > TAMANHO_MAXIMO_DA_TAG_DE_LOG) {
			tag.trim();
			while (tag.length() > TAMANHO_MAXIMO_DA_TAG_DE_LOG) {
				tag = tag.substring(0, tag.length() - 1);
			}
		}
		tag = "[" + tag + "] ";
		return tag;
	}
}
