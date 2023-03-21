package com.osipov.effectivemobileproject.error;

public enum ExceptionDescriptions {
    USER_NOT_FOUND("User not found"),
    HISTORY_NOT_FOUND("History not found"),
    COMPANY_NOT_FOUND("Company not found"),
    PRODUCT_NOT_FOUND("Product not found"),
    PURCHASE_ERROR("Purchase error"),
    PRODUCT_CREATION_ERROR("Product creation error"),
    USER_DID_NOT_BUY_ITEM("The user did not buy the item"),
    DAY_PASSED("A day has passed since the purchase");

    private final String title;

    ExceptionDescriptions(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}