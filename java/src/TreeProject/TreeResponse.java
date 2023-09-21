package TreeProject;

import java.util.Map;

public class TreeResponse {
    Map<String, TreeData> parent;

    public TreeResponse() {
    }

    public TreeResponse(Map<String, TreeData> map) {
        this.parent = map;
    }

    public Map<String, TreeData> getParent() {
        return parent;
    }

    public void setParent(Map<String, TreeData> parent) {
        this.parent = parent;
    }
}
