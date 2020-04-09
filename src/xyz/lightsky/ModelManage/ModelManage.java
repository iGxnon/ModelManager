package xyz.lightsky.ModelManage;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.entity.EntityHuman;
import cn.nukkit.entity.data.Skin;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.lang.String;
import net.minidev.json.JSONObject;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ModelManage extends PluginBase {


    private static LinkedHashMap<String, Skin> human_Model = new LinkedHashMap<>();
    private static LinkedHashMap<String, Skin> monster_Model = new LinkedHashMap<>();
    private static LinkedHashMap<String, Skin> pet_Model = new LinkedHashMap<>();
    private static LinkedHashMap<String, Skin> object_Model = new LinkedHashMap<>();


    @Override
    public void onEnable() {
        if(getDataFolder().mkdirs()){
            getLogger().info("首次加载中");
        }
        upDataModel();
    }

    public static void setSkin(EntityHuman human, Skin skin){
        Server.getInstance().updatePlayerListData(human.getUniqueId(), human.getId(), human.getName(), skin, Server.getInstance().getOnlinePlayers().values().toArray(new Player[0]));
    }

    public static HashMap<String, Skin> getHuman_Model() {
        return human_Model;
    }

    public static HashMap<String, Skin> getMonster_Model() {
        return monster_Model;
    }

    public static HashMap<String, Skin> getPet_Model() {
        return pet_Model;
    }

    public static HashMap<String, Skin> getObject_Model() {
        return object_Model;
    }


    private void upDataModel() {
        try {
            deBoxModel(Model.Human, true);
            deBoxModel(Model.Monster, true);
            deBoxModel(Model.Pet, true);
            deBoxModel(Model.Object, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * @param model 枚举防止手残单词拼错
     * @param isLog 是否打印到控制台
     * @throws IOException Exception
     */

    private void deBoxModel(Model model, boolean isLog) throws IOException {
        File originalDir = new File(getDataFolder() + "/"+model.name()+"/");
        for(String modelName : Objects.requireNonNull(originalDir.list())){
            File modelDir = null;
            if(!((modelDir = (new File(originalDir, modelName))).isDirectory())) continue;
            if(Objects.requireNonNull(modelDir.list()).length != 2) continue;
            Skin skin = new Skin();
            skin.setSkinId(modelName);
            for(File data : Objects.requireNonNull(modelDir.listFiles())){
                if(data.getName().endsWith(".json")){
                    String json = new String(Files.readAllBytes(data.toPath()), StandardCharsets.UTF_8);
                    skin.setGeometryData(json);
                    skin.setGeometryName(Objects.requireNonNull(getModel(data.toString())).getModelLabel());
                }else if(data.getName().endsWith(".png")){
                    skin.setSkinData(ImageIO.read(data));
                }else{
                    skin = null;
                    break;
                }
            }
            switch (model){
                case Human:
                    human_Model.put(modelName, skin);
                    break;
                case Monster:
                    monster_Model.put(modelName, skin);
                    break;
                case Pet:
                    pet_Model.put(modelName, skin);
                    break;
                case Object:
                    object_Model.put(modelName, skin);
                    break;
            }
            if(isLog) getLogger().info("成功构建 "+modelName);
        }
    }

    public static ModelBean getModel(String jsonPath) throws IOException {
        if(!(new File(jsonPath).exists())) return null;
        String json = new String(Files.readAllBytes((new File(jsonPath).toPath())));
        json = "{\"modelsMap\": " + json + "}";
        return (new Gson()).fromJson(json, ModelBean.class);
    }

}

enum Model{
    Human,
    Monster,
    Pet,
    Object
}
