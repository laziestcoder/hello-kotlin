package generic;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author TOWFIQUL ISLAM
 * @email towfiq.106@gmail.com
 * @since 3/14/22 2:06 PM
 */

public class MainApplication {

    @Test
    public void givenArrayOfIntegers_thanListOfStringReturnedOK() {
        Integer[] intArray = {1, 2, 3, 4, 5};
        List<String> stringList = CustomGenerics.fromArrayToList(intArray, Object::toString);

        assertThat(stringList, hasItems("1", "2", "3", "4", "5"));
    }

    @Test
    public void givenArrayOfIntegers_thanListOfStringReturned_OK() {
        Integer[] intArray = {1, 2, 3, 4, 5};
        List<Integer> stringList = CustomGenerics.fromArrayToList(intArray);

        assertThat(stringList, hasItems(1, 2, 3, 4, 5));
    }

}

class CustomGenerics {

    /*
     * Generic Methods
     */

    /**
     * Transform Array of Integer to List of Integer
     *
     * @param a
     * @param mapperFunction
     * @param <T>
     * @param <G>
     * @return List
     */
    public static <T, G> List<G> fromArrayToList(T[] a, Function<T, G> mapperFunction) {
        return Arrays.stream(a)
                .map(mapperFunction)
                .collect(Collectors.toList());
    }

    /**
     * Transform Array of Integer to List of Integer
     *
     * @param a
     * @param <T>
     * @return List
     */
    public static <T> List<T> fromArrayToList(T[] a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }

    /*
     * Bounded Generics
     */

    /**
     * @param <T>
     * @param a
     * @return
     */
    public <T extends Number> List<T> fromArrayToListBound(T[] a) {
        return Arrays.stream(a)
                .collect(Collectors.toList());
    }

    /*
     * Multiple Bounds
     */

    /**
     * TODO:: NEED TO STUDY MORE
     *
     * @param a
     * @param <T>
     * @return
     */
    public <T extends Number & Comparable> List<T> fromArrayToListMultipleBound(T[] a) {
        return Arrays.stream(a)
                .collect(Collectors.toList());
    }


    /*
     * Using Wildcards With Generics
     */

    /**
     * @param buildings
     */
    public void paintAllBuildingsOne(List<Building> buildings) {
        buildings.forEach(Building::paint);
    }

    /**
     * This is called an upper-bounded wildcard
     * there is an important note to consider. We know that Object is the supertype of all Java classes.
     * However, a collection of Object is not the supertype of any collection.
     * <p>
     * For example, a List<Object> is not the supertype of List<String>, and assigning a variable of type
     * List<Object> to a variable of type List<String> will cause a compiler error. This is to prevent possible
     * conflicts that can happen if we add heterogeneous types to the same collection.
     * <p>
     * The same rule applies to any collection of a type and its subtypes.
     *
     * @param buildings
     */
    public void paintAllBuildingsTwo(List<? extends Building> buildings) {
        buildings.forEach(Building::paint);
    }

    /**
     * This is called a lower-bounded wildcard
     * We can also specify wildcards with a lower bound, where the unknown type has to be a supertype of the
     * specified type. Lower bounds can be specified using the super keyword followed by the specific type.
     * For example, <? super T> means unknown type that is a superclass of T (= T and all its parents).
     *
     * @param houseList
     */
    public void paintAllBuildingsThree(List<? super House> houseList) {
        houseList.forEach(house -> {
            MiniHouse miniHouse = (MiniHouse) house;
            miniHouse.paintThree();
        });
    }


    /*
     * Type Erasure
     */

    /**
     * @param list
     * @param <T>
     * @return
     */
    public <T> List<T> genericMethod(List<T> list) {
        return list.stream().collect(Collectors.toList());
    }

    /**
     * for illustration
     * @param list
     * @return
     */
    public List<Object> withErasureOne(List<Object> list) {
        return list.stream().collect(Collectors.toList());
    }

    /**
     * which in practice results in ** THIS IS NOT WORKING CODE **
     * @param list
     * @return
     */

    /*

    public List withErasureTwo(List list) {
        return list.stream().collect(Collectors.toList());
    }

    */


    /**
     * @param t
     * @param <T>
     */
    public <T extends Building> void genericMethodOne(T t) {
        t.paint();
    }

    /**
     * @param t
     */
    public void genericMethodTwo(Building t) {
        t.paint();
    }

}

class Building {
    public void paint() {
        System.out.println("Painting...");
    }
}

class House extends Building {
    public void paintTwo() {
        System.out.println("Painting...");
    }
}

class MiniHouse extends House {
    public void paintThree() {
        System.out.println("Painting...");
    }

}