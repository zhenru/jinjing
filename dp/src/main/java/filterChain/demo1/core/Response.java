package filterChain.demo1.core;

/**
 * @author muzhe-wang on  18-7-11 下午5:56.
 */
public class Response {

    private StringBuffer responseContent;

    public Response() {
        responseContent = new StringBuffer("response :");
    }

    public void append(String content){
        responseContent.append( " - "+content);
    }

    public String getContent(){
        return responseContent.toString();
    }
}
