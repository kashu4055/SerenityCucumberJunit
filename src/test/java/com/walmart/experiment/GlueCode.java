package com.walmart.experiment;

import com.walmart.cucumber.steps.serenity.SpringConfiguration;
import com.walmart.move.nim.springjmsutils.config.MessagingConfig;
import com.walmart.move.nim.springjmsutils.core.MQJMSSenderFactory;
import cucumber.api.java.en.Given;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.activemq.store.kahadb.data.KahaDestination;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.support.JmsUtils;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import javax.jms.*;

import static java.util.Objects.nonNull;
import static javax.jms.Session.SESSION_TRANSACTED;
import static org.springframework.jms.support.JmsUtils.closeSession;

@ContextConfiguration(classes = {SpringConfiguration.class, MessagingConfig.class})
@Component
public class GlueCode {

    @Autowired
    @Qualifier("amqconnectionFactory")
    private ConnectionFactory connectionFactory;

    @Autowired
    private RetryTemplate retryTemplate;


    @Autowired
    private MQJMSSenderFactory mqjmsSenderFactory;

    @Value("${broker?:AMQ}")
    private String broker;


    @Value("${amq_broker_url}")
    private String brokerUrl;

//    @Value("${msg_redelivery_count}")
//    private int msgRedeliveryCount;
//
//    @Value("${msg_redelivery_delay}")
//    private int msgRedeliveryDelay;
//
//    @Value("${msg_redelivery_max_delay}")
//    private int msgRedeliveryMaxDelay;
//
//    @Value("${msg_redelivery_exponential_backoff}")
//    private boolean exponentialBackOff;
//
//    @Value("${msg_redelivery_backoff_multiplier}")
//    private int backoffMultiplier;
//
//
//    @Value("#{systemProperties['customMessage'] ?: 'some default'}")
//    private String customMessage;


    Logger logger = LogManager.getLogger(this.getClass());


    @Given("^Test Case to try pushing a message to a queue\\.$")
    public void test_Case_to_try_pushing_a_message_to_a_queue() {
        Message m = new ActiveMQTextMessage();
        try {
            ((ActiveMQTextMessage) m).setText("Hello World");
        } catch (MessageNotWriteableException e) {
            e.printStackTrace();
        }
        sendMessage(m);
    }

    private void sendMessage(Message msg){

        Session session = null;
        Connection connection = null;
        try{

            connection = connectionFactory.createConnection("admin", "admin");
            session = connection.createSession(true, SESSION_TRANSACTED);
            mqjmsSenderFactory.getMQSender(broker).sendMessage(msg.toString(), "aaa.sample.test.practice.queue", KahaDestination.DestinationType.QUEUE.toString().toLowerCase(), session);

            session.commit();

        } catch (JMSException jmsExp) {
            try {
                if (nonNull(session))
                    session.rollback();
            } catch (JMSException jmsException) {
                logger.error("Error while jms roll back {}", jmsException);
            }
            logger.error("Jms exception while publishing vtr {}", jmsExp);
            throw new RuntimeException("500", jmsExp);

        }
        finally {
            closeSession(session);
            JmsUtils.closeConnection(connection, false);
            logger.info("session & connection close for vtr trigger message");
        }

    }

//    @Test
//    public void sendQueue() throws JMSException {
//
//        String uuid = UUID.randomUUID().toString();
//        for (int i = 0; i < 2; i++) {
//            MQJMSSender mqSender = mqjmsSenderFactory.getMQSender("AMQ");
//            mqSender.sendText("test" + uuid, "sample.test.queue", "QUEUE");
//        }
//
//        System.out.println();
//    }

//    @Test
//    public void sendTopic() throws JMSException {
//
//
//
//        String uuid = UUID.randomUUID().toString();
//        for (int i = 0; i < 2; i++) {
//            MQJMSSender mqSender = mqjmsSenderFactory.getMQSender("AMQ");
//            mqSender.sendText("test" + uuid, "WMSOP.ORDER.VALIDATOR", "TOPIC");
//        }
//    }
}






