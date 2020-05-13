//Created by
//Hilla Bartov
//Ofir Cohen

import java.util.ArrayList;
import java.util.Random;

//Map
public class Chromosome {
    private static final int regions = 12;

    //Polygons Colors
    private int[] genes;
    //Building neighbors Matrix for the Map
    private static boolean[][] adjMatrix;

    public Chromosome() {
        this.genes = new int[regions];
        this.setGenes();
        adjMatrix = AdjMatrixFactory.buildMatrix();
    }

    //Constructor
    public Chromosome(int[] _genes) {
        this.genes = _genes;
    }

    public int[] getGenes() {
        return this.genes;
    }

    private void setGenes() {
        Random random = new Random();
        for (int j = 0; j < regions; j++) {
            //Fills every polygon in map in random color.
            genes[j] = random.nextInt(4);
        }
    }

    //Fitness function- returns number of neighbors polygons with same color
    public int fitnessFunc() {
        int violationCounter = 0, polygonColor;
        int chromLength = this.getGenes().length;
        //iterate over neighbors Matrix and chromosome's genes colors
        for (int i = 0; i < chromLength; i++) {
            //Color of current polygon being checked
            polygonColor = this.getGenes()[i];
            for (int j = 0; j < chromLength; j++) {
                //polygon and adjMatrix[i][j] are neighbors and share the same Color
                if (adjMatrix[i][j] && (polygonColor == this.getGenes()[j])) {
                    violationCounter++;
                    break;
                }
                //next polygon in genes
            }
        }
        return violationCounter;
    }

    //Create Mutation in Chromosome in given probability
    public Chromosome mutation() {
        Random rand = new Random();
        //choose one of the 12 genes to be changed
        int selectedGen = rand.nextInt(12);
        this.getGenes()[selectedGen] = rand.nextInt(4);
        return this;
    }

    public Chromosome crossover(Chromosome parent1, int polygonsNum) {
        int[] genes = new int[polygonsNum];
        Random rand = new Random();
        int crossover = rand.nextInt(12);
        for (int i = 0; i < crossover; i++) {
            genes[i] = parent1.getGenes()[i];
        }
        for (int i = crossover; i < genes.length; i++) {
            genes[i] = this.getGenes()[i];
        }
        Chromosome child = new Chromosome(genes);
        return child;
    }
}
