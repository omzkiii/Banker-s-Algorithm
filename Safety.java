import java.util.ArrayList;

public class Safety {
        
    public static void safety(){
        
        //ArrayList<Process> safetySequence = new ArrayList<>();
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
        boolean safetyChecker = true;
        int i = 0;
        int loopNum = queue.size();
        while(!queue.isEmpty()){
            //if(avail.get(2)>=queue.get(i).needArr.get(2)&&
            //avail.get(1)>=queue.get(i).needArr.get(1)&&
            //avail.get(0)>=queue.get(i).needArr.get(0)){
            
            int acounter = 0;
            for(int incounter = 0; incounter < runner.InstanceNum; incounter++){
                if(avail.get(incounter)>=queue.get(i).needArr.get(incounter))
                    acounter = acounter + 1; 
            }
            if (acounter == runner.InstanceNum){        
                Process.safetySequence.add(queue.get(i));
                
                for(int j = 0; j < runner.InstanceNum; j++){
                    avail.set(j, queue.get(i).allocArr.get(j) +  avail.get(j));
                }
                System.out.println(avail.toString());
                
                queue.remove(i);
                loopNum++;
            }
            else{
                i++;
                
            }
            if(i==queue.size())
                i=0;
            
            loopNum--;
                if(loopNum == 0){
                    queue.clear();
                    safetyChecker = false;
                }
            
        }
        
        
        if(safetyChecker == true){
            System.out.println("\nSAFETY SEQUENCE: ");
            for(int j = 0; j < Process.safetySequence.size(); j++){
                System.out.print("  " + Process.safetySequence.get(j).Pname);

            }
            Process.safetySequence.clear();
        }
        else{
            System.out.println("\nPossible deadlock detected!");
        }
    }
}
