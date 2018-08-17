package filterChain.demo1.core;

/**
 * @author muzhe-wang on  18-7-11 下午5:51.
 */
public interface Filter {

    public void doFilter(Request  request , Response response );
}
