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

}

