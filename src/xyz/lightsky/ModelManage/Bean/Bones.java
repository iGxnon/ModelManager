package xyz.lightsky.ModelManage.Bean;

import java.util.List;

public class Bones {
    public String name;
    public List<Double> pivot;
    public boolean mirror;
    public boolean neverRender;
    public String parent;
    public List<Integer> rotation;
    public List<Cubes> cubes;

    public Bones(String name, List<Double> pivot, boolean mirror, boolean neverRender, String parent, List<Integer> rotation, List<Cubes> cubes) {
        this.name = name;
        this.pivot = pivot;
        this.mirror = mirror;
        this.neverRender = neverRender;
        this.parent = parent;
        this.rotation = rotation;
        this.cubes = cubes;
    }
}