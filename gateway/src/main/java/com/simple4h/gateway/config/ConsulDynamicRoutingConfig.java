package com.simple4h.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * author Create By Simple4H
 * date 2020-11-05 16:59
 */
//@Component
@Slf4j
public class ConsulDynamicRoutingConfig implements ApplicationEventPublisherAware {

    @Autowired
    private RouteDefinitionWriter routeDefinitionWriter;

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    private void notifyChanged() {
        this.publisher.publishEvent(new RefreshRoutesEvent(this));
    }

    //增加路由
    public void add(RouteDefinition definition) {
        routeDefinitionWriter.save(Mono.just(definition)).subscribe();
        notifyChanged();
        log.info("add route success");
    }

    //更新路由
    public void update(RouteDefinition definition) {
        delete(definition.getId());
        try {
            routeDefinitionWriter.save(Mono.just(definition)).subscribe();
            this.publisher.publishEvent(new RefreshRoutesEvent(this));
            log.info("update route success");
        } catch (Exception e) {
            log.info("update exception,routeId:{},Exception:{}", definition.getId(), e);
        }
    }

    //删除路由
    public void delete(String id) {
        this.routeDefinitionWriter
                .delete(Mono.just(id))
                .then(Mono.defer(() -> Mono.just(ResponseEntity.ok().build())))
                .onErrorResume((t) -> t instanceof NotFoundException, (t) -> Mono.just(ResponseEntity.notFound().build()));
        log.info("delete route success");
    }

}
