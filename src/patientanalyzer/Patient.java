public class Patient {
    int age;
    int year;
    int positiveNodes;
    boolean survivedFiveYears;

    public Patient(int age, int year, int positiveNodes, boolean survivedFiveYears) {
        this.age = age;
        this.year = year;
        this.positiveNodes = positiveNodes;
        this.survivedFiveYears = survivedFiveYears;
    }

    public int getPositiveNodes() {
        return positiveNodes;
    }

    public boolean isSurvivedFiveYears() {
        return survivedFiveYears;
    }
    
    
            
}
