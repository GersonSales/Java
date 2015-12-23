package testes.aspecto;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.aspectj.lang.reflect.ConstructorSignature;
import org.aspectj.lang.reflect.MethodSignature;

public aspect Aspecto {

	pointcut construtor() : call(*.new(..)) && !within(Aspecto);

	before() : construtor() {
		Object[] argumentos = thisJoinPoint.getArgs();
		ConstructorSignature constructorSignature = (ConstructorSignature) thisJoinPoint.getSignature();
		Constructor<?> constructor = constructorSignature.getConstructor();
		Annotation[][] annotations = constructor.getParameterAnnotations();
		for (int i = 0; i < annotations.length; i++) {
			Annotation[] annotation = annotations[i];
			for (int j = 0; j < annotation.length; j++) {
				if (annotation[j] instanceof NaoNulo) {
					if (argumentos[i] == null) {
						throw new IllegalArgumentException("Nao pode ser nulo!");
					}
				} else if (annotation[j] instanceof NaoNegativo) {
					if ((Integer) argumentos[i] < 0) {
						throw new IllegalArgumentException("Nao pode ser negativo!");

					}
				}
			}
		}

	}

	pointcut required() : execution(* *.*(..));

	before(): required() {
		Object[] argumentos = thisJoinPoint.getArgs();

		MethodSignature methodSignature = (MethodSignature) thisJoinPoint.getSignature();
		Method method = methodSignature.getMethod();
		Annotation[][] annotations = method.getParameterAnnotations();
		for (int i = 0; i < annotations.length; i++) {
			Annotation[] annotation = annotations[i];
			for (int j = 0; j < annotation.length; j++) {
				if (annotation[j] instanceof NaoNulo) {
					if (argumentos[i] == null) {
						throw new IllegalArgumentException("Nao pode ser nulo!");

					}
				} else if (annotation[j] instanceof NaoNegativo) {
					if ((Integer) argumentos[i] < 0) {
						throw new IllegalArgumentException("Nao pode ser negativo!");

					}
				}

			}
		}

	}

}
