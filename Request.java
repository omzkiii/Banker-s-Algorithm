import java.util.ArrayList;

public class Request {
    public static void request(Process process, ArrayList<Integer> req){
        //ArrayList<Process> safetySequence = new ArrayList<>();
        ArrayList<Process> queue = new ArrayList<>();
        queue = (ArrayList<Process>) Process.processes.clone();
        ArrayList<Integer> avail = new ArrayList<>();
        avail = (ArrayList<Integer>) Process.available.clone();

        System.out.println("\n\n---=======REQUEST ALGORITHM=======---");
        System.out.println("\n" + queue.get(queue.indexOf(process)).Pname + " requested " + req.toString());

        for(int j = 0; j < runner.InstanceNum; j++){
            queue.get(queue.indexOf(process)).allocArr.set(j, queue.get(queue.indexOf(process)).allocArr.get(j) +  req.get(j));
        }
        for(int j = 0; j < runner.InstanceNum; j++){
            avail.set(j, avail.get(j) - req.get(j));
        }
        for(int j = 0; j < runner.InstanceNum; j++){
            queue.get(queue.indexOf(process)).needArr.set(j, queue.get(queue.indexOf(process)).needArr.get(j) -  req.get(j));
        }

        System.out.println("\nProcess \tMax     \tAlloc       \tNeed");
        for(int i = 0; i < queue.size(); i++){
            System.out.println(queue.get(i).Pname+"      \t" + queue.get(i).maxArr.toString()+" \t" + queue.get(i).allocArr.toString()+" \t" + queue.get(i).needArr.toString());
        }
        
        System.out.println("\nAvailable ");
        System.out.println(avail.toString());
        int i = 0;
        
        int loopNum = queue.size();
        boolean safetyChecker = true;
        // if(req.get(0) <= process.needArr.get(0) && req.get(0) <= avail.get(0)
        // && req.get(1) <= process.needArr.get(1) && req.get(1) <= avail.get(1)
        // && req.get(2) <= process.needArr.get(2) && req.get(2) <= avail.get(2))
        
        if(0 <= process.needArr.get(0) && 0 <= avail.get(0)
        && 0 <= process.needArr.get(1) && 0 <= avail.get(1)
        && 0 <= process.needArr.get(2) && 0 <= avail.get(2)){



            while(!queue.isEmpty()){
                if(avail.get(2)>=queue.get(i).needArr.get(2)&&
                avail.get(1)>=queue.get(i).needArr.get(1)&&
                avail.get(0)>=queue.get(i).needArr.get(0)){
                    Process.safetySequence.add(queue.get(i));
                    
                    for(int j = 0; j < runner.InstanceNum; j++){
                        avail.set(j, queue.get(i).allocArr.get(j) +  avail.get(j));
                    }
                    System.out.println(avail.toString());
                    
                    queue.remove(i);
                    loopNum++;
                    i=0;
                }
                else
                    i++;

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

                System.out.println("\n");
            }
             else{
                System.out.println("\nPossible deadlock detected!");
            }
        }
        else
            System.out.println("\nRequest cannot be granted!");
    }
}
