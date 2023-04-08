public class runner {
    
    public static void main(String[] args) {

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

        Process.getVal("332", Process.available);
        Process.getVal("102", Process.request);

        p0.setVal("753", "010" ,"p0");
        p1.setVal("322", "200", "p1");
        p2.setVal("902", "302", "p2");
        p3.setVal("222", "211", "p3");
        p4.setVal("433", "002", "p4");
        
        Safety.safety();
        Request.request(p1, Process.request);

    }
   
}
