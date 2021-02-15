public class СontainerOfNumbers {
    /**
     * Исходный массив
     */
    private int[] array = new int[10];
    /**
     * Количество элементов в массиве
     */
    private int NumbArrElem = 0;

    /**
     * Метод расширяет массив для дальнейшего бесконечного добавления элементов
     *
     * @return - возвращает массив с теми же элементами, но с большим размером
     */
    private int[] CreateNewArr() {
        int[] newArray = new int[NumbArrElem + 5];
        for (int i = 0; i < newArray.length; i++)
            newArray[i] = array[i];
        return newArray;
    }

    /**
     * Метод добавляет новый элемент в массив
     *
     * @param newNumb - новый элемент
     */
    public void AddNumb(int newNumb) {
        if (NumbArrElem + 1 > array.length)
            array = CreateNewArr();
        array[NumbArrElem] = newNumb;
        ++NumbArrElem;
    }

    /**
     * Метод, который извлекает необходимый элемент из массива
     *
     * @param index - индекс извлекаемого элемента
     * @return - возвращает необходимый элемент массива
     */
    public int ExtractNumb(int index) {
        return array[index];
    }

    /**
     * Метод, который удаляет желаемый элемент из массива
     *
     * @param index - индекс удаляемого элемента
     * @return - возвращает массив с уже удаленным элементом и в следствии смещением элементов спереди (по необходимости)
     */
    public int[] RemoveNumb(int index) {
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
                newArray[i] = array[i];
        }
        return newArray;
    }
}