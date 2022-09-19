import java.util.*;
import java.util.stream.Collectors;

public class Decompose {

    public List<Integer> start(List list, int index){
        if(!list.contains(index)){
            list.add(index);
        }
        return list;
    }

    public List<Integer> findR(int index, int [][] matrix,List<Integer> list, Set<Integer> set ){
        start(list,index);
       // list.add(index);
        Set<Integer> needToChecked = new HashSet<>();
        if (index==1){
            needToChecked.add(1);
        } else {
            needToChecked.add(index);
        }
        for (int i = index-1; i < matrix.length; i++) {
            if (set.contains(i + 1) || !needToChecked.contains(i+1)) {
                continue;
            }
          //  System.out.println("Текущая строка R " + i);
                for (int j = 0; j < matrix.length; j++) {
                    //   System.out.print(matrix[i][j]);
                    if (set.contains(j + 1)) {
                        continue;
                    }
                  //  System.out.println("Текущая столбец Q " + j);
                    if (matrix[i][j] == 1) {
                        if (!list.contains(j + 1)) {
                            list.add(j + 1);
                             needToChecked.add(j+1);
                            findR(j + 1, matrix, list, set);
                        }
                    }// System.out.print(matrix[i][j]);
                }
                //   System.out.println();
            }
        return list;

    }


public List<Integer> findQ(int index, int [][] matrix,List<Integer> list, Set<Integer> set ){
    start(list,index);

    Set<Integer> needToChecked = new HashSet<>();
    if (index==1){
        needToChecked.add(1);
    } else {
        needToChecked.add(index);
    }

  for (int i = index-1; i < matrix.length; i++) {

      if (set.contains(i + 1)|| !needToChecked.contains(i+1)) {
           continue;
      }
     // System.out.println("Столбец Q: " + i);
      for (int j = 0; j < matrix.length; j++) {
          if (set.contains(j + 1)) {
              continue;
          }
       //   System.out.print("Элемент" + j + i + "- " + matrix[j][i] + " ");
          //System.out.println("Текущая строка Q " +j);
          if (matrix[j][i] == 1) {
         //     System.out.print("One в M.. " + flag + " ");
              if (!list.contains(j + 1)) {
                  list.add(j + 1);
                  needToChecked.add(j+1);
        //          System.out.println("Добавляем элемент, рекурсия..");
                      findQ(j+1, matrix, list, set);
              }
          }
      }
  }
    return list;
}

    public List<Integer> drawNewGraf(int [][] matrix, Set<Integer> setG ){

         List<Integer> listFromSetG = new ArrayList<>();
         List<Integer> list = new ArrayList<>();
         listFromSetG.addAll(setG);
         int index = listFromSetG.get(0);
        for (int i = index-1; i < matrix.length; i++) {
            if ( !setG.contains(i+1)) {
                continue;
            }
            for (int j = 0; j < matrix.length; j++) {

                if (matrix[i][j] == 1) {

                    if (!setG.contains(j + 1)) {
                        list.add(j + 1);
                    }
                }
            }
        }
        return list;
    }


    public  <T> Set<T> findCommonElements(List<T> first, List<T> second) {
        return first.stream().filter(second::contains).collect(Collectors.toSet());
    }
    public  int findNextVertex(Set<Integer> set, int [][] matrix) {
        List<Integer> list = new ArrayList<>();
        try {
            for (int i = 0; i < matrix.length; i++) {
                list.add(i + 1);
            }
            list.removeAll(set);
            Collections.sort(list);
            return list.get(0);
        } catch (IndexOutOfBoundsException e) {
            //    System.out.println("Программа завершена");
        }
      return 0;
    }


}
