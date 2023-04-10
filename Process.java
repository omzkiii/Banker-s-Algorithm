import java.util.ArrayList;
import java.util.Arrays;

public class Process {
    public static ArrayList<Integer> totalResources = new ArrayList<>();
    public static ArrayList<Integer> available = new ArrayList<>(Arrays.asList(0,0,0));
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
        String[] arr = str.split(",", 3);
		for (int i = 0; i<3; i++){
			array.add(Integer.parseInt(arr[i]));
        }
    }

    public static void getAvailable(String res){
        ArrayList<Integer> totalAlloc = new ArrayList<>(Arrays.asList(0,0,0));
        getVal(res, totalResources);
        for(int i = 0; i < processes.size(); i++){
            for(int j = 0; j < 3; j++){
                totalAlloc.set(j, totalAlloc.get(j) + processes.get(i).allocArr.get(j));
            }
        }
        for(int j = 0; j < 3; j++){
            available.set(j, totalResources.get(j) - totalAlloc.get(j));
        }
        System.out.println("Total resources: " + totalResources.toString());
        System.out.println("Total allocation: " + totalAlloc.toString());
    }
}

