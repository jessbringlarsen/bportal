package dk.bringlarsen.bportal.repository.event;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

@Component
public class RepositoryEventListener extends AbstractRepositoryEventListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    protected void onBeforeCreate(Object entity) {
        logger.info("onBeforeCreate: " + entity.toString());
    }

    @Override
    public void onBeforeSave(Object entity) {
        logger.info("onBeforeSave: " + entity.toString());
    }

    @Override
    public void onAfterDelete(Object entity) {
        logger.info("onAfterDelete: " + entity.toString());
    }
}

