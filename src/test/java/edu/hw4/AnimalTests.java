package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

public class AnimalTests {
    private static final Animal ANIMAL1 = new Animal("Барсик", Animal.Type.CAT,
        Animal.Sex.M, 13, 25, 3, true
    );
    private static final Animal ANIMAL2 = new Animal("Мурка", Animal.Type.CAT,
        Animal.Sex.F, 3, 24, 2, true
    );
    private static final Animal ANIMAL3 = new Animal("Мистер Бист", Animal.Type.CAT,
        Animal.Sex.F, 7, 28, 3, false
    );
    private static final Animal ANIMAL4 = new Animal("Шарик", Animal.Type.DOG,
        Animal.Sex.M, 10, 53, 12, false
    );
    private static final Animal ANIMAL5 = new Animal("Разрушитель галактик",
        Animal.Type.DOG, Animal.Sex.M, 10, 50, 12, false
    );
    private static final Animal ANIMAL6 = new Animal("Принцесса", Animal.Type.DOG,
        Animal.Sex.F, 10, 35, 12, true
    );
    private static final Animal ANIMAL7 = new Animal("Шуля", Animal.Type.BIRD,
        Animal.Sex.M, 15, 34, 2, true
    );
    private static final Animal ANIMAL8 = new Animal("Рыбус", Animal.Type.FISH,
        Animal.Sex.M, 3, 4, 2, true
    );
    private static final Animal ANIMAL9 = new Animal("Акар", Animal.Type.FISH,
        Animal.Sex.M, 12, 5, 1, true
    );
    private static final Animal ANIMAL10 = new Animal("Руми", Animal.Type.FISH,
        Animal.Sex.F, 2, 1, 1, true
    );
    private static final Animal ANIMAL11 = new Animal("Отто", Animal.Type.SPIDER,
        Animal.Sex.M, 4, 5, 1, true
    );
    private static final Animal ANIMAL12 = new Animal("Шелоб", Animal.Type.SPIDER,
        Animal.Sex.F, 10381, 303, 3134, true
    );
    private static final Animal ANIMAL13 = new Animal("Чеддер", Animal.Type.SPIDER,
        Animal.Sex.M, 1, 8, 1, false
    );

    private static final List<Animal> ANIMALS = Arrays.asList(
        ANIMAL1, ANIMAL2, ANIMAL3, ANIMAL4, ANIMAL5, ANIMAL6, ANIMAL7,
        ANIMAL8, ANIMAL9, ANIMAL10, ANIMAL11, ANIMAL12, ANIMAL13
    );

    // 1
    @Test
    @DisplayName("Сортировка животных по росту от маленького к большому")
    public void heightAscSortTest() {
        List<Animal> animalsSorted = Arrays.asList(
            ANIMAL10, ANIMAL8, ANIMAL9, ANIMAL11, ANIMAL13, ANIMAL2, ANIMAL1,
            ANIMAL3, ANIMAL7, ANIMAL6, ANIMAL5, ANIMAL4, ANIMAL12
        );

        assertThat(animalsSorted).isEqualTo(heightAscSort(ANIMALS));
    }

    // 2
    @Test
    @DisplayName("Сортировка животных по весу от тяжёлого к лёгкому")
    public void weightDescSortTest() {
        List<Animal> animalsSorted = Arrays.asList(
            ANIMAL12, ANIMAL4, ANIMAL5, ANIMAL6, ANIMAL1
        );

        assertThat(animalsSorted).isEqualTo(weightDescSort(ANIMALS, 5));
    }

    // 3
    @Test
    @DisplayName("Количество животных каждого вида")
    public void countSpeciesTest() {
        Map<Animal.Type, Long> speciesCount = new HashMap<>();
        speciesCount.put(Animal.Type.DOG, 3L);
        speciesCount.put(Animal.Type.CAT, 3L);
        speciesCount.put(Animal.Type.FISH, 3L);
        speciesCount.put(Animal.Type.SPIDER, 3L);
        speciesCount.put(Animal.Type.BIRD, 1L);

        assertThat(speciesCount).isEqualTo(countSpecies(ANIMALS));
    }

