package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static edu.hw4.Task.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NullTests {
    private static final Animal ANIMAL1 = new Animal("Барсик", Animal.Type.CAT,
        Animal.Sex.M, 13, 25, 3, true
    );
    private static final Animal ANIMAL2 = new Animal("Шарик", Animal.Type.DOG,
        Animal.Sex.M, 10, 53, 12, false
    );
    private static final Animal ANIMAL3 = new Animal("Шуля", Animal.Type.BIRD,
        Animal.Sex.M, 15, 34, 2, true
    );
    private static final Animal ANIMAL4 = new Animal("Рыбус", Animal.Type.FISH,
        Animal.Sex.M, 3, 4, 2, true
    );
    private static final Animal ANIMAL5 = new Animal("Чеддер", Animal.Type.SPIDER,
        Animal.Sex.M, 1, 8, 1, false
    );

    private static final List<Animal> ANIMALS_WITH_NULLS = Arrays.asList(
        ANIMAL1, null, ANIMAL2, ANIMAL3, null, ANIMAL4, ANIMAL5
    );
    private static final List<Animal> NULLS = Arrays.asList(
        null, null, null
    );

    // 1
    @Test
    @DisplayName("Сортировка животных по росту от маленького к большому")
    public void heightAscSortTest() {
        List<Animal> animalsSorted = List.of(
            ANIMAL4, ANIMAL5, ANIMAL1, ANIMAL3, ANIMAL2
        );

        assertThat(animalsSorted).isEqualTo(heightAscSort(ANIMALS_WITH_NULLS));

        assertThat(heightAscSort(NULLS)).isEmpty();

        assertNull(heightAscSort(null));
    }

    // 2
    @Test
    @DisplayName("Сортировка животных по весу от тяжёлого к лёгкому")
    public void weightDescSortTest() {
        List<Animal> animalsSorted = List.of(
            ANIMAL2, ANIMAL1, ANIMAL3, ANIMAL4, ANIMAL5
        );

        assertThat(animalsSorted).isEqualTo(weightDescSort(ANIMALS_WITH_NULLS, 7));

        assertThat(weightDescSort(NULLS, 3)).isEmpty();

        assertNull(weightDescSort(null, 7));

        assertNull(weightDescSort(ANIMALS_WITH_NULLS, -5));
    }

    // 3
    @Test
    @DisplayName("Количество животных каждого вида")
    public void countSpeciesTest() {
        Map<Animal.Type, Long> speciesCount = new HashMap<>();
        speciesCount.put(Animal.Type.DOG, 1L);
        speciesCount.put(Animal.Type.CAT, 1L);
        speciesCount.put(Animal.Type.FISH, 1L);
        speciesCount.put(Animal.Type.SPIDER, 1L);
        speciesCount.put(Animal.Type.BIRD, 1L);

        assertThat(speciesCount).isEqualTo(countSpecies(ANIMALS_WITH_NULLS));

        assertThat(countSpecies(NULLS)).isEmpty();

        assertNull(countSpecies(null));
    }

    // 4
    @Test
    @DisplayName("Животное с самым длинным именем")
    public void longestNameTest() {
        assertThat(ANIMAL1).isEqualTo(longestName(ANIMALS_WITH_NULLS));

        assertNull(longestName(NULLS));

        assertNull(longestName(null));
    }

    // 5
    @Test
    @DisplayName("Каких животных больше: самок или самцов")
    public void moreMaleFemaleTest() {
        assertThat(Animal.Sex.M).isEqualTo(moreMaleFemale(ANIMALS_WITH_NULLS));

        assertNull(moreMaleFemale(NULLS));

        assertNull(moreMaleFemale(null));
    }

    // 6
    @Test
    @DisplayName("Самое тяжёлое животное каждого вида")
    public void maxWeightEachSpecieTest() {
        Map<Animal.Type, Animal> heaviestAnimals = new HashMap<>();
        heaviestAnimals.put(Animal.Type.FISH, ANIMAL4);
        heaviestAnimals.put(Animal.Type.DOG, ANIMAL2);
        heaviestAnimals.put(Animal.Type.SPIDER, ANIMAL5);
        heaviestAnimals.put(Animal.Type.CAT, ANIMAL1);
        heaviestAnimals.put(Animal.Type.BIRD, ANIMAL3);

        assertThat(heaviestAnimals).isEqualTo(maxWeightEachSpecie(ANIMALS_WITH_NULLS));

        assertThat(maxWeightEachSpecie(NULLS)).isEmpty();

        assertNull(maxWeightEachSpecie(null));
    }

    // 7
    @Test
    @DisplayName("K-е самое старое животное")
    public void kOldAnimalTest() {
        assertThat(ANIMAL3).isEqualTo(kOldAnimal(ANIMALS_WITH_NULLS, 1));

        assertThat(ANIMAL4).isEqualTo(kOldAnimal(ANIMALS_WITH_NULLS, 4));

        assertNull(kOldAnimal(ANIMALS_WITH_NULLS, -1));

        assertNull(kOldAnimal(ANIMALS_WITH_NULLS, 150));

        assertNull(kOldAnimal(NULLS, 1));

        assertNull(kOldAnimal(null, 1));
    }

    // 8
    @Test
    @DisplayName("Самое тяжёлое животное среди животных ниже k см")
    public void heaviestAnimalTest() {
        assertThat(ANIMAL2).isEqualTo(heaviestAnimal(ANIMALS_WITH_NULLS, 100));

        assertThat(ANIMAL1).isEqualTo(heaviestAnimal(ANIMALS_WITH_NULLS, 50));

        assertNull(heaviestAnimal(ANIMALS_WITH_NULLS, -1));

        assertNull(heaviestAnimal(ANIMALS_WITH_NULLS, 0));

        assertNull(heaviestAnimal(NULLS, 100));

        assertNull(heaviestAnimal(null, 100));
    }

    // 9
    @Test
    @DisplayName("Общее количество лап")
    public void pawsCountTest() {
        assertEquals(pawsCount(ANIMALS_WITH_NULLS), 18);

        assertEquals(pawsCount(NULLS), 0);

        assertNull(pawsCount(null));
    }

    // 10
    @Test
    @DisplayName("Животные, возраст которых не совпадает с количеством лап")
    public void ageNotEqualsPawsTest() {
        List<Animal> expected = List.of(
            ANIMAL1, ANIMAL2, ANIMAL3, ANIMAL4, ANIMAL5
        );

        assertThat(expected).isEqualTo(ageNotEqualsPaws(ANIMALS_WITH_NULLS));

        assertThat(ageNotEqualsPaws(NULLS)).isEmpty();

        assertNull(ageNotEqualsPaws(null));
    }

    // 11
    @Test
    @DisplayName("Животные, которые могут укусить. Рост больше 100см")
    public void canBiteTest() {
        assertThat(Collections.EMPTY_LIST).isEqualTo(canBite(ANIMALS_WITH_NULLS));

        assertThat(Collections.EMPTY_LIST).isEqualTo(canBite(NULLS));

        assertNull(canBite(null));
    }

    // 12
    @Test
    @DisplayName("Количество животных, вес которых превышает рост")
    public void weightMoreHeightCountTest() {
        assertEquals(weightMoreHeightCount(ANIMALS_WITH_NULLS), 0);

        assertEquals(weightMoreHeightCount(NULLS), 0);

        assertNull(weightMoreHeightCount(null));
    }

    // 13
    @Test
    @DisplayName("Список животных, имена которых состоят более, чем из двух слов")
    public void twoWordsNameTest() {
        assertEquals(Collections.EMPTY_LIST, twoWordsNameAnimals(ANIMALS_WITH_NULLS));

        assertEquals(Collections.EMPTY_LIST, twoWordsNameAnimals(NULLS));

        assertNull(twoWordsNameAnimals(null));
    }

    // 14
    @Test
    @DisplayName("Есть ли в списке собака ростом более k см")
    public void isThereHighDogTest() {
        assertTrue(isThereHighDog(ANIMALS_WITH_NULLS, 40));

        assertFalse(isThereHighDog(ANIMALS_WITH_NULLS, 60));

        assertFalse(isThereHighDog(NULLS, 1));

        assertNull(isThereHighDog(null, 1));
    }

    // 15
    @Test
    @DisplayName("Суммарный вес животных каждого вида, возраст от k до l лет")
    public void totalWeightEverySpecieTest() {
        Map<Animal.Type, Integer> weights = new HashMap<>();
        weights.put(Animal.Type.DOG, 12);
        weights.put(Animal.Type.BIRD, 2);
        weights.put(Animal.Type.SPIDER, 1);
        weights.put(Animal.Type.CAT, 3);
        weights.put(Animal.Type.FISH, 2);

        assertEquals(totalWeightEverySpecie(ANIMALS_WITH_NULLS, 1, 100), weights);

        assertThat(totalWeightEverySpecie(NULLS, 0, 1)).isEmpty();

        assertNull(totalWeightEverySpecie(ANIMALS_WITH_NULLS, -1, 10));

        assertNull(totalWeightEverySpecie(ANIMALS_WITH_NULLS, 0, -1));

        assertNull(totalWeightEverySpecie(ANIMALS_WITH_NULLS, 6, 5));

        assertNull(totalWeightEverySpecie(null, 0, 1));
    }

    // 16
    @Test
    @DisplayName("Животные, отсортированные по виду, потому по полу, затем по имени")
    public void specieSexNameSortTest() {
        List<Animal> sortedAnimals = List.of(
            ANIMAL1, ANIMAL2, ANIMAL3, ANIMAL4, ANIMAL5
        );

        assertEquals(sortedAnimals, specieSexNameSort(ANIMALS_WITH_NULLS));

        assertThat(specieSexNameSort(NULLS)).isEmpty();

        assertNull(specieSexNameSort(null));
    }

    // 17
    @Test
    @DisplayName("Правда ли, что пауки кусаются чаще, чем собаки")
    public void spidersBiteMoreDogsTest() {
        assertFalse(spidersBiteMoreDogs(ANIMALS_WITH_NULLS));

        assertFalse(spidersBiteMoreDogs(NULLS));

        assertNull(spidersBiteMoreDogs(null));
    }

    // 18
    @Test
    @DisplayName("Самая тяжёлая рыбка")
    public void heaviestFishTest() {
        assertEquals(ANIMAL4, heaviestFish(List.of(
            List.of(ANIMAL1),
            List.of(ANIMAL2, ANIMAL5),
            List.of(ANIMAL4, ANIMAL3)
        )));

        assertNull(heaviestFish(List.of(
            NULLS,
            NULLS
        )));

        assertNull(heaviestFish(null));
    }

    // 19
    @Test
    @DisplayName("Животное с ошибками в записи")
    public void invalidRecordTest() {
        assertNull(invalidRecord(ANIMALS_WITH_NULLS));

        assertNull(invalidRecord(NULLS));

        assertNull(invalidRecord(null));
    }

    // 20
    @Test
    @DisplayName("Красивый вывод ")
    public void beautifulResultTest() {
        assertNull(beautifulResult(ANIMALS_WITH_NULLS));

        assertNull(beautifulResult(NULLS));

        assertNull(beautifulResult(null));
    }
}
