package logistics.turvo.com.downloadfile;

/**
 * Created by Abhishek V on 07/03/2017.
 */

public class Constants {

    public static final String CLIENT_ID = "cf4eceb0-05ba-4c71-b935-5055a322d5fa";
    public static final String CLIENT_SECRET = "123456789";
    public static final String GUEST_USER_TOKEN_TYPE = "Guest_Token_Auth";
    public static final String GUEST_USER_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImU2ZDkzOTk2Y2U3OGI3ZTFkZjc5MzAxNDg4YTEyZGYzZThiODY2MGI1ZTIwNjcyYWIzYzNmOGMxNDc2NzMyZjUyMTYyZmQ4MzdiNTdhMzdlIn0";
    public static final int LOGIN_TYPE_PARENT = 0, LOGIN_TYPE_CHILD = 1;

    public static final String EMAIL_REG_EX =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String APPLICATION_HAL_JSON = "application/hal+json";
    public static final String PROFILE_NOTIFICATION_ON = "on";
    public static final String PROFILE_NOTIFICATION_OFF = "off";
    public static final int NOTIFICATION_SETTINGS_ON = 1;
    public static final int NOTIFICATION_SETTINGS_OFF = 0;
    public static final String GENDER_MALE = "male";
    public static final String LOGIN_METHOD_FACEBOOK = "facebook";
    public static final int PASSWORD_MIN_CHARACTERS = 6;

    //intent extras
    public static final String INTENT_EXTRA_STORY_DATA = "intent_extra_story_data";
    public static final String INTENT_EXTRA_LOGIN_TYPE = "intent_extra_login_type";
    public static final String INTENT_EXTRA_CHILD_PASSWORD = "intent_extra_child_password";
    public static final String INTENT_EXTRA_CHILD_DATA = "intent_extra_child_data";
    public static final String INTENT_EXTRA_CATEGORY_NAME = "intent_extra_category_name";
    public static final String INTENT_EXTRA_TOP_CATEGORY_STORY_ITEM = "intent_extra_top_category_story_item";
    public static final String INTENT_EXTRA_SHOW_SKIP_OPTION = "intent_extra_show_skip_option";
    public static final String INTENT_EXTRA_SHOW_CONFIRM_PASSWORD = "intent_extra_show_confirm_password";
    public static final String INTENT_EXTRA_CHILD_ID = "intent_extra_child_id";
    public static final String INTENT_EXTRA_CATEGORY_ID = "intent_extra_child_id";
    public static final String INTENT_EXTRA_STORY_ID = "intent_extra_story_id";
    public static final String INTENT_EXTRA_GALLERY_DATA = "intent_extra_gallery_id";
    public static final String INTENT_EXTRA_SELECTED_POSITION = "intent_extra_selected_position";
    public static final String INTENT_EXTRA_DIALOG_TITLE = "intent_extra_dialog_title";
    public static final String INTENT_EXTRA_DIALOG_ICON_RES_ID = "intent_extra_dialog_icon_res_id";
    public static final String INTENT_EXTRA_DIALOG_ICON_URL = "intent_extra_dialog_icon_url";
    public static final String INTENT_EXTRA_DIALOG_MESSAGE = "intent_extra_dialog_message";
    public static final String INTENT_EXTRA_DIALOG_POSITIVE_BTN_TXT = "intent_extra_dialog_positive_btn_txt";
    public static final String INTENT_EXTRA_DIALOG_NEGATIVE_BTN_TXT = "intent_extra_dialog_negative_btn_txt";
    public static final String INTENT_EXTRA_SELECTED_USER = "intent_extra_selected_user";
    public static final String INTENT_EXTRA_MESSAGE = "intent_extra_message";
    public static final String INTENT_EXTRA_APP_TOUR_ITEM = "intent_extra_app_tour_item";


    //request codes
    public static final int REQUEST_CODE_CHILD_PASSWORD_PATTERN = 100;
    public static final int REQUEST_CODE_ADD_CHILD = 101;
    public static final int REQUEST_CODE_EDIT_PROFILE = 102;
    public static final int REQUEST_CODE_EDIT_CHILD = 103;
    public static final int REQUEST_CODE_PICK_IMAGE = 104;
    public static final int REQUEST_CODE_PRINT_PDF = 105;
    public static final int REQUEST_CODE_CHILD_PASSWORD_PATTERN_OVERFLOW_MENU = 105;

    public static final String CATEGORY_NAME_DIY = "Diy";
    public static final String CATEGORY_NAME_PRINTABLES = "Printables";



    public static final String KEY_WISHLIST_PRODUCT = "Wishlist Product";
    public static final String KEY_PRODUCTS_WISHLIST = "product_wishlist";


    public static final String KEY_DATA = "data";
    public static final String KEY_BODY = "body";
    public static final String KEY_TITLE = "title";
    public static final String INTENT_VIDEO_URL = "video_url";
    public static final String UN_BOXING = "un boxing";
    public static final String INTENT_EXTRA_SEARCH_QUERY = "search_query";
    public static final String NOTIFICATION_TYPE = "notification_type";
    public static final String KEY_TYPE_BIRTHDAY = "birthday";
    public static final String KEY_TYPE_FUNCTIONAL = "functional";
    public static final String KEY_TYPE_HOLIDAY = "holiday";
    public static final String KEY_TYPE_STORY = "story";
    public static final String KEY_TYPE_PRODUCT = "product";
    public static final String KEY_WEB_URL = "web_url";
    public static final String INTENT_EXTRA_WEB_PAGE_TITLE = "web_page_title";

    //fire base notification
    public static final String PROJECT_NUMBER = "1046956941642";
    public static final String KEY_GCM_REGISTRATION_ID = "key_registration_id";
    public static final String NOTIFICATION_MSG_EXTRA = "notification_data_extra";
    public static final String NOTIFICATION_ACTION = "com.smartynotification.received";
    public static final String KEY_FCM_TOPIC_NAME = "all";
    public static final String KEY_FCM_STAGING_TOPIC_NAME = "staging";

    // broadcast receiver intent filters
    public static final String REGISTRATION_COMPLETE = "registrationComplete";
    public static final String PUSH_NOTIFICATION = "pushNotification";

    // id to handle the notification in the notification tray
    public static final int NOTIFICATION_ID = 100;
    public static final int NOTIFICATION_ID_BIG_IMAGE = 101;
    public static final float CUSTOM_DIALOG_WIDTH_PERCENTAGE = 0.87f;
    public static final String KEY_UNAUTHORIZED = "unauthorized";
}
