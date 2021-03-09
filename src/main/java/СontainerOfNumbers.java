/**
 * Класс контейнер для хранения произвольного количества целых чисел
 */
public class СontainerOfNumbers{

    /**
     * Исходный массив
     */
    private int[] array = new int[10];
    /**
     * Количество элементов в массиве
     */
    private int numbArrElem = 0;

    /**
     * Метод расширяет массив для дальнейшего бесконечного добавления элементов
     * @return - возвращает массив с теми же элементами, но с большим размером
     */
    private int[] createNewArr() {
        int[] newArray = new int[numbArrElem + 5];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }

    /**
     * Метод добавляет новый элемент в массив
     * @param newNumb - новый элемент
     */
    public void addNumb(int newNumb) {
        if (numbArrElem + 1 > array.length)
            array = createNewArr();
        array[numbArrElem] = newNumb;
        ++numbArrElem;
    }

    /**
     * Метод, который извлекает необходимый элемент из массива
     * @param index - индекс извлекаемого элемента
     * @return - возвращает необходимый элемент массива
     */
    public int extractNumb(int index) {
        validateIndex(index);
        return array[index];
    }

    /**
     * Метод, который удаляет желаемый элемент из массива
     * @param index - индекс удаляемого элемента
     */
    public void removeNumbInd(int index) {
        validateIndex(index);
        int[] newArray = new int[array.length];
        if (index == 0) {
            if (array.length - 1 >= 0) System.arraycopy(array, 1, newArray, 0, array.length - 1);
        } else if (index == array.length) {
            System.arraycopy(array, 0, newArray, 0, array.length - 1);
        } else if (index > 0 && index < array.length) {
            System.arraycopy(array, 0, newArray, 0, index);
            if (array.length - (index + 1) >= 0)
                System.arraycopy(array, index + 1, newArray, index + 1 - 1, array.length - (index + 1));
        }
        --numbArrElem;
        array = newArray;
    }

    /**
     * Метод нахождения числа и удаления его из массива
     * @param Numb - удаляемое нами чило
     */
    public void removeNumb(int Numb){
        for (int i = 0; i < array.length; i++)
            if (array[i] == Numb)
                removeNumbInd(i);
    }

    /**
     * Бросает исключение, если индекс i выходит за границы списка
     * @param index индекс, который необходимо проверить
     */
    private void validateIndex(int index){
        if (index < 0 || index >= array.length)
            throw new ArrayIndexOutOfBoundsException();
    }

    /**
     * @return размер массива
     */
    public int size() {
        return numbArrElem;
    }

}