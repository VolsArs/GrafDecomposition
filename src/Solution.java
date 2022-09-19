import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        Decompose decompose = new Decompose();
        int [][] matrixFromFile =  readFile.read("D:\\Lern\\MMTS\\lab1\\graf.txt").getImarix();
        Set<Integer> setG = new HashSet<>();

        List<Integer> tlistR = new ArrayList<>();
//     List<Integer> listR = decompose.findR(1,matrixFromFile,tlistR,setG);
//       System.out.println("R var:");
//      for (int i = 0; i < listR.size(); i++) {
//       System.out.print(listR.get(i)+" ");
//    }

       List<Integer> tlistQ = new ArrayList<>();
//       List<Integer> listQ = decompose.findQ(1,matrixFromFile,tlistQ,setG);
//       tlistQ = decompose.findQOtherSteps(listQ.get(2),matrixFromFile,listQ,setG);
//      listQ.addAll(tlistQ);
//       System.out.println();
//       System.out.println("Q var:");
//
//     for (int i = 0; i < listQ.size(); i++) {
//           System.out.print( listQ.get(i)+" ");
//        }

        VarietyG [] arrGvar = new VarietyG[matrixFromFile.length];
        Set<Integer> [] setArr = new Set[matrixFromFile.length];
        ArrayList<List> rLists = new ArrayList<>();
        ArrayList<List> qLists = new ArrayList<>();

        ArrayList<Set> strongConnectedGSets = new ArrayList<>();


        setArr[0]=setG;

        for (int i = 0; i < matrixFromFile.length; i++) {

           // System.out.println("SetG  в начале цикла "+setG);
            if ( decompose.findNextVertex(setArr[0],matrixFromFile)==0){
                break;
            }

            int nextValue = decompose.findNextVertex(setArr[0],matrixFromFile);

           // System.out.println("Рассматриваемая вершина " + nextValue);

            rLists.add(decompose.findR(nextValue,matrixFromFile,tlistR,setArr[0]));
            qLists.add(decompose.findQ(nextValue,matrixFromFile,tlistQ,setArr[0]));

           // System.out.println("Q SET "+qLists.get(i));
          //  System.out.println("Множества правых инценденций"+i+" "+rLists.get(i));
         //  System.out.println("Множества левых инценденций"+i+" "+qLists.get(i));

            setG = decompose.findCommonElements(rLists.get(i),qLists.get(i));

            strongConnectedGSets.add(setG);
           // setArr[0].addAll(setG);
          //  System.out.println("Сильно связанный подграф "+ i + setG);


            setArr[0].addAll(setG);

            tlistR.clear();
            tlistQ.clear();

          //arrGvar[i] = new VarietyG(setG);
        //  setArr[i] = setG;

        }
          List<Integer> connectedList = new ArrayList<>();
        for (int i = 0; i <strongConnectedGSets.size() ; i++) {
           connectedList =  decompose.drawNewGraf(matrixFromFile,strongConnectedGSets.get(i));
            System.out.println("Сильно связанный подграф "+strongConnectedGSets.get(i)+ " connected "+connectedList);
        }


    }
}
