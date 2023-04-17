
public class homework {

    public static void main(String[] args) throws MyArrayDataException {
        homework main = new homework();
        String[][] matrix = {
                { "1", "2", "3", "4" },
                { "1", "2", "3", "4" },
                { "1", "2", "3", "4" },
                { "1", "2", "я", "4" }
        };

        try {
            main.stringExceptionTest(matrix);
            main.sumOfMatrix(matrix);

        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }
    }

    public void stringExceptionTest(String[][] arr) throws MyArraySizeException {
        if (arr.length != 4)
            throw new MyArraySizeException("Неверное количество строк");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4)
                throw new MyArraySizeException(String.format("Неверное количество столбцов в %d-й" +
                        " строке", i));
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public void sumOfMatrix(String[][] matrix) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                try {
                    sum += Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.println(sum);
    }
}

class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }

}

class MyArrayDataException extends NumberFormatException {
    MyArrayDataException(int row, int col) {
        super(String.format("неверное значение: %d строка, %d столбец", row, col));
    }
}
