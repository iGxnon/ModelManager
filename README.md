# ModelManager
---
## [服主请点击我下载jar](https://github.com/iGxnon/ModelManager/releases/download/2.0.0/ModelManage.jar)
---
## 用处：
- 方便4D插件直接读取4D Skin 数据
- 反序列化Minecraft基岩版json模型
- 序列化Minecraft基岩版json模型
---
## API(以下均为静态方法):
 1. `getModel(String jsonPath)` 可以得到一个ModelBean对象
     - 参数: `jsonPath` json文件的路径
 2. `getJson(ModelBean bean)` 可以得到一个json字符串
     - 参数: `bean` ModelBean的一个实例化对象
---
## 一个解析json的Demo
```
String json = "\"geo.name\": {...}"
ModelBean bean = ModelManage.getModel(json);
Models models = bean.getModels();
List<Bones> bones = models.bones;
for(Bones bone : bones) {
  List<Cubes> cubes = bone.cubes;
  for(Cubes cube : cubes) {
    List<Double> origin = cube.origin;  //[x, y, z] 方块起点
    List<Double> size = cube.size;  //[x, y, z]  方块大小
    List<Integer> uv = cube.uv;  //[x, y]  贴图uv
  }
}
```
---
