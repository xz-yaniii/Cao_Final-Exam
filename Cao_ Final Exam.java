import java.util.Stack;

public class Main {

    // variable declaring for creature and power level 
    static class Creature {
        String creat;
        int powerLevel;

        Creature(String creat, int powerLevel) {
            this.creat = creat;
            this.powerLevel = powerLevel;
        }

        @Override
        public String toString() {
            return creat + " - " + powerLevel;
        }
    }

    // Bubble Sort in descending order
    public static void BubbleSortDescending(Creature[] creat) {
        int n = creat.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (creat[j].powerLevel < creat[j + 1].powerLevel) {
                    // Swap
                    Creature temp = creat[j];
                    creat[j] = creat[j + 1];
                    creat[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort in ascending order
    public static void selectionSortAscending(Creature[] creat) {
        int n = creat.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (creat[j].powerLevel < creat[minIndex].powerLevel) {
                    minIndex = j;
                }
            }
            // Swap
            Creature temp = creat[minIndex];
            creat[minIndex] = creat[i];
            creat[i] = temp;
        }
    }

    // Push sorted creatures onto a stack and pop them
    public static void useStack(Creature[] creat) {
        Stack<Creature> stack = new Stack<>();

        // Push all creatures onto the stack
        for (Creature creature : creat) {
            stack.push(creature);
        }

        // Pop and display each creature
        System.out.println("\n*** Stack Implementation: Popping Creatures *");
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }
    }

    public static void main(String[] args) {
        // Input data
        Creature[] creat = {
            new Creature("Dragon ", 95),
            new Creature("Griffin", 88),
            new Creature("Unicorn", 78),
            new Creature("Phoenix", 92),
            new Creature("Centaur", 85),
        };

        // Bubble Sort for Descending Order
        Creature[] bubbleSortedCreatures = creat.clone();
        BubbleSortDescending(bubbleSortedCreatures);
        System.out.println("\n*** Bubble Sort: Descending Order by Power Level *");
        for (Creature creature : bubbleSortedCreatures) {
            System.out.println(creature);
        }

        // Selection Sort for Ascending Order
        Creature[] selectionSortedCreatures = creat.clone();
        selectionSortAscending(selectionSortedCreatures);
        System.out.println("\n*** Selection Sort: Ascending Order by Power Level *");
        for (Creature creature : selectionSortedCreatures) {
            System.out.println(creature);
        }

        // Stack Implementation using Bubble Sort result
        useStack(selectionSortedCreatures);
    }
}
