import java.util.ArrayList;
import java.util.Arrays;

public class Process {
    public static ArrayList<Integer> totalResources = new ArrayList<>();
    public static ArrayList<Integer> available = new ArrayList<>();
    public static ArrayList<Integer> request = new ArrayList<>();
    public static ArrayList<Process> processes = new ArrayList<>();
    public static ArrayList<Process> safetySequence = new ArrayList<>();
    ArrayList<Integer> maxArr = new ArrayList<>();
    ArrayList<Integer> allocArr = new ArrayList<>();
    ArrayList<Integer> needArr = new ArrayList<>();
    String Pname;

    public void setVal(String max, String alloc, String name, Process process) {
        getVal(max, maxArr);
        getVal(alloc, allocArr);
        for (int i = 0; i <= 2; i++) {
            int digitNeed = maxArr.get(i) - allocArr.get(i);
            // needArr.add(digitNeed);
            needArr.set(i, digitNeed);
        }
        Pname = name;
        if(max == alloc){
            Process temp = processes.get(0);
            processes.set(processes.indexOf(process), temp);
            processes.set(0, process);
        }
    }

    
    public static void getVal(String str, ArrayList<Integer> array) {
        String[] arr = str.split(",", runner.InstanceNum);
        for (int i = 0; i < runner.InstanceNum; i++) {
            // array.add(Integer.parseInt(arr[i]));
            array.set(i, Integer.parseInt(arr[i]));
        }
    }

    public static void getAvailable(String res){
        ArrayList<Integer> totalAlloc = new ArrayList<>(Arrays.asList(0,0,0));
        getVal(res, totalResources);
        for(int i = 0; i < processes.size(); i++){
            for(int j = 0; j < runner.InstanceNum; j++){
                totalAlloc.set(j, totalAlloc.get(j) + processes.get(i).allocArr.get(j));
            }
        }
        for(int j = 0; j < runner.InstanceNum; j++){
            available.set(j, totalResources.get(j) - totalAlloc.get(j));
        }
        System.out.println("Total resources: " + totalResources.toString());
        System.out.println("Total allocation: " + totalAlloc.toString());
    }
}

