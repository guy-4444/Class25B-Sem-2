package com.guyi.validatorclass;

class StockSdk {

    public interface Callback<T> {
        void onSuccess(T data);
        void onError(String error);
    }

    public static void getCurrentPrice(String codeName, Callback<Double> callback) {
        // retrofit
        // ...
        // ...

        callback.onSuccess(123.0);
    }

    /**
     * Retrieves the opening and closing prices for the specified stock on a given date.
     *
     * @param codeName the stock symbol (e.g., "AAPL")
     * @param date     the target date in ISO format "yyyy-MM-dd" (e.g., "2021-01-01")
     * @param callback invoked with a two-element array where
     *                 <ul>
     *                   <li>index 0 is the opening price</li>
     *                   <li>index 1 is the closing price</li>
     *                 </ul>
     */
    public static void getStockOpenClose(String codeName, String date, Callback<double[]> callback) {

        double[] prices = new double[] {100.0, 120.0};
        callback.onSuccess(prices);
    }
}
