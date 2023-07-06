package java_homework.seminar6;

//Урок 6. Хранение и обработка данных ч3: множество коллекций Set
//        Разработать программу, имитирующую поведение коллекции HashSet. В программе содать метод add добавляющий
//        элемент, метод toString возвращающий строку с элементами множества и метод позволяющий читать элементы по индексу.
//        Формат данных Integer.


public class Main {
    private Integer[] elements = new Integer[10];

    public void add(Integer element) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                elements[i] = element;
                break;
            }
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                result.append(elements[i]).append(",");
            }
        }

        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }

        return "{" + result.toString() + "}";
    }

    public Integer get(int index) {
        if (index >= 0 && index < elements.length) {
            return elements[index];
        }
        return null;
    }

}
