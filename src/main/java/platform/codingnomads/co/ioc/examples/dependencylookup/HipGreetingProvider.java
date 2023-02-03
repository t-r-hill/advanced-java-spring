package platform.codingnomads.co.ioc.examples.dependencylookup;

public class HipGreetingProvider implements GreetingProvider{
    @Override
    public String getGreeting() {
        return "Yo yo yo!";
    }
}
