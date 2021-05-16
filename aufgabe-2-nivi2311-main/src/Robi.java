public class Robi {

    private RobiAPI robi;


    // Used to start the Robi
    public static void main(String[] args) throws InterruptedException {
        Robi r = new Robi("localhost", 52883);   // Tragen Sie hier die Portnummer auf Ihrem Simulator ein.
        // hier Robi Methoden aufrufen
        r.templateMethod();

    }

    public Robi(String hostname, int portNummer) {
        robi = new RobiAPI(hostname, portNummer);
    }

    /*
     *	Template-Methode für den Robi
     */
    public void templateMethod() throws InterruptedException {
        // Variabel deklarieren

        final int a = 0;
        final int b = 2;
        final int c = 10;
        SandUhr sandUhr = new SandUhr();
        int zustanad = a;

        robi.connect();                  // ab hier ist der Robi verbunden

//        robi.drive(5);
//        robi.turn(10);
//        System.out.println("Robi faehrt vorwaerts");
        while (zustanad == robi.readSensor(a)) {
            switch (zustanad) {
                case a: {
                    if (robi.readSensor(b) < 100) {
                        if (sandUhr.abgelaufen()) {
                            robi.drive(5);
                        }
                    } else if (robi.readSensor(c) > 100) {
                        robi.stop();
                    }
                    break;
                }
            }
        }
        // State-Machine


        robi.disconnect();              // hier wird der Robi wieder disconected


    }

}
