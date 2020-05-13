//Created by
//Hilla Bartov
//Ofir Cohen

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FourColouringMap {
    //number of polygons in map
    private static final int polygonsNum = 12;

    //Note to ourselves- Chromosome/creature=Map, genes=Polygons
    public static void main(String[] args) {
        int populationSize = 10;
        List<Chromosome> chromosomesList = new ArrayList<>();
        //Generate random Maps coloring Solutions
        for (int i = 0; i < populationSize; i++) {
            Chromosome chromosome = new Chromosome();
            chromosomesList.add(chromosome);
        }
        //Start
        RunGenerations findSolution = new RunGenerations(chromosomesList, polygonsNum);
        System.out.println("Solving Map...");
        findSolution.run();
    }
}