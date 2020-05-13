//Created by
//Hilla Bartov
//Ofir Cohen

import biuoop.GUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RunGenerations {
    private List<Chromosome> chromosomesList;
    private int polygonsNum;

    public RunGenerations(List<Chromosome> list, int p) {
        chromosomesList = list;
        polygonsNum = p;
    }

    //Run generations until solution found
    public void run() {
        int countGenerations = 0, populationSize=this.chromosomesList.size();
        Chromosome solution = null;
        //Applying Genetic Operations until solution is found
        while (true) {
            countGenerations++;
            List<Chromosome> newGeneration = new ArrayList<>();
            int min = 12, fitness, avg = 0;
            Chromosome strongCreature = null;
            for (Chromosome creature : chromosomesList) {
                fitness = creature.fitnessFunc();
                avg += fitness;
                if (fitness < min) {
                    strongCreature = creature;
                    min = fitness;
                    if (min == 0) {
                        solution = creature;
                        break;
                    }
                }
            }

            //Statistics for Graphs
            //System.out.println(min);
            //System.out.println(avg / chromosomesList.size());

            //solution found
            if (solution != null) {
                break;
            }

            //Solution not Found- applying genetic operators

            //Crossover
            boolean flag = false;
            int i = 0, goodGenesFit = 5;
            while (i < populationSize) {
                min = 12;
                for (Chromosome creature : chromosomesList) {
                    if (strongCreature != null && creature.fitnessFunc() <= goodGenesFit) {
                        //temp Chromosome List - describing the new Population
                        newGeneration.add(creature.crossover(strongCreature, polygonsNum));
                        //count number of creatures for the new generation
                        i++;
                        if (i == 100) {
                            break;
                        }
                        strongCreature = null;
                        flag = true;
                    } else if ((fitness = creature.fitnessFunc()) <= min) {
                        min = fitness;
                        strongCreature = creature;
                    }
                }
                //when fitness under goodGenesFit=5 does'nt exist, increase good fitness level
                if (!flag) {
                    goodGenesFit++;
                }
            }
            //Update population
            chromosomesList = newGeneration;

            //Mutations
            double probability = 1;
            for (Chromosome creature : chromosomesList) {
                if (probability((int) probability * 100)) {
                    creature.mutation();
                }
            }
        }

        //Solution Found
        System.out.println("Solution found after " + countGenerations + " generations.");
        System.out.println("Displaying Solution, Please Wait...");
        //Display solution
        Solution solutionMap = new Solution(new GUI("FourColouringMap", 800, 500), solution);
        solutionMap.show();
    }

    //Flip Coin according to probability percents.
    public boolean probability(int percents) {
        Random rand = new Random();
        if (rand.nextInt(100) <= percents) {
            return true;
        }
        return false;
    }
}