    // 4
    @Test
    @DisplayName("Животное с самым длинным именем")
    public void longestNameTest() {
        assertThat(ANIMAL5).isEqualTo(longestName(ANIMALS));
    }

    // 5
    @Test
    @DisplayName("Каких животных больше: самок или самцов")
    public void moreMaleFemaleTest() {
        assertThat(Animal.Sex.M).isEqualTo(moreMaleFemale(ANIMALS));
    }

    // 6
    @Test
    @DisplayName("Самое тяжёлое животное каждого вида")
    public void maxWeightEachSpecieTest() {
        Map<Animal.Type, Animal> heaviestAnimals = new HashMap<>();
        heaviestAnimals.put(Animal.Type.FISH, ANIMAL8);
        heaviestAnimals.put(Animal.Type.DOG, ANIMAL4);
        heaviestAnimals.put(Animal.Type.SPIDER, ANIMAL12);
        heaviestAnimals.put(Animal.Type.CAT, ANIMAL1);
        heaviestAnimals.put(Animal.Type.BIRD, ANIMAL7);

        assertThat(heaviestAnimals).isEqualTo(maxWeightEachSpecie(ANIMALS));
    }

    // 7
    @Test
    @DisplayName("K-е самое старое животное")
    public void kOldAnimalTest() {
        assertThat(ANIMAL12).isEqualTo(kOldAnimal(ANIMALS, 1));

        assertThat(ANIMAL9).isEqualTo(kOldAnimal(ANIMALS, 4));

        assertThat(ANIMAL6).isEqualTo(kOldAnimal(ANIMALS, 7));
    }

    // 8
    @Test
    @DisplayName("Самое тяжёлое животное среди животных ниже k см")
    public void heaviestAnimalTest() {
        assertThat(ANIMAL4).isEqualTo(heaviestAnimal(ANIMALS, 100));

        assertThat(ANIMAL8).isEqualTo(heaviestAnimal(ANIMALS, 10));

        assertThat(ANIMAL12).isEqualTo(heaviestAnimal(ANIMALS, 500));
    }

    // 9
    @Test
    @DisplayName("Общее количество лап")
    public void pawsCountTest() {
        assertEquals(pawsCount(ANIMALS), 50);
    }

    // 10
    @Test
    @DisplayName("Животные, возраст которых не совпадает с количеством лап")
    public void ageNotEqualsPawsTest() {
        assertThat(ANIMALS).isEqualTo(ageNotEqualsPaws(ANIMALS));
    }

    // 11
    @Test
    @DisplayName("Животные, которые могут укусить. Рост больше 100см")
    public void canBiteTest() {
        assertThat(List.of(ANIMAL12)).isEqualTo(canBite(ANIMALS));
    }

    // 12
    @Test
    @DisplayName("Количество животных, вес которых превышает рост")
    public void weightMoreHeightCountTest() {
        assertEquals(weightMoreHeightCount(ANIMALS), 1);
    }

    // 13
    @Test
    @DisplayName("Список животных, имена которых состоят более, чем из двух слов")
    public void twoWordsNameTest() {
        assertEquals(Collections.EMPTY_LIST, twoWordsNameAnimals(ANIMALS));
    }

    // 14
    @Test
    @DisplayName("Есть ли в списке собака ростом более k см")
    public void isThereHighDogTest() {
        assertTrue(isThereHighDog(ANIMALS, 10));
        assertFalse(isThereHighDog(ANIMALS, 100));

        assertFalse(isThereHighDog(ANIMALS, 0));
        assertFalse(isThereHighDog(ANIMALS, -1));
    }

    // 15
    @Test
    @DisplayName("Суммарный вес животных каждого вида, возраст от k до l лет")
    public void totalWeightEverySpecieTest() {
        Map<Animal.Type, Integer> weights = new HashMap<>();
        weights.put(Animal.Type.DOG, 36);
        weights.put(Animal.Type.BIRD, 2);
        weights.put(Animal.Type.SPIDER, 3136);
        weights.put(Animal.Type.CAT, 8);
        weights.put(Animal.Type.FISH, 4);

        assertEquals(totalWeightEverySpecie(ANIMALS, 1, 100000), weights);

        weights.clear();
        weights.put(Animal.Type.SPIDER, 2);
        weights.put(Animal.Type.CAT, 5);
        weights.put(Animal.Type.FISH, 3);
        weights.put(Animal.Type.DOG, 36);

        assertEquals(totalWeightEverySpecie(ANIMALS, 0, 10), weights);

        weights.clear();
        assertEquals(totalWeightEverySpecie(ANIMALS, 99999, 100000), weights);
    }

