import java.io.*;

public class ReadFile {
   // String fileName;


    public Matrix read(String fileName) {
        File file = new File(fileName);
        int lineNumber = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
            }
        } catch (IOException e){

        }
            Matrix matrix = new Matrix(lineNumber);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String matrixLine;
            int lineCounter = 0;
            while ((matrixLine = reader.readLine()) != null) {

               char[] charArray =  matrixLine.toCharArray();

                for (int i = 0; i <charArray.length ; i++) {
                    int c = Character.getNumericValue(charArray[i]);
                  //  System.out.println("текущйи символ "+ c + " в строке " + lineCounter);
                    matrix.getImarix()[lineCounter][i] = c;

                }
                lineCounter++;

            }

        } catch (IOException e) {
            e.printStackTrace();

        }
        return matrix;
    }
}
