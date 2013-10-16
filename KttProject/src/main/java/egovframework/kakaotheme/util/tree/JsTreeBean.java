package egovframework.kakaotheme.util.tree;

public class JsTreeBean {

   private String nodeId;
   private String nodeText;
   private String parentNodeId;
   private String type = "D";
   private String url;
   private String thumbNail;

   public void setType(String type) {
      this.type = type;
   }

   public void setNodeId(String nodeId) {
      this.nodeId = nodeId;
   }

   public void setNodeText(String nodeText) {
      this.nodeText = nodeText;
   }

   public void setParentNodeId(String parentNodeId) {
      this.parentNodeId = parentNodeId;
   }

   public void setThumbNail(String thumbNail) {
      this.thumbNail = thumbNail;
   }

   public void setUrl(String url) {
      this.url = url;
   }

   /**
    * 노드 id를 리턴한다.
    * 
    * @return
    */
   public String getNodeId() {
      return nodeId;
   }

   /**
    * 노드명을 리턴한다.
    * 
    * @return
    */
   public String getNodeText() {
      return nodeText;
   }

   /**
    * 부모노드의 id를 리턴한다.
    * 
    * @return
    */
   public String getParentNodeId() {
      return parentNodeId;
   }

   public String getType() {
      return type;
   }

   public String getThumbNail() {
      return thumbNail;
   }

   public String getUrl() {
      return url;
   }

   @Override
   public String toString() {
      return "nodeId " + this.nodeId + " nodeText " + this.nodeText + " parentNodeId "
            + this.parentNodeId + " icon " + this.type + " url " + this.url + " thumnail "
            + this.thumbNail;
   }

}
