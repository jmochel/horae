package org.saltations.horae;

import io.micronaut.context.ApplicationContext;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.ApplicationConfiguration;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
public class ApplicationStartupListener implements ApplicationEventListener<ServerStartupEvent>
{
        @Inject
        private ApplicationContext  context;

        @Override
        public void onApplicationEvent(ServerStartupEvent event)
        {
                log.info(">>>> Started in {} environment <<<<", context.getEnvironment().getActiveNames());
       }
}