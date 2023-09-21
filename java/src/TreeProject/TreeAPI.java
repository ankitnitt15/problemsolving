package TreeProject;

import java.util.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

public class TreeAPI {
    private TreeNode root;
    private Map<Integer, TreeNode> data;
    private static int id = 0;

    public TreeAPI(){
        id = id+1;
        root = new TreeNode(id, "root");
        data =new HashMap<>();
        data.put(id, root);
        id = id + 1;
    }

    public void insert(int parentId, String label){
        TreeNode child;
        TreeNode parent;
        if(data.containsKey(parentId)){
            child = new TreeNode(id, label);
            parent = data.get(parentId);
            parent.getChild().add(child);
            data.put(id, child);
            id = id + 1;
        }
        else{
            System.out.println("Invalid parentId");
        }
    }

    public List<TreeNode> get(){
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> tree = new ArrayList<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            tree.add(temp);
            List<TreeNode> c = data.get(temp.id).getChild();
            Collections.reverse(c);
            for(TreeNode node: c){
                stack.push(node);
            }
        }
        return tree;
    }

    public TreeResponse getV2(){
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeData treeData = new TreeData();
        treeData.setLabel(root.getLabel());
        List<TreeResponse> rootMap = new ArrayList<>();

        treeData.setChildren(rootMap);
        TreeResponse rootResponse = new TreeResponse();
        Map<String, TreeData> apiMap = new HashMap<>();
        apiMap.put(String.valueOf(root.getId()), treeData);
        rootResponse.setParent(apiMap);

        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            //tree.add(temp);
            List<TreeNode> c = data.get(temp.getId()).getChild();
            //Collections.reverse(c);
            for(TreeNode node: c){
                buildResponse(node, String.valueOf(temp.getId()), rootResponse);
            }
        }
        return rootResponse;
    }

    private void buildResponse(TreeNode n, String id, TreeResponse rootResponse){
        if(n == null){
            return;
        }
        TreeData treeData = new TreeData();
        treeData.setLabel(n.getLabel());
        List<TreeResponse> childMap = new ArrayList<>();

        treeData.setChildren(childMap);
        TreeResponse childResponse = new TreeResponse();
        Map<String, TreeData> apiMap = new HashMap<>();
        apiMap.put(String.valueOf(n.getId()), treeData);
        childResponse.setParent(apiMap);
        rootResponse.getParent().get(id).getChildren().add(childResponse);

        List<TreeNode> c = data.get(n.getId()).getChild();
        //Collections.reverse(c);
        for(TreeNode node: c){
            buildResponse(node, String.valueOf(n.getId()), childResponse);
        }
        return;
    }
    /*
    [
    {
        "<id>": {
            "label": "<first item>",
            "children": [
                {
                    "<id>": {
                        "label": "<another item>",
                        "children": [] // empty children
                    }
                },
                {
                    "<id>": {
                        "label": "<another item>",
                        "children": [ ...<any children>... ]
                    }
                }
            ]
        }
    }
]
     */


    class TreeNode{
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        private int id;
        private String label;

        public List<TreeNode> getChild() {
            return child;
        }

        public void setChild(List<TreeNode> child) {
            this.child = child;
        }

        private List<TreeNode> child;

        public TreeNode(int id, String label){
            this.id = id;
            this.label = label;
            child = new ArrayList<>();
        }
    }

    public static void print(List<TreeNode> res){
        for(TreeNode node: res){
            System.out.println("ID= "+node.getId()+" Label= "+node.getLabel());
        }
    }

//    public static void printV2(TreeResponse r){
//        for (String id : r.getParent().keySet())
//            System.out.println("id: " + id);
//
//        for (TreeData data : r.getParent().values()){
//            System.out.println("label: " + data.getLabel());
//            if(data.getTreeData().get("children").isEmpty()){
//                System.out.println("children:<empty>");
//                return;
//            }
//            else {
//                System.out.println("children:<parent="+data.getLabel()+">");
//                for (TreeResponse t : data.getTreeData().get("children")) {
//                    printV2(t);
//                }
//            }
//        }
//    }

    public static void main(String[] args) throws JsonProcessingException {
        TreeAPI api = new TreeAPI();
        api.insert(1, "A");
        api.insert(1, "B");
        api.insert(1, "C");
        api.insert(1, "D");
        api.insert(3, "E");
        api.insert(3, "F");
        api.insert(4, "G");
        api.insert(4, "H");
        api.insert(6, "I");
        //List<TreeNode> res = api.get();
        //print(res);

        TreeResponse r = api.getV2();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ObjectMapper ow2 = new ObjectMapper();
        ow2.disable(SerializationFeature.WRAP_ROOT_VALUE);
        ow2.disable(DeserializationFeature.UNWRAP_ROOT_VALUE);
        ObjectWriter o = ow2.writer().withDefaultPrettyPrinter();

        String json = o.writeValueAsString(r);
        //printV2(r);
        System.out.println(json);
    }
}
