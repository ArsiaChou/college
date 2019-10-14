package bean;

public class OrderMaster {
    private String orderNo;
    private String customerNo;
    private String saleNo;
    private double orderSum;
    private String orderData;
    private String shipDate;
    private String invoiceNo;

    public OrderMaster(String orderNo, String customerNo, String saleNo, double orderSum, String orderData, String shipDate, String invoiceNo) {
        this.orderNo = orderNo;
        this.customerNo = customerNo;
        this.saleNo = saleNo;
        this.orderSum = orderSum;
        this.orderData = orderData;
        this.shipDate = shipDate;
        this.invoiceNo = invoiceNo;
    }

    public OrderMaster() {
        this(null, null, null, 0.00, null, null, null);
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getSaleNo() {
        return saleNo;
    }

    public void setSaleNo(String saleNo) {
        this.saleNo = saleNo;
    }

    public double getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(double orderSum) {
        this.orderSum = orderSum;
    }

    public String getOrderData() {
        return orderData;
    }

    public void setOrderData(String orderData) {
        this.orderData = orderData;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String toJson() {
        return "{" +
                "\"orderNo\":\"" + orderNo + "\"" +
                ", \"customerNo\":\"" + customerNo + "\"" +
                ", \"saleNo\":\"" + saleNo + "\"" +
                ", \"orderSum\":" + orderSum +
                ", \"orderData\":\"" + orderData + "\"" +
                ", \"shipDate\":\"" + shipDate + "\"" +
                ", \"invoiceNo\":\"" + invoiceNo + "\"" +
                "}";
    }

    public String getInsertSql() {
        return "INSERT INTO orderMaster (orderNo, customerNo, saleNo, orderSum, orderData, shipDate, invoiceNo) \n" +
                "VALUE ('"+orderNo+"', '"+customerNo+"', '"+saleNo+"', "+orderSum+", '"+orderData+"', '"+shipDate+"', '"+invoiceNo+"')";
    }

    public String getDeleteSql(String column, String value) {
        return "DELETE FROM orderMaster WHERE "+column+" = '"+value+"'";
    }

    public String getDeleteSql(String column, double value) {
        return "DELETE FROM orderMaster WHERE "+column+" = "+value+"";
    }

}
