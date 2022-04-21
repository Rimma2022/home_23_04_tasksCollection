import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
       // 0 Напишите Java-программу для итерации объекта типа HashMap с использованием цикла while и улучшенного цикла for.
        Map <String, String> emloyee = new HashMap<>();
        emloyee.put("Клименкова", "экономист");
        emloyee.put("Ромская", "бухгалтер");
        emloyee.put("Степанова", "специалист");
        emloyee.put("Сугак", "менеджер");
        emloyee.put("Таргоня", "охранник");
        forMy(emloyee);
        whileMy (emloyee);
        /**
         * 1 Создайте HashMap, содержащий пары значений  - имя игрушки и объект игрушки (класс Product).
         *  Перебрать и распечатать пары значений - entrySet().
         * Перебрать и распечатать набор из имен продуктов  - keySet().
         * Перебрать и распечатать значения продуктов - values().
         * Для каждого перебора создать свой метод.
         */
        Product p1 = new Product(2002, "кукла");
        Product p2 = new Product(2005, "лото");
        Product p3 = new Product(2010, "домино");
        Product p4 = new Product(2012, "кубики");
        Product p5 = new Product(2015, "кукла");
        Product p6 = new Product(2020, "юла");
        Product p7 = new Product(2022, "конструктор");
        Product p8 = new Product(2004, "мягкая игрушка");
        HashMap<String, Product> toys = new HashMap<> ();

        toys.put("Маша", p1);
        toys.put("10 в одном", p2);
        toys.put("Зверята", p3);
        toys.put("Томмик", p4);
        toys.put("Даша", p5);
        toys.put("Юла", p6);
        toys.put("Стройка", p7);
        toys.put("Мишка", p8);

        print1(toys);
        print2(toys);
        print3(toys);
//        System.out.println(toys);
//        System.out.println(toys.keySet());
//        System.out.println(toys.values());

        /**
         * 2 Добавить студентов в коллекцию. Создать класс Student, содержащий следующие характеристики – имя, группа, курс, оценки по предметам. Создать коллекцию, содержащую объекты класса Student.
         * Написать метод, который удаляет студентов со средним баллом <3.
         * Если средний балл>=3, студент переводится на следующий курс.
         * Напишите метод printStudents(List<Student> students, int course), который получает список студентов и номер курса.
         * Напечатат на консоль имена тех студентов из списка, которые обучаются на данном курсе.
         */

        Map <String, Integer> marks1 = new HashMap<>();
        marks1.put("История", 2);
        marks1.put("Философия", 4);
        marks1.put("Высшая математика", 2);
        marks1.put("Теоретическая механика", 3);
        marks1.put("Экономика", 2);

        Map <String, Integer> marks2 = new HashMap<>();
        marks2.put("История", 5);
        marks2.put("Философия", 1);
        marks2.put("Высшая математика", 2);
        marks2.put("Теоретическая механика", 4);
        marks2.put("Экономика", 6);

        Map <String, Integer> marks3 = new HashMap<>();
        marks3.put("История", 8);
        marks3.put("Философия", 5);
        marks3.put("Высшая математика",10);
        marks3.put("Теоретическая механика", 4);
        marks3.put("Экономика", 9);

        Map <String, Integer> marks4 = new HashMap<>();
        marks4.put("История", 9);
        marks4.put("Философия", 10);
        marks4.put("Высшая математика",4);
        marks4.put("Теоретическая механика", 4);
        marks4.put("Экономика", 6);

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Иванов", "MA - 102", 2, marks1));
        studentList.add(new Student("Петров", "MA - 101", 1, marks2));
        studentList.add(new Student("Сидоров", "MA - 102", 2, marks3));
        studentList.add(new Student("Ермакова", "MA - 101", 1, marks4));

        removeStudent(studentList);
        transfer(studentList);
        printStudents(studentList, 2);
    }
    
    public static void forMy(Map<String, String> employee) {
        for (Map.Entry<String, String> e : employee.entrySet()) {
            System.out.println(e);
        }

    }

    public static void whileMy (Map<String, String> employee) {
        Iterator<Map.Entry<String, String>> e1 = employee.entrySet().iterator();
        while (e1.hasNext()) {
            Map.Entry<String, String> e2 = e1.next();
            System.out.println("Name: " + e2.getKey() + " Position: " + e2.getValue());
        }
    }

    public static void print1(HashMap<String, Product> toys) {
        for (Map.Entry<String, Product> t : toys.entrySet()) {
            System.out.println("Touys: " + t);
        }
    }

    public static void print2(HashMap<String, Product> toys) {
        for (Map.Entry<String, Product> t : toys.entrySet()) {
            System.out.println(t.getKey());
        }

    }

    public static void print3(HashMap<String, Product> toys) {
        for (Map.Entry<String, Product> t : toys.entrySet()) {
            System.out.println(t.getValue());
        }

    }
    public static void removeStudent (List<Student> list) {
        // 1 способ
//        List <Student> listnew = list.stream().filter(x -> x.getAvg() >= 3).collect(Collectors.toList());
//        System.out.println(listnew);
        // 2 способ
        list.removeIf(x -> x.getAvg() < 3);
        System.out.println(list);
    }

    public static void transfer (List<Student> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAvg() >= 3) {
               int cours = list.get(i).getCourse()+1;
               list.set(i, new Student(list.get(i).getName(), list.get(i).getGroup(), cours, list.get(i).getMarks()));
            }
        }
        System.out.println(list);
    }

    public static void printStudents (List<Student> list, int cours) {
        System.out.println("На " + cours + " курсе учатся: ");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCourse() == cours){
                System.out.println(list.get(i).getName());
            }
        }
    }


}
