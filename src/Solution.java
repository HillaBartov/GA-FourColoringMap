//Created by
//Hilla Bartov
//Ofir Cohen

import java.awt.*;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import java.util.List;

//Display Polygons Color
public class Solution {

    //Graphics
    private GUI gui;
    //Solution Map
    private Chromosome solution;

    public Solution(GUI _gui, Chromosome _solution) {

        this.gui = _gui;
        this.solution = _solution;
    }

    //Show GUI
    public void show() {
        DrawSurface d = this.gui.getDrawSurface();

        d.setColor(getColor(solution.getGenes()[0]));
        int x1[] = {70,350,350,70};
        int y1[] = {70,70,170,170};
        Polygon polygon1 = new Polygon(x1, y1, 4);
        d.fillPolygon(polygon1);

        d.setColor(getColor(solution.getGenes()[1]));
        int x2[] = {70,350,350,310,310,70};
        int y2[] = {170,170,310,310,220,220};
        Polygon polygon2 = new Polygon(x2, y2, 6);
        d.fillPolygon(polygon2);

        d.setColor(getColor(solution.getGenes()[2]));
        int x3[] = {70,310,310,270,270,170,170,70};
        int y3[] = {220,220,380,380,360,360,340,340};
        Polygon polygon3 = new Polygon(x3, y3, 8);
        d.fillPolygon(polygon3);

        d.setColor(getColor(solution.getGenes()[3]));
        int x4[] = {70,170,170,270,270,240,240,70};
        int y4[] = {340,340,360,360,380,380,430,430};
        Polygon polygon4 = new Polygon(x4, y4, 8);
        d.fillPolygon(polygon4);

        d.setColor(getColor(solution.getGenes()[4]));
        int x5[] = {240,340,340,240};
        int y5[] = {380,380,430,430};
        Polygon polygon5 = new Polygon(x5, y5, 4);
        d.fillPolygon(polygon5);

        d.setColor(getColor(solution.getGenes()[5]));
        int x6[] = {350,730,730,570,570,350};
        int y6[] = {70,70,230,230,170,170};
        Polygon polygon6 = new Polygon(x6, y6, 6);
        d.fillPolygon(polygon6);

        d.setColor(getColor(solution.getGenes()[6]));
        int x7[] = {350,570,570,350};
        int y7[] = {170,170,250,250};
        Polygon polygon7 = new Polygon(x7, y7, 4);
        d.fillPolygon(polygon7);

        d.setColor(getColor(solution.getGenes()[7]));
        int x8[] = {350,570,570,650,650,500,500,450,450,350};
        int y8[] = {250,250,230,230,390,390,360,360,310,310};
        Polygon polygon8 = new Polygon(x8, y8, 10);
        d.fillPolygon(polygon8);

        d.setColor(getColor(solution.getGenes()[8]));
        int x9[] = {310,450,450,500,500,340,340,310};
        int y9[] = {310,310,360,360,430,430,380,380};
        Polygon polygon9 = new Polygon(x9, y9, 8);
        d.fillPolygon(polygon9);

        d.setColor(getColor(solution.getGenes()[9]));
        int x10[] = {500,650,650,730,730,500};
        int y10[] = {390,390,230,230,430,430};
        Polygon polygon10 = new Polygon(x10, y10, 6);
        d.fillPolygon(polygon10);

        d.setColor(getColor(solution.getGenes()[10]));
        int x11[] = {0, 500, 500, 70, 70,300, 300 ,0};
        int y11[] = {0, 0, 70, 70, 430,430, 800, 800};
        Polygon polygon11 = new Polygon(x11, y11, 8);
        d.fillPolygon(polygon11);

        d.setColor(getColor(solution.getGenes()[11]));
        int x12[] = {500,800,800,300,300,730,730,500};
        int y12[] = {0,0,800,800,430,430, 70,70};
        Polygon polygon12 = new Polygon(x12, y12, 8);
        d.fillPolygon(polygon12);
        this.gui.show(d);
        Sleeper sleeper = new Sleeper();
        sleeper.sleepFor(20000);
        this.gui.close();
    }

    //Convert int to Color
    public Color getColor(int num) {
        switch (num) {
            case 0: return Color.CYAN;
            case 1: return Color.GREEN;
            case 2: return Color.MAGENTA;
            case 3: return Color.ORANGE;
            default: return null;
        }
    }

}
