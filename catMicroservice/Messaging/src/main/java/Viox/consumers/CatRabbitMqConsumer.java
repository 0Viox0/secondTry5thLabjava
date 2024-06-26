package Viox.consumers;

import MessagingEntities.MessageModel;
import Viox.handlerChain.HandlerChainMessageManager;
import Viox.messagingMappers.MessagingMapper;
import Viox.services.CatService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class CatRabbitMqConsumer {

    private final HandlerChainMessageManager handlerChainMessageManager;

    public CatRabbitMqConsumer(
            HandlerChainMessageManager handlerChainMessageManager
    ) {
        this.handlerChainMessageManager = handlerChainMessageManager;
    }

    @RabbitListener(queues = { "cat-management-queue" })
    public MessageModel consumeMessage(MessageModel message) {
        return handlerChainMessageManager.handleMessage(message);
    }
}