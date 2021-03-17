package reflect;

import java.lang.reflect.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;

public class Homework1 {

    /**
     * Prints the declared methods of java.lang.String sorted by name.
     */
    public void streamPipeline1() {
        Arrays.stream(String.class.getDeclaredMethods())
                .sorted(Comparator.comparing(Method::getName))
                .forEach(System.out::println);
    }

    /**
     *  Prints all distinct names of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline2() {
        Arrays.stream(String.class.getDeclaredMethods())
                .map(Method::getName)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String with two or more parameters whose parameters are all of the same type, sorted by name.
     */
    public void streamPipeline3() {
        Arrays.stream(String.class.getDeclaredMethods())
                .filter(m->m.getParameterCount() > 1 && Arrays.stream(m.getParameterTypes()).distinct().count() == 1 )
                .sorted(Comparator.comparing(Method::getName))
                .forEach(System.out::println);
    }

    /**
     * Prints all distinct return types of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline4() {
        Arrays.stream(String.class.getDeclaredMethods())
                .map(Method::getReturnType)
                .distinct()
                .sorted(Comparator.comparing(Class::getName))
                .forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String with at least one boolean parameter, sorted by name.
     */
    public void streamPipeline5() {
        Arrays.stream(String.class.getDeclaredMethods())
                .filter(m-> m.getParameterTypes().length > 0 && Arrays.stream(m.getParameterTypes()).anyMatch(t->t.equals(boolean.class)))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String whose parameters are all of type int, sorted by name.
     */
    public void streamPipeline6() {
        Arrays.stream(String.class.getDeclaredMethods())
                .filter(m-> m.getParameterTypes().length > 0 && Arrays.stream(m.getParameterTypes()).allMatch(t-> t.equals(int.class)))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(System.out::println);
    }

    /**
     * Returns the longest name of the declared methods of java.lang.String.
     */
    public String streamPipeline7() {
        return Arrays.stream(String.class.getDeclaredMethods())
                .max(Comparator.comparingInt(m->m.getName().length()))
                .map(Method::getName)
                .orElse("");
    }

    /**
     *  Returns the longest one from the names of the public declared methods of java.lang.String.
     */
    public String streamPipeline8() {
        return Arrays.stream(String.class.getMethods())
                .max(Comparator.comparingInt(m->m.getName().length()))
                .map(Method::getName)
                .orElse("");
    }

    /**
     * Returns summary statistics about the number of parameters for the declared methods of java.lang.String.
     */
    public IntSummaryStatistics streamPipeline9() {
        return Arrays.stream(String.class.getDeclaredMethods())
                .mapToInt(m->m.getParameterTypes().length)
                .summaryStatistics();
    }

    /**
     * Returns the maximum number of parameters accepted by the declared methods of java.lang.String.
     */
    public int streamPipeline10() {
        return Arrays.stream(String.class.getDeclaredMethods())
                .mapToInt(m->m.getParameterTypes().length)
                .max()
                .orElse(0);
    }

    /**
     * Returns the declared method of java.lang.String with the most number of parameters.
     */
    public Method streamPipeline11() {
        return Arrays.stream(String.class.getDeclaredMethods())
                .max(Comparator.comparing(m->m.getParameterTypes().length))
                .get();
    }

    /**
     * Prints all distinct parameter types of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline12() {
        Arrays.stream(String.class.getDeclaredMethods())
                .flatMap(m-> Arrays.stream(m.getParameterTypes().clone()))
                .distinct()
                .sorted(Comparator.comparing(Class::getName))
                .forEach(System.out::println);
    }

}
