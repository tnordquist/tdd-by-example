package guru.springframework;

public class Money implements Expression {

  protected String currency;
  protected int amount;

  public Money(int amount, String currency) {
    this.amount = amount;
    this.currency = currency;
  }

  protected String currency() {
    return currency;
  }

  public static Money dollar(int amount) {
    return new Money(amount, "USD");
  }

  public static Money franc(int amount) {
    return new Money(amount, "CHF");
  }

  @Override
  public boolean equals(Object obj) {
    Money money = (Money) obj;
    return amount == money.amount && this.currency == money.currency;
  }

  @Override
  public Money reduce(Bank bank, String to) {
    return new Money(amount / bank.rate(this.currency, to), to);
  }

  @Override
  public String toString() {
    return "Money{" +
        "currency='" + currency + '\'' +
        ", amount=" + amount +
        '}';
  }

  public Money times(int multiplier) {
    return new Money(amount * multiplier, this.currency);
  }

  public Expression plus(Money addend) {
    return new Sum(this, addend);
  }

}
