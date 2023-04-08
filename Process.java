import java.util.ArrayList;

public class Process {
    public static ArrayList<Integer> available = new ArrayList<>();
    public static ArrayList<Integer> request = new ArrayList<>();
    public static ArrayList<Process> processes = new ArrayList<>();
    ArrayList<Integer> maxArr = new ArrayList<>();
    ArrayList<Integer> allocArr = new ArrayList<>();
    ArrayList<Integer> needArr = new ArrayList<>();
    String Pname;

    public void setVal(String max, String alloc, String name){
        getVal(max, maxArr);
        getVal(alloc, allocArr);
        for(int i = 0; i <= 2; i++){
            int digitNeed = maxArr.get(i) - allocArr.get(i);
            needArr.add(digitNeed);
        }
        Pname = name;
    }
    
    public static void getVal(String str, ArrayList<Integer> array){
        for(int i = 0; i <= 2; i++){
            int digit = Character.getNumericValue(str.charAt(i));
            array.add(digit);
        }
    }
}

