package ovh.herisson.tonitch.Money;

public class Money implements IMoney {
    private float Money = 100.0F;

    @Override
    public float getMoney() {
        return this.Money;
    }

    @Override
    public void setMoney(float value) {
        this.Money = value;
    }

}
