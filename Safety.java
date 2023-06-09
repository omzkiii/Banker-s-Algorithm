import java.util.ArrayList;

public class Safety {
        
    public static void safety(){
        
        ArrayList<Process> safetySequence = new ArrayList<>();
        ArrayList<Process> queue = new ArrayList<>();
        queue = (ArrayList<Process>) Process.processes.clone();
        ArrayList<Integer> avail = new ArrayList<>();
        avail = (ArrayList<Integer>) Process.available.clone();
        
        System.out.println("---=======SAFETY ALGORITHM=======---");
        System.out.println("\nProcess \tMax     \tAlloc       \tNeed");
        for(int i = 0; i < queue.size(); i++){
            System.out.println(queue.get(i).Pname+"      \t" + queue.get(i).maxArr.toString()+" \t" + queue.get(i).allocArr.toString()+" \t" + queue.get(i).needArr.toString());
        }

        System.out.println("\nAvailable ");
        System.out.println(avail.toString());
        
        int i = 0;
        while(!queue.isEmpty()){
            if(avail.get(2)>=queue.get(i).needArr.get(2)&&
            avail.get(1)>=queue.get(i).needArr.get(1)&&
            avail.get(0)>=queue.get(i).needArr.get(0)){
                safetySequence.add(queue.get(i));
                
                for(int j = 0; j < 3; j++){
                    avail.set(j, queue.get(i).allocArr.get(j) +  avail.get(j));
                }
                System.out.println(avail.toString());
                
                queue.remove(i);
            }
            else
                i++;
            if(i==queue.size())
                i=0;
        }
    
        System.out.println("\nSAFETY SEQUENCE: ");
        for(int j = 0; j < safetySequence.size(); j++){
            System.out.print("  " + safetySequence.get(j).Pname);

        }
    }
}
