package com.walmart.cucumber.steps.serenity;

import cucumber.runtime.junit.FeatureRunner;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.runners.model.InitializationError;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebAppConfiguration
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class,classes = SpringConfiguration.class)
public class CustomSerenityRunner extends CucumberWithSerenity {
    public CustomSerenityRunner(Class clazz) throws InitializationError, IOException {
        super(clazz);


        System.out.println();

//        Inner inner = new Inner(clazz);
    }



    class Inner extends SerenityRunner{

        public Inner(Class<?> klass) throws InitializationError {
            super(klass);
        }


        @Override
        public int testCount() {
            System.out.println(super.testCount());
            return super.testCount();
        }
    }


    @Override
    public List<FeatureRunner> getChildren() {


        List<FeatureRunner> children = super.getChildren();

        Iterator<FeatureRunner> iterator = children.iterator();

        while(iterator.hasNext()){
            FeatureRunner fr = iterator.next();
            if(fr.getName().contains("This is a blank")){
                iterator.remove();
            }
        }

        for (FeatureRunner fr:children) {
            System.out.println("***************" + fr.getName() + "***************");
        }


        return children;
    }
}
