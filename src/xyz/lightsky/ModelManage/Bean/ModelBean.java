package xyz.lightsky.ModelManage.Bean;

import java.lang.String;

import java.util.Map;

public class ModelBean {
    public Map<String, Models> modelsMap;

    public ModelBean(Map<String, Models> modelsMap) {
        this.modelsMap = modelsMap;
    }

    public Models getModels(){
        return modelsMap.values().toArray(new Models[0])[0];
    }

    public String getModelLabel(){
        return modelsMap.keySet().toArray(new String[0])[0];
    }
}


