package xyz.lightsky.ModelManage.Bean;

import com.google.gson.annotations.SerializedName;
import xyz.lightsky.ModelManage.Bean.Bones;

import java.util.List;

public class Models{
    @SerializedName("texturewidth")
    public int textureWidth;

    @SerializedName("textureheight")
    public int textureHeight;

    public int visible_bounds_width;

    public int visible_bounds_height;

    public List<Integer> visible_bounds_offset;

    public List<Bones> bones;

    public Bones getBoneFromName(String name) {
        for (Bones bones : this.bones){
            if(bones.name.equals(name)){
                return bones;
            }
        }
        return null;
    }

    public Models(int textureWidth, int textureHeight, int visible_bounds_width, int visible_bounds_height, List<Integer> visible_bounds_offset, List<Bones> bones) {
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;
        this.visible_bounds_width = visible_bounds_width;
        this.visible_bounds_height = visible_bounds_height;
        this.visible_bounds_offset = visible_bounds_offset;
        this.bones = bones;
    }

}

