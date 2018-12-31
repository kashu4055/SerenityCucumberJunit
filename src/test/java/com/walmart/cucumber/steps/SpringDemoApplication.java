package com.walmart.cucumber.steps;

import com.walmart.cucumber.steps.serenity.SpringConfiguration;
import com.walmart.move.nim.springjmsutils.config.amq.AMQConnectionConfig;
import com.walmart.move.nim.springjmsutils.config.amq.AMQJmsReceiverConfig;
import com.walmart.move.nim.springjmsutils.config.amq.AMQJmsSenderConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@EnableJms

@Import({SpringConfiguration.class, AMQJmsSenderConfig.class, AMQJmsReceiverConfig.class, AMQConnectionConfig.class})
@SpringBootApplication
@EnableRetry
@ComponentScan({ "com.walmart.cucumber.steps.serenity", "com.walmart.move.nim.springjmsutils"})
@RestController
public class SpringDemoApplication {

//    @Bean
//    public RestTemplate getRestTemplate() {
//        return new RestTemplate();
//    }
//
//
//    @Bean
//    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
//                                                    DefaultJmsListenerContainerFactoryConfigurer configurer) {
//        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//        // This provides all boot's default to this factory, including the message converter
//        configurer.configure(factory, connectionFactory);
//        // You could still override some of Boot's default if necessary.
//        return factory;
//    }
//
//    @Bean // Serialize message content to json using TextMessage
//    public MessageConverter jacksonJmsMessageConverter() {
//        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
//        converter.setTargetType(MessageType.TEXT);
//        converter.setTypeIdPropertyName("_type");
//        return converter;
//    }

    @RequestMapping("/")

    public String home(){
        return "This is what i was looking for";
    }



    public static void main(String[] args) {
        // Launch the application
        ConfigurableApplicationContext context = SpringApplication.run(SpringDemoApplication.class, args);
        System.out.println("****************** This is the first line that is executed ***************");

//        WebApplicationInitializer wa = new WebApplicationInitializer() {
//            @Override
//            public void onStartup(ServletContext servletContext) throws ServletException {
//                System.out.println("************* Printing this message on startup ***************");
//            }
//        };

    }

}
