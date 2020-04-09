package xyz.lightsky.ModelManage;

import com.google.gson.annotations.SerializedName;
import java.lang.String;

import java.util.List;
import java.util.Map;

public class ModelBean {
    public Map<String, Models> modelsMap;

    public Models getModel(){
        return modelsMap.values().toArray(new Models[0])[0];
    }

    public String getModelLabel(){
        return modelsMap.keySet().toArray(new String[0])[0];
    }
}

class Models{
    @SerializedName("texturewidth")
    public int textureWidth;

    @SerializedName("textureheight")
    public int textureHeight;

    public int visible_bounds_width;

    public int visible_bounds_height;

    public List<Integer> visible_bounds_offset;

    public List<Bones> bones;

}

class Bones{
    public String name;
    public List<Double> pivot;
    public boolean mirror;
    public String parent;
    public List<Integer> rotation;
    public List<Cubes> cubes;
}

class Cubes{
    public List<Double> origin;
    public List<Double> size;
    public List<Integer> uv;
}