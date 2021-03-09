/**
 * Класс контейнер для хранения произвольного количества целых чисел
 */

public class СontainerOfNumbers {
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
        for (int i = 0; i < array.length; i++)
            newArray[i] = array[i];
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
     * @return - возвращает массив с уже удаленным элементом и в следствии смещением элементов спереди (по необходимости)
     */
    public int[] removeNumbInd(int index) {
        validateIndex(index);
        int[] newArray = new int[array.length];
        if (index == 0) {
            for (int i = 0; i < array.length - 1; i++)
                newArray[i] = array[i + 1];
        } else if (index == array.length) {
            for (int i = 0; i < array.length - 1; i++)
                newArray[i] = array[i];
        } else if (index > 0 && index < array.length) {
            for (int i = 0; i < index; i++)
                newArray[i] = array[i];
            for (int i = index + 1; i < array.length; i++)
                newArray[i-1] = array[i];
        }
        --numbArrElem;
        array = newArray;
        return array;
    }

    /**
     * Метод нахождения числа и удаления его из массива
     * @param Numb - удаляемое нами чило
     * @return - возвращает массив с уже удаленным(-и) элементом(-ами)
     */
    public int[] removeNumb(int Numb){
        for (int i = 0; i < array.length; i++)
            if (array[i] == Numb)
                removeNumbInd(i);
        return array;
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