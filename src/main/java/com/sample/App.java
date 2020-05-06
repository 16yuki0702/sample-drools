package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.model.Sample;

public class App {
    public static final void main(String[] args) {
        try {
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");

            Sample sample = new Sample(100);
            kSession.insert(sample);
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}