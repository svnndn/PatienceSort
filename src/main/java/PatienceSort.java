import java.util.*;

public class PatienceSort {
    public List<Integer> arr;
    public static int iterations;
    public static long time;

    public PatienceSort(List<Integer> arr) {
        this.arr = arr;
        this.iterations = 0;
        this.time = 0;
    }

    public int getIterations() {
        return iterations;
    }

    public static long getTime() {
        return time;
    }

    // Функция для слияния стопок в отсортированном порядке
    public static List<Integer> mergePiles(List<List<Integer>> v) {

        List<Integer> ans = new ArrayList<Integer>();

        // За каждую итерацию находим минимальный элемент с вершин стопок
        // Удаляем его из piles и добавляем в ans
        while (true) {
            iterations++;

            // минимальный элемент
            int min_el = Integer.MAX_VALUE;

            // индекс минимального элемента
            int index = -1;

            // вычисляем минимальный элемент вершины каждой стопки
            for (int i = 0; i < v.size(); i++) {
                // если min_el больше, чем последний элемент стопки
                if (!v.get(i).isEmpty() && min_el > v.get(i).get(v.get(i).size() - 1)) {
                    min_el = v.get(i).get(v.get(i).size() - 1);
                    index = i;
                }
            }

            if (index == -1) {
                break;
            }

            ans.add(min_el);
            v.get(index).remove(v.get(index).size() - 1);

            // Если текущая стопка пустая, удаляем ее

            if (v.get(index).isEmpty()) {
                v.remove(index);
            }
        }

        return ans;
    }

    // Функция для сортировки исходного list с patience sort
    public static List<Integer> patienceSorting(List<Integer> arr) {

        long start = System.nanoTime();
        List<List<Integer>> piles = new ArrayList<List<Integer>>();

        for (int i = 0; i < arr.size(); i++) {
            iterations++;
            // Если нет стопок

            if (piles.isEmpty()) {
                // Создаем новую стопку

                List<Integer> temp = new ArrayList<Integer>();
                temp.add(arr.get(i));
                piles.add(temp);
            }
            else {
                // Проверка: верхний элемент каждой стопки больше или равен текущему эл-ту или нет
                int flag = 1;

                for (int j = 0; j < piles.size(); j++) {
                    iterations++;

                    // Проверка: добавляемый элемент меньше (или равен), чем верхний элемент стопки
                    if (arr.get(i) <= piles.get(j).get(piles.get(j).size() - 1)) {
                        piles.get(j).add(arr.get(i));
                        flag = 0;
                        break;
                    }
                }

                if (flag == 1) {
                    List<Integer> temp = new ArrayList<Integer>();
                    // Элементу не нашлось места в существующих стопках, создаем новую стопку
                    temp.add(arr.get(i));

                    // Добавляем текущую стопку ко всем стопкам
                    piles.add(temp);
                }
            }
        }

        // Объединяем стопки в отсортированный ans
        List<Integer> ans = mergePiles(piles);

        long end = System.nanoTime();
        time = end - start;

        return ans;
    }
}