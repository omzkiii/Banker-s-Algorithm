import java.util.Scanner;

public class runner {
    static int InstanceNum;
    public static void main(String[] args) {
        Process processReq;
        //int InstanceNum;
        Scanner in = new Scanner(System.in);
        System.out.println("Predefined [1]");
        System.out.println("User defined [2]");
        int stat = in.nextInt();in.nextLine();
        switch(stat){
            case 1:
                InstanceNum = 3;

                Process p0 = new Process();
                Process p1 = new Process();
                Process p2 = new Process();
                Process p3 = new Process();
                Process p4 = new Process();
        
                Process.processes.add(p0);
                Process.processes.add(p1);  
                Process.processes.add(p2);
                Process.processes.add(p3);
                Process.processes.add(p4);
                for(int i = 0; i < InstanceNum; i++){
                    for(int j = 0; j < Process.processes.size(); j++){
                        Process.processes.get(j).maxArr.add(0);
                        Process.processes.get(j).allocArr.add(0);
                        Process.processes.get(j).needArr.add(0);
                    }
                    Process.request.add(0);
                    Process.totalResources.add(0);
                    Process.available.add(0);
                }
                
                p0.setVal("7,5,3", "0,1,0" ,"p0", p0);
                p1.setVal("3,2,2", "2,0,0", "p1", p1);
                p2.setVal("9,0,2", "3,0,2", "p2", p2);
                //p3.setVal("2,2,2", "2,1,1", "p3", p3);
                p3.setVal("2,2,2", "2,2,2", "p3", p3);
                p4.setVal("4,3,3", "0,0,2", "p4", p4);

                processReq = p1;
                Process.getAvailable("10,5,8");    
                Process.getVal("1,0,2", Process.request);
                Safety.safety();
                Request.request(processReq, Process.request);
                break;

            case 2:
                for(int i = 0; i < InstanceNum; i++){
                    Process.request.add(0);
                    Process.totalResources.add(0);
                    Process.available.add(0);
                }

                System.out.println("Enter number of processes: ");
                int processSize = in.nextInt(); in.nextLine();


                for(int i = 0; i < processSize; i++){
                    Process p = new Process();
                    for(int j = 0; j < InstanceNum; i++){
                        Process.processes.get(j).maxArr.add(0);
                        Process.processes.get(j).allocArr.add(0);
                        Process.processes.get(j).needArr.add(0);
                        }
                    System.out.println("Enter max for p" + i + " :" );
                    String max = in.nextLine();
                    System.out.println("Enter allocation for p" + i + " :" );
                    String alloc = in.nextLine();
                    String name = "p"+i;
                    p.setVal(max, alloc, name, p);
                    Process.processes.add(p);

                }
                

                System.out.println("Enter total resources: ");
                String res = in.nextLine();
                System.out.println("Enter which process will make a request: ");
                int reqIndex = in.nextInt();in.nextLine();
                processReq = Process.processes.get(reqIndex);
                System.out.println("Enter total resources: ");
                String req = in.nextLine();
                Process.getVal(req, Process.request);

                Process.getAvailable(res);


                Safety.safety();
                Request.request(processReq, Process.request);
                break;
            default:
                break;
                
        }

    }
   
}
