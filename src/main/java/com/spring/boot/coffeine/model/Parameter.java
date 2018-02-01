/**
 *
 */
package com.spring.boot.coffeine.model;


/**
 * Created by khang.doan on May 27, 2016
 *
 */
public class Parameter {
    //-------------------------------COMMON--------------------------------

    public static final String ORDER_ID = "order_id";
    public static final String ORDER_INFO = "order_info";
    public static final String AMOUNT = "amount";
    public static final String DISCOUNT_AMOUNT = "discount_amount";
    public static final String FEE = "fee";
    public static final String AGENT = "agent";
    public static final String RECORD_COUNT = "record_count";
    public static final String IS_PURCHASED = "is_purchased";
    //-------------------------------REQUEST-------------------------------
    public static final String COMMAND = "command";
    public static final String ACTION = "action";
    public static final String IP = "ip";
    public static final String RETURN_URL = "return_url";
    public static final String NOTIFY_URL = "notify_url";
    public static final String SIGNATURE = "signature";
    public static final String PARTNER_CODE = "partnerCode";
    public static final String ACCESS_KEY = "accessKey";
    public static final String EXTRA_DATA = "extraData";
    public static final String REQUEST_ID = "requestId";
    public static final String REFERENCE_ID = "referenceId";
    public static final String PARTNER_CLIENT_ID = "partnerClientId";
    public static final String ERROR_CODE = "errorCode";
    public static final String LOCAL_MESSAGE = "localMessage";
    public static final String MODULE_NAME = "module_name";
    public static final String REGISTER_REQ = "REGISTER_REQ";
    public static final String OAUTH2_REQ = "OAUTH2_REQ";


    //-------------------------------RESPONSE-------------------------------
    public static final String TRANSACTION_ID = "transaction_id";
    public static final String RESULT_CODE = "status_code";
    public static final String MESSAGE = "message";
    public static final String PAY_URL = "pay_url";
    public static final String ORDER_TYPE = "order_type";
    public static final String DATE = "response_time";

    //------------------------------OTHER----------------------------------
    public static final String USER_DATA = "cacheData";
    public static final String TEST_LOCAL = "local";
    public static final String REPLACE_BILL_ID = "<billId>";
    public static final String SERVICE_START_KEY = "active";

    //------------------------------ACTION----------------------------------
    public static final String PAYMENT = "payment";

    public static final String LOG_TYPE_WARNING = "warning";
    public static final String LOG_TYPE_ERROR = "error";
    public static final String LOG_TYPE_INFO = "info";

    public static final String LOG_TYPE_PAYMENT_CREATION = "request";
    public static final String LOG_TYPE_PAYMENT_QUERY_STATUS = "query";
    public static final String LOG_TYPE_PAYMENT_GATEWAY = "gateway";
    public static final String LOG_TYPE_PAYMENT_OTP = "otp";
    public static final String LOG_TYPE_PAYMENT_DB = "database";

    public static final String CHECK_STATUS = "query_status";
    public static final String PAYMENT_REQUEST = "payment_request";

    public static final String TOKEN = "token";
    public static final String REFESH_TOKEN = "refesh_token";
    public static final String CURRENT_STEP = "currentStep";
    public static final String OTP = "otp";


}
