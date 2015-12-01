package testes.recursividade;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Main {
	public static int fatorial(int num) {
		return num == 0 ? 1 : fatorial(num - 1) * num;
	}

	public static double pot(double a, double b) {
		return b == 0 ? 1 : pot(a, b - 1) * a;
	}

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		
		
		
		Class<?> mainClass = Main.class;
		Field[] campos = mainClass.getDeclaredFields();

		System.out.println("inicio for:");
		for (Field field : campos) {
			field.setAccessible(true);
			Object main = mainClass.getConstructor(new Class[] {}).newInstance();
			System.out.println(field.getName());
			field.set(main, "casa");
			System.out.println(field.get(main));
		}
		System.out.println("fim for.");

	}

	private String teste = "";

	public String getTeste() {
		return this.teste;
	}

}
