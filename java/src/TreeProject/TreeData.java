package TreeProject;

import java.util.List;
import java.util.Map;

public class TreeData {
    public TreeData(String label, Map<String, List<TreeResponse>> treeData) {
        this.label = label;
    }

    public TreeData() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    String label;

    public List<TreeResponse> getChildren() {
        return children;
    }

    public void setChildren(List<TreeResponse> children) {
        this.children = children;
    }

    List<TreeResponse> children;
}
