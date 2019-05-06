package cn.springcloud.book.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 统计某个或者某种路由的的处理时长
 * @author xujin
 */
public class CustomGatewayFilter implements GatewayFilter, Ordered {

    private static final Log log = LogFactory.getLog(GatewayFilter.class);
    private static final String REQUEST_START_TIME = "requestStartTime";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put(REQUEST_START_TIME, System.currentTimeMillis());
        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    Long startTime = exchange.getAttribute(REQUEST_START_TIME);
                    if (startTime != null) {
                        log.info(exchange.getRequest().getURI().getRawPath() + ": "
                                + (System.currentTimeMillis() - startTime) + "ms");
                    }
                })
        );
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}

