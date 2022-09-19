public class Matrix {
   private int size;
   private int [][] imarix ;

    public Matrix(int size) {
        this.size = size;
        imarix = new int[size][size];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[][] getImarix() {
        return imarix;
    }

    public void setImarix(int[][] imarix) {
        this.imarix = imarix;
    }
}
