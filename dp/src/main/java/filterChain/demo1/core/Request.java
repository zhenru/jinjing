package filterChain.demo1.core;

/**
 * @author muzhe-wang on  18-7-11 下午5:53.
 */
public class Request {

    private StringBuffer stringBuffer;

    public Request() {
        this.stringBuffer = new StringBuffer("request:");
    }

    public void append(String content){
        stringBuffer.append(" + "+content);
    }

    public String getContent(){
        return stringBuffer.toString();
    }

}
