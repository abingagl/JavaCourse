package gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;

/**
 * @author ：zhang
 * @title ：TODO
 * @date ：created in 2021/07/11
 */
public class ProxyBizFilter implements HttpRequestFilter {
    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        String uri = fullRequest.uri();
        System.out.println("ProxyBizFilter.filter" + uri);

        if (uri.startsWith("/hello")) {
            // do nothing
        } else {
            throw new RuntimeException("不支持的uri:" + uri);
        }

        HttpHeaders headers = fullRequest.headers();
        if (headers == null) {
            headers = new DefaultHttpHeaders();
        }
        headers.add("proxy-tag", this.getClass().getSimpleName());
    }
}
