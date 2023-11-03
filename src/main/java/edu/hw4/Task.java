package edu.hw4;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import static edu.hw4.ValidationError.beautifulCheck;
import static edu.hw4.ValidationError.checkAnimal;

@SuppressWarnings("MagicNumber")
public class Task {
    private Task() {
    }

    // 1. Сортировка животных по росту от маленького к большому
    public static List<Animal> heightAscSort(List<Animal> animals) {
        return animals.stream().sorted((o1, o2) -> {
            if (o1.height() > o2.height()) {
                return 1;
            } else if (o1.height() < o2.height()) {
                return -1;
            }
            return 0;
        }).collect(Collectors.toList());
    }

    // 2. Сортировка животных по весу от тяжёлого к лёгкому
    public static List<Animal> weightDescSort(List<Animal> animals, int k) {
        if (k < 0) {
            return null;
        }

        return animals.stream().sorted((o1, o2) -> {
            if (o1.weight() < o1.weight()) {
                return 1;
            } else if (o1.weight() > o2.weight()) {
                return -1;
            }
            return 0;
        }).limit(k).collect(Collectors.toList());
    }

    // 3. Количество животных каждого вида
    public static Map<Animal.Type, Long> countSpecies(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.counting()));
    }

    // 4. Животное с самым длинным именем
    public static Animal longestName(List<Animal> animals) {
        return animals.stream().max(Comparator.comparing(o -> o.name().length()))
            .orElse(null);
    }

    // 5. Каких животных больше: самок или самцов
    public static Animal.Sex moreMaleFemale(List<Animal> animals) {
        Map<Animal.Sex, Long> sexCount = animals.stream()
            .collect(Collectors.groupingBy(Animal::sex, Collectors.counting()));

        return Collections.max(sexCount.entrySet(), Comparator.comparingLong(Map.Entry::getValue))
            .getKey();
    }

    // 6. Самое тяжёлое животное каждого вида
    public static Map<Animal.Type, Animal> maxWeightEachSpecie(List<Animal> animals) {
        Map<Animal.Type, List<Animal>> animalsBySpecies =
            animals.stream().collect(Collectors.groupingBy(Animal::type));

        Map<Animal.Type, Animal> answer = new HashMap<>();
        for (Map.Entry<Animal.Type, List<Animal>> entry : animalsBySpecies.entrySet()) {
            Animal animal = entry.getValue().stream().max((o1, o2) -> {
                if (o1.weight() > o2.weight()) {
                    return 1;
                } else if (o1.weight() < o2.weight()) {
                    return -1;
                }
                return 0;
            }).orElse(null);

            answer.put(animal.type(), animal);
        }

        return answer;
    }

    // 7. K-е самое старое животное
    public static Animal kOldAnimal(List<Animal> animals, int k) {
        if (k - 1 < 0 || k - 1 >= animals.size()) {
            return null;
        }

        return animals.stream().sorted((o1, o2) -> {
            if (o1.age() < o2.age()) {
                return 1;
            } else if (o1.age() > o2.age()) {
                return -1;
            }
            return 0;
        }).toList().get(k - 1);
    }

    // 8. Самое тяжёлое животное среди животных ниже k см
    public static Animal heaviestAnimal(List<Animal> animals, int k) {
        if (k <= 0) {
            return null;
        }

        return animals.stream().filter(animal -> animal.height() < k)
            .max((Comparator.comparing(Animal::weight))).orElse(null);
    }

    // 9. Общее количество лап
    public static Integer pawsCount(List<Animal> animals) {
        return animals.stream().mapToInt(Animal::paws).sum();
    }

    // 10. Животные, возраст которых не совпадает с количеством лап
    public static List<Animal> ageNotEqualsPaws(List<Animal> animals) {
        return animals.stream().filter(animal -> animal.age() != animal.paws()).toList();
    }

    // 11. Животные, которые могут укусить. Рост больше 100см
    public static List<Animal> canBite(List<Animal> animals) {
        return animals.stream().filter(animal -> animal.bites() && animal.height() > 100).toList();
    }

    // 12. Количество животных, вес которых превышает рост
    public static Long weightMoreHeightCount(List<Animal> animals) {
        return animals.stream().filter(animal -> animal.weight() > animal.height()).count();
    }

    // 13. Список животных, имена которых состоят более, чем из двух слов
    public static List<Animal> twoWordsNameAnimals(List<Animal> animals) {
        return animals.stream().filter(animal -> animal.name().split(" ").length > 2).toList();
    }

    // 14. Есть ли в списке собака ростом более k см
    public static Boolean isThereHighDog(List<Animal> animals, int k) {
        if (k <= 0) {
            return false;
        }

        return animals.stream().filter(animal -> animal.type() == Animal.Type.DOG)
            .anyMatch(animal -> animal.height() > k);
    }

    // 15. Суммарный вес животных каждого вида, возраст от k до l лет
    public static Map<Animal.Type, Integer> totalWeightEverySpecie(List<Animal> animals, int k, int l) {
        if (k < 0 || l < 0 || k > l) {
            return null;
        }

        return animals.stream().filter(animal -> animal.age() >= k && animal.age() <= l)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }

    // 16. Животные, отсортированные по виду, потому по полу, затем по имени
    public static List<Animal> specieSexNameSort(List<Animal> animals) {
        return animals.stream().sorted(Comparator.comparing(Animal::type)
            .thenComparing(Animal::sex).thenComparing(Animal::name)).toList();
    }

    // 17. Правда ли, что пауки кусаются чаще, чем собаки
    public static Boolean spidersBiteMoreDogs(List<Animal> animals) {
        Map<Animal.Type, List<Animal>> animalsBySpecies = animals.stream()
            .filter(animal -> animal.bites() && (animal.type() == Animal.Type.DOG
                || animal.type() == Animal.Type.SPIDER))
            .collect(Collectors.groupingBy(Animal::type));

        if (!animalsBySpecies.containsKey(Animal.Type.DOG)
            || !animalsBySpecies.containsKey(Animal.Type.SPIDER)) {
            return false;
        }

        return Collections.max(
                animalsBySpecies.entrySet(),
                Comparator.comparingInt(e -> e.getValue().size())
            ).getKey()
            .equals(Animal.Type.SPIDER);
    }

    // 18. Самая тяжёлая рыбка
    public static Animal heaviestFish(List<List<Animal>> animalsLists) {
        return animalsLists.stream()
            .flatMap(Collection::stream).toList().stream()
            .filter(animal -> animal.type().equals(Animal.Type.FISH))
            .max(Comparator.comparing(Animal::weight)).orElse(null);
    }

    // 19. Животные с ошибками в записи
    public static Map<String, Set<ValidationError>> invalidRecord(List<Animal> animals) {
        Animal animal = animals.stream().filter(a -> !checkAnimal(a).isEmpty())
            .findFirst().orElse(null);

        if (animal == null) {
            return null;
        }

        Map<String, Set<ValidationError>> result = new HashMap<>();
        result.put(animal.name(), checkAnimal(animal));

        return result;
    }

    // 20. Читабельный отчёт об ошибках
    public static Map<String, String> beautifulResult(List<Animal> animals) {
        Animal animal = animals.stream().filter(a -> !checkAnimal(a).isEmpty())
            .findFirst().orElse(null);

        if (animal == null) {
            return null;
        }

        return beautifulCheck(animal);
    }

}
