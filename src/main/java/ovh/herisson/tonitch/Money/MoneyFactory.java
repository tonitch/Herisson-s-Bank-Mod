package ovh.herisson.tonitch.Money;

import java.util.concurrent.Callable;

public class MoneyFactory implements Callable<IMoney>{
    @Override
    public IMoney call() throws Exception {
        return new Money();
    }
}
