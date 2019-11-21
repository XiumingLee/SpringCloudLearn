package cn.xiuminglee.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author Xiuming Lee
 * @Description
 */
//@Configuration
public class KeyResolverConfiguration {

    /**
     * 编写基于请求路径的限流规则
     *  /abc
     *  /product/1
     */
    @Bean
    public KeyResolver pathKeyResolver() {
        //自定义的KeyResolver
        return new KeyResolver() {
            /**  ServerWebExchange : 下文参数 */
            public Mono<String> resolve(ServerWebExchange exchange) {
                return Mono.just( exchange.getRequest().getPath().toString());
            }
        };
    }
}
