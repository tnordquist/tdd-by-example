package guru.springframework;

import java.util.Objects;

public class Money implements Expression {

  protected final String currency;
  protected final int amount;

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
    return amount == money.amount && Objects.equals(this.currency, money.currency);
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

  @Override
  public Expression times(int multiplier) {
    return new Money(amount * multiplier, this.currency);
  }

  @Override
  public Expression plus(Expression addend) {
    return new Sum(this, addend);
  }

}
