import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*Пусть дан список сотрудников:
Иван Иванов
Светлана Петрова
Кристина Белова
Анна Мусина
Анна Крутова
Иван Юрин
Петр Лыков
Павел Чернов
Петр Чернышов
Мария Федорова
Марина Светлова
Мария Савина
Мария Рыкова
Марина Лугова
Анна Владимирова
Иван Мечников
Петр Петин
Иван Ежов

Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. 
Отсортировать по убыванию популярности
*/
public class task2 {
    public static void main(String[] args) {
        String[] names = {"Иван Иванов", "Светлана Петрова", "Кристина Белова", 
                            "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков",
                            "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Марина Светлова", 
                            "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова", 
                            "Иван Мечников", "Петр Петин", "Иван Ежов"};
        System.out.println(Arrays.toString(names));
        Map<String, String> collegues = createMap(names);
        sortedNames(collegues);
        
    }

    // Получаем Map, где ключ - фамилия, значение - имя.
    public static HashMap<String, String> createMap(String[] names){
        Map<String, String> collegues = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            String[] temp = names[i].split(" ");
            collegues.put(temp[1], temp[0]);
        }
        System.out.println(collegues.entrySet());
        return (HashMap<String, String>) collegues;
    }

    //Получаем Map, где ключ - имя, значение - количество повторений имени в списке. 
    //Сортируем по убыванию и выводим получившийся результат.
    public static  void sortedNames (Map<String, String> collegues){
        Map<String, Integer> repeatedNames = new HashMap<>();
        for (var item  : collegues.entrySet()) {
            int count = 0;
            String temp = String.valueOf(item.getValue());
            
            for (var i : collegues.entrySet()) {
                if (i.getValue().equals(temp)){
                    count++;
                }
            }
            repeatedNames.put(temp, count); 
        }
        repeatedNames.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
        .forEach(System.out::println);
    }
    
}
