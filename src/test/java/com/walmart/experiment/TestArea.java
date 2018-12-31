package com.walmart.experiment;

//@ContextConfiguration(classes = {SpringConfiguration.class, MessagingConfig.class})
//@RunWith(SpringJUnit4ClassRunner.class)
//@Component


//@TestPropertySource("classpath:properties/app1.properties")
//@ComponentScan({ "com.walmart.cucumber.steps", "com.walmart.move.nim.springjmsutils"})
//@Import({MessagingConfig.class})
//@TestPropertySource(properties = {"amq_broker_url=tcp://us32899s4000d0a.s32899.us.wal-mart.com:61616"})
public class TestArea {

//    @Autowired
//    @Qualifier("amqconnectionFactory")
//    private ConnectionFactory connectionFactory;
//
//    @Autowired
//    private RetryTemplate retryTemplate;
//
//
//    @Autowired
//    private MQJMSSenderFactory mqjmsSenderFactory;
//
//    @Value("${broker?:AMQ}")
//    private String broker;
//
//
//    @Value("${amq_broker_url}")
//    private String brokerUrl;
//
////    @Value("tcp://us32899s4000d0a.s32899.us.wal-mart.com:61616")
////    private String brokerUrl;
//
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
//
//
//    Logger logger = LogManager.getLogger(this.getClass());
//
//
//
//    @Test
//    public void testForJunit() {
//        Message m = new ActiveMQTextMessage();
//        try {
//            ((ActiveMQTextMessage) m).setText("Hello World");
//        } catch (MessageNotWriteableException e) {
//            e.printStackTrace();
//        }
//        sendMessage(m);
//    }
//
//
//    private void sendMessage(Message msg){
//
//        System.setProperty("customMessage","Custom Message");
//
//        Session session = null;
//        Connection connection = null;
//        try{
//
//            connection = connectionFactory.createConnection("admin", "admin");
//            session = connection.createSession(true, SESSION_TRANSACTED);
//            mqjmsSenderFactory.getMQSender(broker).sendMessage(msg.toString(), "sample.test.practice.queue", KahaDestination.DestinationType.QUEUE.toString().toLowerCase(), session);
//
//            session.commit();
//
//        } catch (JMSException jmsExp) {
//            try {
//                if (nonNull(session))
//                    session.rollback();
//            } catch (JMSException jmsException) {
////                logger.error("Error while jms roll back {}", jmsException);
//            }
////            logger.error("Jms exception while publishing vtr {}", jmsExp);
//            throw new RuntimeException("500", jmsExp);
//
//        }
//        finally {
//            closeSession(session);
//            JmsUtils.closeConnection(connection, false);
//            logger.info("session & connection close for vtr trigger message");
//        }
//
//    }

}
