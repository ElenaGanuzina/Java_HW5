import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, 
//что 1 человек может иметь несколько телефонов.

public class task1 {
    public static void main(String[] args) {
        
        Map<String,List<String>> phoneBook = createPhoneBook("Alex", "+7(812)123456");
        
        addNewEntry(phoneBook, "Middle", "+1(822)777333");
        addNewEntry(phoneBook, "Black", "+5(822)6753321");
        addNewEntry(phoneBook, "Smith", "+1(561)9475101");
        addNewEntry(phoneBook, "Black", "+5(822)6753333");
        addNewEntry(phoneBook, "Smith", "+1(561)9475101");
        System.out.println();
        printPhoneBook(phoneBook);
        System.out.println();

        deleteNumber(phoneBook, "+5(822)6753321");
        printPhoneBook(phoneBook);
        System.out.println();

        deleteBySurname(phoneBook, "Middle");
        printPhoneBook(phoneBook);
        System.out.println();

        findBySurname(phoneBook, "Smith");
        findBySurname(phoneBook, "Anna");
        findByPhoneNumber(phoneBook, "+5(822)6753333");
        //findByPhoneNumber(phoneBook, "Middle");

    }

    //Создание телефонной книги и внесение первой записи.
    public static Map<String,List<String>> createPhoneBook(String surname, String number){
        List<String> list = new ArrayList<>();
        Map<String,List<String>> phoneBook = new HashMap<>();
        list.add(number);
        phoneBook.put(surname, list);
        System.out.println("You've started a new phonebook and have added a new phone number: " + surname + " " + number);
        return phoneBook; 
    }        
    
    //Внесение записей в телефонную книгу.
    public static Map<String,List<String>> addNewEntry(Map<String,List<String>>phoneBook, String surname, String number){
        if (phoneBook.containsKey(surname)){
            List<String> list = (ArrayList<String>) phoneBook.get(surname);
            if(list.contains(number)){
                System.out.println("This phone number already exists: " + number);
            }else{
                list.add(number);
                phoneBook.put(surname, list);
                System.out.println("You've added a new phone number: " + surname + " " + number);    
            }
        }else{
            List<String> list = new ArrayList<>();
            list.add(number);
            phoneBook.put(surname, list);
            System.out.println("You've added a new entry: " + surname + " " + number);
        }
        
        return phoneBook;
    }
    
    //Вывод всей телефонной книги.
    public static void printPhoneBook(Map<String, List<String>> phoneBook){
        for (Map.Entry item : phoneBook.entrySet()){
            System.out.printf("%s: %s\n", item.getKey(), item.getValue());
        }
    }

    //Удаление номера телефона.
    public static Map<String,List<String>> deleteNumber(Map<String, List<String>> phoneBook, String number){
        for (Map.Entry item : phoneBook.entrySet()) {
            ArrayList<String> list =  (ArrayList<String>) item.getValue();
            for (String string : list) {
                if(string.equals(number)){
                    list.remove(number);
                    phoneBook.put((String) item.getKey(), list);
                    System.out.println("You've deleted " + number);                
                }else{
                    continue;
                }
            }
        }
        
        return phoneBook;
    }

    //Удаление записи по фамилии.
    public static Map<String,List<String>> deleteBySurname(Map<String, List<String>> phoneBook, String surname){
            if(phoneBook.containsKey(surname)){
                phoneBook.remove(surname);
            }
            else{
                System.out.println("There is no such entry.");
            }
        return phoneBook;
    }

    //Поиск по фамилии и вывод контакта.
    public static void findBySurname(Map<String, List<String>> phoneBook, String surname){
        ArrayList<String> lst = (ArrayList<String>) phoneBook.get(surname);
        if(phoneBook.containsKey(surname)){
            System.out.printf("%s: %s\n", surname, lst);
        }else{
            System.out.println("There is no such entry");
        }
    }
    
    //Поиск по номеру телефона и вывод контакта.
    public static void findByPhoneNumber(Map<String, List<String>> phoneBook, String number){
        for (Map.Entry item : phoneBook.entrySet()){
            ArrayList<String> list = (ArrayList<String>) item.getValue();
            for (String string : list) {
                if(string.equals(number)){
                    System.out.printf("%s: %s\n", item.getKey(), item.getValue());
                }else{
                    continue;
                }
            }
        }
    }
}


