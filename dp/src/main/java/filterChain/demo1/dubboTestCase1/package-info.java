/**
 *
 * 这里模仿dubbo实现的一个责任链的实现，这个和一般的实现方式不同，
 * 这个当中并没有一个容器维护当前所有的Filter的链路，而是各个filter维护下一个Filter的实现。
 *
 * @author muzhe-wang on  18-7-12 下午4:08.
 */
package filterChain.demo1.dubboTestCase1;