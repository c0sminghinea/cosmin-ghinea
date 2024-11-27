package pages;

import org.openqa.selenium.By;

public class HomePage {

    public static By expenseButton = By.id("com.monefy.app.lite:id/expense_button");
    public static By incomeButton = By.id("com.monefy.app.lite:id/income_button");
    public static By expenseAmountText = By.id("com.monefy.app.lite:id/expense_amount_text");
    public static By incomeAmountText = By.id("com.monefy.app.lite:id/income_amount_text");
    public static By balanceButton = By.id("com.monefy.app.lite:id/balance_container");
    public static By expenseCategoryTitle = By.id("com.monefy.app.lite:id/transaction_group_header");
    public static By expenseEntry = By.id("com.monefy.app.lite:id/category_type_image_view");
    public static By deleteExpenseButton = By.id("com.monefy.app.lite:id/delete");
}
