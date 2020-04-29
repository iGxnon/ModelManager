package xyz.lightsky.ModelManage.Bean;

import java.util.List;

public class Cubes{
    public List<Double> origin;
    public List<Double> size;
    public List<Integer> uv;

    public Cubes(List<Double> origin, List<Double> size, List<Integer> uv) {
        this.origin = origin;
        this.size = size;
        this.uv = uv;
    }
}
