package scale;

import model.Automobile;




public class EditOptions implements Runnable {
    private Automobile a1;
    private String optsetName, optName, setName;

    public EditOptions(Automobile a1, String optsetName, String name, String setName) {
        this.a1 = a1;
        this.optName = name;
        this.setName = setName;
        this.optsetName = optsetName;
    }

    // Override run in runnable method syntax
    @Override
    public void run() {
        a1.updateOptName(optsetName, optName, setName);
    }


}


// public class EditOptions implements Runnable {
//     private Automobile a1;
//     private int x;
//     private int threadNo;
//     private boolean avail = false;

//     public EditOptions(int x, Automobile a1) {
//         this.a1 = a1;
//         this.x = x;
//         this.threadNo = x;
//     }

//     public void run() {
//         switch (x) {
//             case 0:
//                 System.out.println("Starting thread: " + threadNo + " Get");
//                 break;
//             case 1:
//                 System.out.println("Starting thread: " + threadNo + " Put");
//                 break;
//             case 2:
//                 System.out.println("Starting thread: " + threadNo + " Get");
//                 break;
//             case 3:
//                 System.out.println("Starting thread: " + threadNo + " Put");
//                 break;
//         }

//         ops();
//         System.out.println("Stopping thread: " + threadNo);
//     }

//     public void ops() {
//         switch (x) {
//             case 0:
//         }
//     }

//     public synchronized String get(int x, int y) {

//         while (!avail) {
//             try {
//                 System.out.println("Getting");
//                 wait();
//             } catch (InterruptedException e) {
//                 System.out.println("Getting complete");
//             }
//         }

//         this.avail = false;
//         notifyAll();
//         return this.a1.getOptName(x, y);
//     }

//     public synchronized void put(int x, int y, String setOption) {
//         try {
//             wait();
//         } catch (InterruptedException e) {

//         }
//         this.a1.setOptName(x, y, setOption);
//         this.avail = true;
//         notifyAll();
//     }

// }