    // 16
    @Test
    @DisplayName("Животные, отсортированные по виду, потому по полу, затем по имени")
    public void specieSexNameSortTest() {
        List<Animal> sortedAnimals = List.of(
            ANIMAL1, ANIMAL3, ANIMAL2, ANIMAL5, ANIMAL4, ANIMAL6, ANIMAL7,
            ANIMAL9, ANIMAL8, ANIMAL10, ANIMAL11, ANIMAL13, ANIMAL12
        );

        assertEquals(sortedAnimals, specieSexNameSort(ANIMALS));
    }

    // 17
    @Test
    @DisplayName("Правда ли, что пауки кусаются чаще, чем собаки")
    public void spidersBiteMoreDogsTest() {
        assertTrue(spidersBiteMoreDogs(ANIMALS));

        assertFalse(spidersBiteMoreDogs(List.of(ANIMAL11)));

        assertFalse(spidersBiteMoreDogs(List.of(ANIMAL5)));

        assertFalse(spidersBiteMoreDogs(List.of(ANIMAL1)));
    }

    // 18
    @Test
    @DisplayName("Самая тяжёлая рыбка")
    public void heaviestFishTest() {
        assertEquals(ANIMAL8, heaviestFish(List.of(
            List.of(ANIMAL1, ANIMAL8, ANIMAL2, ANIMAL4),
            List.of(ANIMAL9, ANIMAL3, ANIMAL5),
            List.of(ANIMAL6, ANIMAL7, ANIMAL11),
            List.of(ANIMAL12, ANIMAL13, ANIMAL10)
        )));
    }

    // 19
    @Test
    @DisplayName("Животное с ошибками в записи")
    public void invalidRecordTest() {
        Map<String, Set<ValidationError>> expectedResult = new HashMap<>();
        expectedResult.put("", Set.of(ValidationError.EMPTY_NAME));
        assertEquals(expectedResult, invalidRecord(List.of(new Animal(
            "", Animal.Type.DOG, Animal.Sex.F, 1, 1, 1, true
        ))));

        expectedResult.clear();
        expectedResult.put("12@", Set.of(ValidationError.INVALID_NAME));
        assertEquals(expectedResult, invalidRecord(List.of(new Animal(
            "12@", Animal.Type.DOG, Animal.Sex.M, 2, 2, 2, false
        ))));

        expectedResult.clear();
        expectedResult.put(null, Set.of(ValidationError.NULL_NAME,
            ValidationError.NULL_TYPE, ValidationError.NULL_SEX,
            ValidationError.NEGATIVE_AGE, ValidationError.NEGATIVE_WEIGHT,
            ValidationError.ZERO_HEIGHT
        ));
        assertEquals(expectedResult, invalidRecord(List.of(new Animal(
            null, null, null, -1, 0, -1, false
        ))));

        assertNull(invalidRecord(ANIMALS));
    }

    // 20
    @Test
    @DisplayName("Красивый вывод ")
    public void beautifulResultTest() {
        Map<String, String> expectedResult = new HashMap<>();
        expectedResult.put("", "Пустое имя, Отрицательный возраст");
        assertEquals(expectedResult, beautifulResult(List.of(new Animal(
            "", Animal.Type.SPIDER, Animal.Sex.F, -1, 1, 1, true
        ))));

        expectedResult.clear();
        expectedResult.put(null, "Нулевой рост, Имя не указано, Отрицательный вес, "
            + "Отрицательный возраст, Пол животного не указан, Тип животного не указан");
        assertEquals(expectedResult, beautifulResult(List.of(new Animal(
            null, null, null, -1, 0, -1, false
        ))));

        assertNull(beautifulResult(ANIMALS));
    }
}
